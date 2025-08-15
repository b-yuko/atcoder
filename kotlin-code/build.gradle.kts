plugins {
    kotlin("jvm") version "2.2.0"
    id("org.jlleitschuh.gradle.ktlint") version "13.0.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}

ktlint {
    version.set("1.7.1")
    verbose.set(true)

    reporters {
        reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.CHECKSTYLE)
    }
}
