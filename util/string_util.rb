require 'date'

class String
  def to_underscore
    self.gsub(/::/, '/').
        gsub(/([A-Z]+)([A-Z][a-z])/, '\1_\2').
        gsub(/([a-z\d])([A-Z])/, '\1_\2').
        tr("-", "_").
        downcase
  end

  def to_camel_case
    return self if self !~ /_/ && self =~ /[A-Z]+.*/
    split('_').map { |e| e.capitalize }.join
  end

  def to_camel_case_lower
    self.split('_').inject([]) { |buffer, e| buffer.push(buffer.empty? ? e : e.capitalize) }.join
  end

  def integer?
    true if Integer(self) rescue false
  end

  #http://apidock.com/ruby/DateTime/strftime
  def date?
    begin
      return (self.match(/^\d{4}-\d{2}-\d{2}$/) && Date.strptime(self, "%Y-%m-%d")) || Date.strptime(self, "%a, %d %b %Y")
    rescue
      return false
    end
  end

  def bool?
    return self.downcase == "true" || self.downcase == "false"
  end
end