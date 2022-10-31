plugins {
    java
    id("io.qameta.allure") version "2.11.2"
}

repositories {
    mavenCentral()
}

configurations {
    implementation {
        //In case of conflict, Gradle by default uses the newest of conflicting versions.
        resolutionStrategy.failOnVersionConflict()
    }
}

val jUnitvesrion = "5.9.1"

dependencies {
    testImplementation("com.codeborne:selenide:6.8.1")
    testImplementation("io.qameta.allure:allure-selenide:2.19.0")
    testImplementation("org.junit.jupiter:junit-jupiter-api:${jUnitvesrion}")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:${jUnitvesrion}")
    testImplementation("org.junit.jupiter:junit-jupiter-params:${jUnitvesrion}")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    testRuntimeOnly("org.slf4j:slf4j-simple:2.0.3")
    constraints {
        implementation("com.google.quava:guava:31.1-jre") {
            because("lastest compatible version with all dependencies")
        }
    }
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(11))
    }
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
    testLogging.showExceptions = true
    maxParallelForks = 3
    systemProperties["selenide.headless"] = System.getProperty("selenide.headless")
    maxHeapSize = "1G"
}