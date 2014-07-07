##Drishti Content Migrator Service

[![Build Status](https://travis-ci.org/eneyed/drishti.svg?branch=master)](https://travis-ci.org/eneyed/drishti)

This is a service that has a scheduled batch job that runs and converts the data from the no sql db to relational db

The following are the dependencies to run this project:

* [Gradle](http://www.gradle.org/) for build
* [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html/)


###How to run:
 Once the code is checkout-out you can
  
* To build the project and run all the tests:

```
$./gradlew build
```

* To start the application(via code base) and batch job :

```
$./gradlew run
```

* To clean the db and run migrations :

```
$./gradlew cleandb migrations
```


###Rest Endpoint

There is also a rest endpoint where we can post the payload directly to `http://localhost:8080/form`

Ex, POST `http://localhost:8080/form` with the sample JSON data :
```
{
     "anmId": "demo1",
     "instanceId": "404-id",
     "entityId": "abc-id",
     "formName": "foo-form",
     "formInstance": {
         "form_data_definition_version": "1",
         "form": {
             "bind_type": "mother",
             "default_bind_path": "/model/instance/",
             "fields": [
                 {
                     "name": "id",
                     "value": "404-d",
                     "source": "mother.id"
                 },
                 {
                     "name": "closeReason",
                     "value": "its really critical",
                     "source": "mother.closeReason"
                 },
                 {
                     "name": "deathDate",
                     "value": "2013-08-11",
                     "source": "mother.deathDate"
                 }
             ]
         }
     },
     "clientVersion": "1378970016595",
     "serverVersion": "1378970226852",
     "formDataDefinitionVersion": "1"
 }
```

This request would create a row in the corresponding table


###Project Util

There is a ruby utility that will generate the java class and the corresponding migration script for a given sample form data.

This utility can be run when there is any new forms that needs to be added.

The sample json file that contains the form sample is place under `util/samples` directory

Once the sample json is placed, you can run

```
$ruby generator.rb
```

This will create java class file into `util/generated/classes` folder and migration script into `util/generated/migrations` folder