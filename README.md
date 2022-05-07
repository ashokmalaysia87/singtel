# java-cucumber-Singtel(ManageTodos)

A Project created to manage the Todos.
#testing
# Instructions

1. Install Java.
2. Install Eclipse IDE for Java.

Clone the repo from Git:

option 1:

1. Launch Eclipse IDE
2. Goto File-> Import -> Git -> Projects from Git
3. Select Clone URL from select Repository source screen
4. Paste the GIT URL "https://github.com/ashokmalaysia87/singtel.git"
5. key in username and password i have shared you through the Email
6. Select the Branch selection as Master and click Next
7. Choose the destination directory and click Next
8. Once the import is done. select import existing eclipse projects and Click next
9. Click Finish button and project is added to the Package explorer


option 2:

1. Download the project ZIP file from Github "https://github.com/ashokmalaysia87/singtel.git"
2. Launch Eclipse IDE
3. Goto File-> Import -> Existing projects into workspace
4. Select Archive file and Browse to locate the Project zip file
5. Check add project to working set and Click Finish and project is added to the Package explorer

# Prerequisites

In order to Execute the tests in th Chrome browser , Selenium will need the chromedriver that is installed to your system.
Download the chrome driver compatible with your system.
For example if the chrome using Version 76.0.3809.87 (Official Build) (64-bit) , then download the chromedriver of same verison

1. Download chromedriver and replace it under /Singtel/src/test/resources/drivers/
2. verify maven and other library files under maven dependency and Refernced Libraries

*IMPORTANT*

There are totally 6 features

1. CreateTodo.feature
2. RemoveTodo.feature
3. ValidateitemsLeft.feature
4. ViewActiveTodo.feature
5. ViewAllTodo.feature
6. ViewCompletedTodo.feature

# RUN:

Specify a particular feature or all features (and use the pretty plugin, which prints the scenario back)

To Run all features

@CucumberOptions(features = {"src/test/resources/Features"}

To Run a specific feature

@CucumberOptions(features = {"src/test/resources/Features/CreateTodo.feature"}

Reports are generated in Html reports file under "/Singtel/target/cucumber-reports"

For example a JUnit formatter:

@CucumberOptions(features = {"src/test/resources/Features"},glue = {"Stepdefinitions"},
plugin = { "pretty", "html:target/cucumber-reports" },monochrome = true)
