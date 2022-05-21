import AppDependencies.accompanist
import AppDependencies.androidTestLibraries
import AppDependencies.coroutines
import AppDependencies.hilt
import AppDependencies.lifeCycle
import AppDependencies.navigation
import AppDependencies.retrofit
import AppDependencies.testLibraries
import AppDependencies.compose

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs.kotlin")
}

apply(from = "versioning.gradle")

android {
    compileSdk = 32

    defaultConfig {
        applicationId = AppConfig.appId
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = AppConfig.androidTestInstrumentation
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
            )
        }

//        all {
//            buildConfigField("String", "BASE_URL", baseUrl)
//        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs = commonCompileArgs
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = AppDependencies.Version.compose
    }
    packagingOptions {
        resources.excludes.add("/META-INF/{AL2.0,LGPL2.1}")
    }
}

dependencies {
    implementation(AppDependencies.coreKtx)
    implementation(AppDependencies.appcompat)
    implementation(AppDependencies.androidxAnnotation)
    implementation(AppDependencies.material)
    implementation(AppDependencies.dataStorePreferences)
    implementation(AppDependencies.timber)

    compose()
    coroutines()
    hilt()
    navigation()
    lifeCycle()
    retrofit()
    accompanist()

    testLibraries()
    androidTestLibraries()
}

kapt {
    correctErrorTypes = true
}