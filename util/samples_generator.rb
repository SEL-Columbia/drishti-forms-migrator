require 'json'
require 'fileutils'

# require "net/http"
# require "uri"
#
# uri = URI.parse("https://smartregistries.org/form-submissions?anm-id=demo1&timestamp=0")
#
# http = Net::HTTP.new(uri.host, uri.port)
# http.use_ssl = true
# request = Net::HTTP::Get.new(uri.request_uri)
# request.basic_auth("demo1", "1")
# response = http.request(request)
#
# File.open('all.json', 'w') do |file|
#   file.puts response.body
# end

$picked_data = {}
$destination_dir = "samples"
$data_json_array = JSON.parse(File.read('all.json'))

$data_json_array.each do |form|
  formInstance = JSON.parse form["formInstance"]
  count = formInstance["form"]["fields"].count { |x| x.has_key? "value" }

  if($picked_data[form["formName"]].nil? || $picked_data[form["formName"]]['count'] < count) then
    $picked_data[form["formName"]] = {
        'data' => form,
        'count' => count
    }
  end
end

$picked_data.each do |formName, data|
  File.open($destination_dir + "/" + formName + '.json', 'w') do |file|
    data['data']['formInstance'] = JSON.parse data['data']['formInstance']
    file.puts data['data'].to_json
  end
end