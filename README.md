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


### Deploying plugin

#### 1. Clone codebase
The plugin API is currently part of the Logstash codebase so you must have a local copy of that available. 
You can obtain a copy of the Logstash codebase with the following git command:  
```sh
git clone --branch <branch_name> --single-branch https://github.com/elastic/logstash.git <target_folder>
```
The branch_name should correspond to the version of Logstash containing the preferred revision of the Java plugin API.
```sh
The GA version of the Java plugin API is available in the 7.2 and later branches of the Logstash codebase.
```
Specify the `target_folder` for your local copy of the Logstash codebase. If you do not specify `target_folder`, 
it defaults to a new folder called `logstash` under your current folder.

#### 2. Generate the .jar file

After you have obtained a copy of the appropriate revision of the Logstash codebase, you need to compile it to generate 
the .jar file containing the Java plugin API. From the root directory of your Logstash codebase ($LS_HOME), you can 
compile it with `./gradlew assemble` (or gradlew.bat assemble if you’re running on Windows). This should produce the
`$LS_HOME/logstash-core/build/libs/logstash-core-x.y.z.jar` where `x`, `y`, and `z` refer to the version of Logstash.  

After you have successfully compiled Logstash, you need to tell your Java plugin where to find the
`logstash-core-x.y.z.jar` file. Create a new file named `gradle.properties` in the root folder of your plugin project. 
That file should have a single line:
```sh
LOGSTASH_CORE_PATH=<target_folder>/logstash-core
```

where `target_folder` is the root folder of your local copy of the Logstash codebase.

#### 3. Package and deploy

Running the Gradle packaging task  
https://www.elastic.co/guide/en/logstash/8.10/java-output-plugin.html#_running_the_gradle_packaging_task_4

#### 4. Installing the Java plugin in Logstash  
Installing plugin   
https://www.elastic.co/guide/en/logstash/8.10/java-output-plugin.html#_installing_the_java_plugin_in_logstash_4

#### 5. Running Logstash with the Java output plugin

Running Logstash   
https://www.elastic.co/guide/en/logstash/8.10/java-output-plugin.html#_running_logstash_with_the_java_output_plugin

### YDB Output Configuration Options

 Configuration Options  | Value type | Required |
|-----------------------|------------|----------|
| connection_string     | String     | yes      |
| sa_key_file           | String     | yes      |
| table                 | String     | yes      |
| columns               | String     | yes      |

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


