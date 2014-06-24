require 'json'
require 'fileutils'
require './string_util.rb'

$destination_dir = "generated"
$source_dir = "samples"
$all_migrations_file_path = "#{$destination_dir}/migrations/all.xml"
$common_columns = ["anm_id", "instance_id", "entity_id", "form_name", "client_version", "server_version", "form_data_definition_version"]

File.delete($all_migrations_file_path)  if File.exists?($all_migrations_file_path)

def read_sample_files
  print "\n !!! Starting the generating script !!! \n"

  count = 0
  Dir.foreach($source_dir) do |item|
    next if item == '.' or item == '..' or !item.include?(".json")
    count += 1
    puts "\n processing : " + item.gsub(".json", "") + " form"

    data_json = JSON.parse(File.read('samples/' + item))

    generate_class_file data_json
    generate_migration_script data_json, count
  end

  print "\n !!! Done generating !!! \n"
end

def get_java_type field_value
  # return "Integer" if field_value.integer?
  # return "Boolean" if field_value.bool?
  # return "Date" if field_value.date?
  return "String"
end

def get_sql_type field_value
  # return "integer" if field_value.integer?
  # return "boolean" if field_value.bool?
  # return "date" if field_value.date?
  return "varchar(255)"
end

def generate_migration_script form_data, count
  form_name = form_data['formName']
  current_field_map = {}

  file_content = ""
  file_content += "<changeSet id=\"#{count}\" author=\"maha\">\n"
  file_content += "<createTable tableName=\"" + form_name + "\">\n"
  file_content += "<column name=\"id\" type=\"bigint\" autoIncrement=\"true\">\n"
  file_content += "<constraints primaryKey=\"true\" nullable=\"false\"/>\n"
  file_content += "</column>\n"

  $common_columns.each do |column|
    file_content += "<column name=\"#{column}\" type=\"varchar(255)\"/>\n\n"
  end

  form_data["formInstance"]["form"]["fields"].each do |fieldHash|
    next if current_field_map.has_key?(fieldHash["name"])
    current_field_map[fieldHash["name"]] = true

    field = fieldHash["name"] == "id" ? fieldHash["source"] : fieldHash["name"]

    file_content += "<column name=\"#{field.to_column_name}\" type=\"#{get_sql_type(fieldHash["value"])}\"/>\n\n"
  end
  file_content += "</createTable>\n"
  file_content += "</changeSet>\n"

  write_to_file file_content, "#{$destination_dir}/migrations/#{count.to_s}_#{form_name}.xml"

  File.open($all_migrations_file_path, 'a') do |file|
    file.puts file_content
    file.puts "\n"
  end
end

def generate_class_file form_data
  form_name = form_data['formName']
  className = form_name.to_camel_case
  current_field_map = {}

  file_content = ""
  file_content += "package app.model;\n\n"
  file_content += "import com.fasterxml.jackson.annotation.JsonProperty;\n"
  file_content += "import lombok.Data;\n"
  file_content += "import javax.persistence.*;\n\n"
  file_content += "@Entity\n"
  file_content += "@Data\n"
  file_content += "@Table(name = \"#{form_name}\")\n"
  file_content += "public class #{className} extends EntityForm{"
  file_content += "\n"

  form_data["formInstance"]["form"]["fields"].each do |fieldHash|
    if current_field_map.has_key?(fieldHash["name"]) then
      puts "#{form_name} has duplicate key for: #{fieldHash["name"]}"
      next
    end
    current_field_map[fieldHash["name"]] = true

    field = fieldHash["name"] == "id" ? fieldHash["source"] : fieldHash["name"]

    file_content += "@Column(name = \"#{field.to_column_name}\")\n"
    file_content += "@JsonProperty(\"" + fieldHash["name"] + "\")\n"
    file_content += "private #{get_java_type(fieldHash["value"])} #{field.to_field_name};\n"
    file_content += "\n"
  end
  file_content += "}"

  write_to_file file_content, "#{$destination_dir}/classes/#{className}.java"
end

def create_dirs(dir)
  unless File.directory?(dir)
    FileUtils.mkdir_p(dir)
  end
end

def write_to_file content, file_path
  File.open(file_path, 'w') do |file|
    file.puts content
  end
end

create_dirs $destination_dir
create_dirs($destination_dir + "/classes")
create_dirs($destination_dir + "/migrations")

read_sample_files