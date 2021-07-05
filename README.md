# Gauge Example
This is an example (simple evaluation) of using Gauge, Java and Selenium to create a black-box web UI integration test suite.

Below are my personal notes.

## Installation
on MacOSX:
* ```brew install gauge``` (picked up version 0.9.4)
* ```gauge install java``` (the java language plugin)
* ```gauge install html-report``` (the reporting plugin)

then to test install, run ```gauge version```.

## Create project
* ```gauge init java_maven_selenium``` (prompts for project name etc.)

creates example project containing:
* .gitignore
* manifest.json
* env/default/default.properties and java.properties
* libs/
* specs/example.spec
* src/test/java - example step defs and noddy web driver wrapper & factory (singleton)

can run the example tests using ```gauge run specs```.

writes results to console and creates:
* logs/api.log and gauge.log
* reports/html-report
* gauge_bin (compiled classes)
* .gauge (failures.json)


## Evaluation
Built a simple example covering:
* unit tests for the tests _ok when using maven (test framework under src/main, junit tests under src/test)_
* selenium tests _covered by java_maven_selenium template_
* parallel running with rerun:
   * **enable_multithreading** setting determines if separate processes (runners) or just multiple threads in one runner are used
   * if running in parallel, can use spec/scenario datastore and before/after events to share webdriver instance between steps 
     in a given thread - works regardless of processes/threads and **gauge_clear_state_level** settings
* high levels steps, calling low level steps, calling code:
   * Note the Gauge Intellij plugin performs syntax checking (highlighting errors) in .spec/.md files and also with Java step defs (params etc)
   * step def parameters are always in double quotes (or &lt; &gt; for data sources)
   * Java step def parameters are type converted at runtime
   * Can have step def aliases (different phrases mapping to same java method)
   * Comments are included in the resulting report
   * high level steps calling low level steps
      * see example.spec - high level step (passing params)
      * see concept1.cpt - low level steps (using params)
      * generated report shows both (expand to see low level steps) with param values
   * plain text data loaded from files
      * see example2.spec, data/flat-text-file.txt and checkText method in StepImplementation
      * multi-line text is loaded as a string
      * generated report uses a link to the actual file
   * data loaded from .csv format spreadsheets
      * see example.spec and usersTableStep method in StepImplementation
      * step def is called once with table of values, not once per row
      * generated report uses a link to the actual file
   * using data in hard coded table in .spec file
      * see example.spec and usersTableStep method in StepImplementation (same method as .csv table above)
      * step def is called once with table of values, not once per row
      * generated report embeds data as HTML table of values
* test execution events - global start/stop, test start/stop, etc.
   * see ```com.example.ExecutionHooks``` - can do before/after suite/spec/scenario/step, and get access to the current spec/scenario/step
   * can set ```gauge_clear_state_level``` to ```suite```, ```spec``` or ```scenario``` - sets the scope of each step definition/execution hook instance
      (i.e. created per test scenario, test spec, or test suite)
   * no DI integration, but can use built in datastores per scenario/spec/suite (works on serial but not parallel)
* reports _ok, covered by the reporting plugin_
   * reports include all ```.spec``` contents, and each test scenario steps
   * can only take screenshots if errors (clickable image embedded to the right of a stacktrace), not if no error
      (would need to add custom code to take screenshots for tests/steps, or request this as a new feature)


## Using the gauge gradle plugin
See [gauge-gradle-plugin](https://github.com/manupsunny/gauge-gradle-plugin) and [build.gradle](build.gradle)
Seems to be out of date with the latest gauge runtime arg formats, and limited documentation.
_(latest release v1.5.0 uploaded to bintray but github was v1.4.5)_

Run tests in serial by ```./gradlew gauge```

Dumps logs to console (stdout) unable to set log levels, ```--verbose```/```--log-level``` flags ignored, ```logback.xml``` ignored.
Not attempted to place framework code under ```src/main``` and unit tests under ```src/test```
_gave up trying to use it_

## Using the gauge maven plugin
See [gauge-maven-plugin](https://github.com/getgauge/gauge-maven-plugin) and [pom.xml](pom.xml)
Upgraded to latest selenium (had to exclude old guava dep from gauge-java).
Adding ```logback.xml``` worked, gets extra log written as well as api.log, gauge.log
To handle gauge tests in ```src/main``` and junit in ```src/test```:
* added ```maven-failsafe-plugin``` to enable new phase *integration-test*
* set ```gauge-maven-plugin``` to use *integration-test* phase
* set gauge deps to be *default* scope, not *test* scope

To run just the junit tests:
* ```mvn test```

To run gauge tests in serial (also runs junit tests and any other QA phases...):
* ```mvn integration-test```

Note: can set properties by name in maven plugin configuration, or at the command line: *-D&lt;property&gt;=&lt;value&gt;*
* Use **tags** = *"..expression.."* to run feature specs/scenarios that match the expression, 
  which can be tag names with or (**|**)/and (**&**)/not (**!**)
* Use **specsDir** = 
   * *&lt;file&gt;* to run a specific feature spec e.g. ```-DspecsDir=specs/example.spec```, or 
   * *&lt;file&gt;:line* to run a specific scenario (*line* is line number of the title of the scenario) e.g. ```-DspecsDir=specs/example2.spec:10```
* Use **env** = *&lt;name&gt;* to choose which configuration settings (under ```env```) to use

To run tests in *n* parallel streams (where *n* is optional max, actually executes one process/thread per spec not scenario):
* ```mvn integration-test -DinParallel=true -Dnodes=n```
