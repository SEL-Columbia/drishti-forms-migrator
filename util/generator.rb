require 'json'
require 'fileutils'

print "\n !!! Starting the generating script !!! \n"

$data_json = JSON.parse(File.read('samples/1.json'))
$destination_dir = "generated"
$fileName = $data_json['formName']
print "\n file name : " + $fileName

unless File.directory?($destination_dir)
  FileUtils.mkdir_p($destination_dir)
end

def generate_migration_script
  File.open($destination_dir + "/" + $fileName + '.xml', 'w') do |file|
    file.puts "<createTable tableName=\"" + $fileName + "\">\n"
    file.puts "<column name=\"id\" type=\"bigint\" autoIncrement=\"true\">\n"
    file.puts "<constraints primaryKey=\"true\" nullable=\"false\"/>\n"
    file.puts "</column>\n"

    $data_json["formInstance"]["form"]["fields"].each do |fieldHash|
      field = fieldHash["name"]
      if field == "id" then
        next
      end;
      file.puts "<column name=\"" + field +"\" type=\"varchar(255)\"/>\n"
      file.puts "\n"
    end

    file.puts "</createTable>\n"
  end
end

def generate_class_file
  File.open($destination_dir + "/" + $fileName + '.java', 'w') do |file|
    file.puts "package app.model;\n\n"
    file.puts "import com.fasterxml.jackson.annotation.JsonProperty;\n"
    file.puts "import lombok.Data;\n"
    file.puts "import javax.persistence.*;\n\n"
    file.puts "@Entity\n"
    file.puts "@Data\n"
    file.puts "@Table(name = \"" + $fileName + "\")\n"
    file.puts "public class " + $fileName + " extends EntityForm{"
    file.puts "@Id\n@GeneratedValue(strategy = GenerationType.IDENTITY)\nprivate long id;\n"
    file.puts "\n"

    $data_json["formInstance"]["form"]["fields"].each do |fieldHash|
      field = fieldHash["name"]
      if field == "id" then
        next
      end;
      file.puts "@Column(name = \"" + field + "\")"
      file.puts "@JsonProperty(\"" + field + "\")"
      file.puts "private String " + field + ";"
      file.puts "\n"
    end

    file.puts "}"
  end
end

generate_class_file
generate_migration_script

print "\n !!! Done generating !!! \n"