/*
 * Gradle build file for server.
 */

plugins {
    // Apply the application plugin to add support for building a CLI application in Java.
    application
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    // Use JUnit test framework.
    testImplementation("junit:junit:4.13.2")

    // This dependency is used by the application.
    implementation("org.json:json:20211205")
    implementation(project(":game"))
}

application {
    // Define the main class for the application.
    mainClass.set("com.github.mrpaulblack.tron.Server")
}
