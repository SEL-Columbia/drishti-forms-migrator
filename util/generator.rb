require 'json'
require 'fileutils'
require './string_util.rb'

$destination_dir = "generated"
$source_dir = "samples"
$common_columns = [ "anm_id", "instance_id", "entity_id", "form_name", "client_version", "server_version", "form_data_definition_version"]

def read_sample_files
  print "\n !!! Starting the generating script !!! \n"

  count = 0
  Dir.foreach($source_dir) do |item|
    next if item == '.' or item == '..' or !item.include?(".json")
    count += 1
    puts "\n processing : " + item.gsub(".json","") + " form"

    data_json = JSON.parse(File.read('samples/' + item))

    generate_class_file data_json
    generate_migration_script data_json, count
  end

  print "\n !!! Done generating !!! \n"
end

def get_java_type field_value
  return "Integer" if field_value.integer?
  return "Boolean" if field_value.bool?
  return "Date" if field_value.date?
  return "String"
end

def get_sql_type field_value
  return "integer" if field_value.integer?
  return "boolean" if field_value.bool?
  return "date" if field_value.date?
  return "varchar(255)"
end

def generate_migration_script form_data, count
  form_name = form_data['formName']
  current_field_map = {}
  File.open($destination_dir + "/migrations/#{count.to_s}_#{form_name}.xml", 'w') do |file|
    file.puts "<changeSet id=\"#{count}\" author=\"maha\">\n"
    file.puts "<createTable tableName=\"" + form_name + "\">\n"
    file.puts "<column name=\"#{form_name + "_id"}\" type=\"bigint\" autoIncrement=\"true\">\n"
    file.puts "<constraints primaryKey=\"true\" nullable=\"false\"/>\n"
    file.puts "</column>\n"

    $common_columns.each do |column|
      file.puts "<column name=\"#{column}\" type=\"varchar(255)\"/>\n\n"
    end

    form_data["formInstance"]["form"]["fields"].each do |fieldHash|
      next if current_field_map.has_key?(fieldHash["name"])
      current_field_map[fieldHash["name"]] = true
      field = fieldHash["name"].to_underscore

      file.puts "<column name=\"" + field.gsub(".", "_") +"\" type=\"#{get_sql_type(fieldHash["value"])}\"/>\n\n"
    end

    file.puts "</createTable>\n"
    file.puts "</changeSet>\n"
  end
end

def generate_class_file form_data
  form_name = form_data['formName']
  className = form_name.to_camel_case
  id_column_name = form_name + "_id"
  current_field_map = {}

  File.open($destination_dir + "/classes/" + className + '.java', 'w') do |file|
    file.puts "package app.model;\n\n"
    file.puts "import com.fasterxml.jackson.annotation.JsonProperty;\n"
    file.puts "import lombok.Data;\n"
    file.puts "import javax.persistence.*;\n\n"
    file.puts "@Entity\n"
    file.puts "@Data\n"
    file.puts "@Table(name = \"#{form_name}\")\n"
    file.puts "public class #{className} extends EntityForm{"
    file.puts "@Id\n"
    file.puts "@Column(name = \"#{id_column_name}\")\n"
    file.puts "@GeneratedValue(strategy = GenerationType.IDENTITY)\n"
    file.puts "private long " + id_column_name.to_camel_case_lower + ";\n"
    file.puts "\n"

    form_data["formInstance"]["form"]["fields"].each do |fieldHash|
      next if current_field_map.has_key?(fieldHash["name"])
      current_field_map[fieldHash["name"]] = true

      field = fieldHash["name"]
      file.puts "@Column(name = \"" + field.to_underscore.gsub(".", "_") + "\")"
      file.puts "@JsonProperty(\"" + field.gsub(".", "_") + "\")"
      file.puts "private #{get_java_type(fieldHash["value"])} " + field.gsub(".", "_") + ";"
      file.puts "\n"
    end

    file.puts "}"
  end
end

def create_dirs(dir)
  unless File.directory?(dir)
    FileUtils.mkdir_p(dir)
  end
end


create_dirs $destination_dir
create_dirs($destination_dir + "/classes")
create_dirs($destination_dir + "/migrations")

read_sample_files