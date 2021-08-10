# qa-ci-reporter 🐘

This is a wrapper plugin that provides possibility to upload test results to different reporting systems.

## Features 🎨

- Upload Allure results to the [Allure Docker Service](https://github.com/fescobar/allure-docker-servicen)
- Upload JUnit results to the [TestRail](https://www.gurock.com/testrail/)

## How to use 👣
#### 1. Import the plugin
* build.gradle
```
plugins {
    ...
    id "com.github.kormachevt.qa.ci.reporter.plugin" version "0.1.4"
}
```

* make sure to add these repoitories to the settings.gradle
```
pluginManagement {
    repositories {
        ...
        gradlePluginPortal()
        mavenCentral()
        maven {
            setUrl("https://jitpack.io")
        }
    }
}
```


#### 2. You want to upload allure results to the Allure Docker Service
* Maybe You also want to send telegram notification with report summary
```
./gradlew publishToAllure \
    --results-dir="build/allure-results/" \
    --url="https://allure.somecompany.com/allure-api" \
    --project-id="local" \
    --username="admin" \
    --password="qwerty12345" \
    --project-name="Test Project" \
    --tags="smoke" \
    --env="test" \
    --trigger="nightly build" \
    --send-notification="true" \
    --telegram-bot-token="1234567890:12345678901234567890123456789012345" \
    --telegram-chat-id="-123456789" \
```
* You can disable sending the notification
```
./gradlew publishToAllure \
    --results-dir="build/allure-results/" \
    --url="https://allure.somecompany.com/allure-api" \
    --project-id="local" \
    --username="admin" \
    --password="qwerty12345" \
    --project-name="Test Project" \
    --tags="smoke" \
    --env="test" \
    --trigger="nightly build" \
    --send-notification="false" \
```

list of the optional options:
1. --trigger (default = "default")
1. --batch-size (default = "300")
1. --send-notification (default = "false")
1. --project-name (default = "default")
1. --telegram-bot-token (no default value)
1. --telegram-chat-id (no default value)

#### 3. You want to upload JUnit results to the TestRail

```
./gradlew publishToTestRail \
    --results-dir="example/build/allure-results/" \
    --url="https://somecompany.testrail.io/" \
    --login="username" \
    --password="qwerty12345" \
    --env="dev" \
    --title="Automated Tests" \
    --suite_id=1 \
    --skip-close-run=true
```
list of the optional options:  
1. --skip-close-run (default = false)

## Libraries in use ♻️
1. Heavily modified version of the [testrail-cli](https://github.com/Open-MBEE/testrail-cli) by Open-MBEE. 
   * fixed skipped test reporting 
   * reduced/sliced log length due to TestRail is returning 413 for some extensively logged tests.
2. [allure-notifications](https://github.com/qa-guru/allure-notifications) by qa-guru    
