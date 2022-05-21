// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
//     ./gradlew ktlintCheck
    id(BuildDependencies.ktlint.name) version BuildDependencies.ktlint.version
//     ./gradlew dependencyUpdates
    id(BuildDependencies.versions.name) version BuildDependencies.versions.version
}

buildscript {
    repositories {
        google()
        mavenCentral()
        maven("https://plugins.gradle.org/m2/")
        maven("https://jitpack.io")
    }

    dependencies {
        classpath("com.android.tools.build:gradle:7.2.0")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.40.1")
        classpath("com.google.gms:google-services:4.3.10")
        classpath("com.google.firebase:firebase-crashlytics-gradle:2.8.1")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.4.1")
    }
}

allprojects {
    apply {
        plugin(BuildDependencies.ktlint.name)
        plugin(BuildDependencies.versions.name)
    }

    repositories {
        google()
        mavenCentral()
        maven("https://plugins.gradle.org/m2/")
        maven("https://jitpack.io")
    }

    ktlint {
        debug.set(false)
        version.set(BuildDependencies.Version.ktlint)
        verbose.set(false)
        android.set(true)
        outputToConsole.set(true)
        ignoreFailures.set(false)
        enableExperimentalRules.set(false)
        // wildcard imports needed for compose for now
        disabledRules.set(listOf("no-wildcard-imports", "max-line-length", "import-ordering", "final-newline"))
        filter {
            exclude("**/generated/**")
            include("**/kotlin/**")
            include("**/java/**")
        }
    }
}

tasks {
    register("clean", Delete::class.java) {
        delete(rootProject.buildDir)
    }
}