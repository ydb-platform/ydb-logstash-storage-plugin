[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://github.com/ydb-platform/ydb-logstash-storage-plugin/blob/main/LICENSE)

# LogStash storage plugin for [YDB](https://ydb.tech/).

## Getting Help

For questions about the plugin, open a topic in the [Discuss](https://discuss.elastic.co/) 
forums. For bugs or feature requests, open an issue in 
[Github](https://github.com/logstash-plugins/logstash-integration-elastic_enterprise_search). 
For the list of Elastic supported plugins, please consult the 
[Elastic Support Matrix](https://www.elastic.co/support/matrix#matrix_logstash_plugins).

## Description

Output plugin logstash for sending data to [YDB](https://ydb.tech/).

## Documentation

Logstash provides infrastructure to automatically generate documentation for this plugin. We use the asciidoc format to write documentation so any comments in the source code will be first converted into asciidoc and then into html. All plugin documentation are placed under one [central location](http://www.elastic.co/guide/en/logstash/current/).

- For formatting code or config example, you can use the asciidoc `[source,ruby]` directive
- For more asciidoc formatting tips, see the excellent reference here https://github.com/elastic/docs#asciidoc-guide

## Need Help?

Need help? Try #logstash on freenode IRC or the https://discuss.elastic.co/c/logstash discussion forum.

## Developing

### 1. Plugin Developement and Testing

#### Code
- To get started, you'll need JRuby with the Bundler gem installed.

- Create a new plugin or clone and existing from the GitHub [logstash-plugins](https://github.com/logstash-plugins) organization. We also provide [example plugins](https://github.com/logstash-plugins?query=example).

- Install dependencies
```sh
bundle install
```

#### Test

- Update your dependencies

```sh
bundle install
```

- Run tests

```sh
bundle exec rspec
```

### 2. Running your unpublished Plugin in Logstash

#### 2.1 Run in a local Logstash clone

- Edit Logstash `Gemfile` and add the local plugin path, for example:
```ruby
gem "logstash-output-ydb", :path => "/your/local/logstash-output-ydb"
```
- Install plugin
```sh
# Logstash 2.3 and higher
bin/logstash-plugin install --no-verify

# Prior to Logstash 2.3
bin/plugin install --no-verify

```
- Run Logstash with your plugin
```sh
bin/logstash -e 'output {awesome {}}'
```
At this point any modifications to the plugin code will be applied to this local Logstash setup. After modifying the plugin, simply rerun Logstash.

#### 2.2 Run in an installed Logstash

You can use the same **2.1** method to run your plugin in an installed Logstash by editing its `Gemfile` and pointing the `:path` to your local plugin development directory or you can build the gem and install it using:

- Build your plugin gem
```sh
gem build logstash-output-ydb.gemspec
```
- Install the plugin from the Logstash home
```sh
# Logstash 2.3 and higher
bin/logstash-plugin install --no-verify

# Prior to Logstash 2.3
bin/plugin install --no-verify

```
- Start Logstash and proceed to test the plugin

### 3. YDB Output Configuration Options

* **connection_string**   
  Database [connection path](https://ydb.tech/en/docs/concepts/connect#endpoint).   
  Value type is string.  
  Example: "grpcs://ydb.serverless.yandexcloud.net:2135/?database=/ru-central1/b1glv..."  
  Required - yes
* **sa_key_file**  
  The path to the file with the [Service Account Key](https://ydb.tech/en/docs/concepts/auth).  
  Value type is string.  
  Example: "C:/Users/ydb/authorized_key.json"  
  Required - yes
* **table**  
  The name of the table in which the data will be saved. If there is no table in the database, it will be created.  
  Value type is string.  
  Example: "test_table"  
  Required - yes
* **columns**  
  The name of the columns and their
  [data types](https://ydb.tech/en/docs/yql/reference/types/primitive?ysclid=lnk9l3q0bu575933036) in YDB separated by
  commas. Odd - column name, even - column
  [type](https://ydb.tech/en/docs/yql/reference/types/primitive?ysclid=lnk9l3q0bu575933036).  
  Value type is string.  
  Example: "time, Timestamp, number, Int64, date, Datetime, otherNumber, Int16"  
  Required - yes
