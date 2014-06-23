require 'json'
require 'fileutils'
require './string_util.rb'

$destination_dir = "generated"
$source_dir = "samples"

def read_sample_files
  print "\n !!! Starting the generating script !!! \n"

  Dir.foreach($source_dir) do |item|
    next if item == '.' or item == '..'

    data_json = JSON.parse(File.read('samples/' + item))
    puts "\n processing : " + data_json['formName'] + " form"

    generate_class_file data_json
    generate_migration_script data_json
  end

  print "\n !!! Done generating !!! \n"
end


def generate_migration_script form_data
  form_name = form_data['formName']
  File.open($destination_dir + "/migrations/" + form_name + '.xml', 'w') do |file|
    file.puts "<createTable tableName=\"" + form_name + "\">\n"
    file.puts "<column name=\"#{form_name + "_id"}\" type=\"bigint\" autoIncrement=\"true\">\n"
    file.puts "<constraints primaryKey=\"true\" nullable=\"false\"/>\n"
    file.puts "</column>\n"

    form_data["formInstance"]["form"]["fields"].each do |fieldHash|
      field = fieldHash["name"].to_underscore
      file.puts "<column name=\"" + field +"\" type=\"varchar(255)\"/>\n"
      file.puts "\n"
    end

    file.puts "</createTable>\n"
  end
end

def generate_class_file form_data
  form_name = form_data['formName']
  className = form_name.to_camel_case
  id_column_name = form_name + "_id"

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
      field = fieldHash["name"]
      file.puts "@Column(name = \"" + field.to_underscore + "\")"
      file.puts "@JsonProperty(\"" + field + "\")"
      file.puts "private String " + field + ";"
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