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

## 1. Running plugin in Logstash

Packaging, installation and running of the plugin - https://www.elastic.co/guide/en/logstash/8.10/java-output-plugin.html#_running_the_gradle_packaging_task_4

## 2. YDB Output Configuration Options

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
