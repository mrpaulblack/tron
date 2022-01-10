[![Java CI with Gradle](https://github.com/mrpaulblack/tron/actions/workflows/gradle.yml/badge.svg)](https://github.com/mrpaulblack/tron/actions/workflows/gradle.yml)

# Tron
This is going to be a tron clone with a UDP Client/Server supporting multiple sessions and using JavaFX for the client GUI.


### Development

This Repo uses Gradle.

* Fork this repo

* Clone your fork on your local machine

* Craete a new branch

* (Optional; only if you do not have gradle already) First setup `Gradle` with `GradleWrapper` : On Linux `./gradlew`; on Windows `./gradlew.bat`

* Make your changes to `client/src/` and/or `server/src/` and or `game/src/` (the main folder contains the prgr src; the test folde containts the JUnit tests)

* Write unit tests for your changes in the same class/file with `Test` added to the name in the test folder for the subproject

* Compile your src changes : for client `gradle :client:build`; for server `gradle :server:build`; for game `gradle :game:build`

* Run the Junit Tests for your src : for client `gradle :client:test`; for server `gradle :server:test`; for game `gradle :game:build`

* Execute your compiled program : for client `gradle :client:run`; for server `gradle :server:run`; game connot be executed since its a java lib

* Commit your changes with a PR


### Client/Server Usage

*Comming soon*
