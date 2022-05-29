import org.gradle.api.artifacts.dsl.DependencyHandler

object AppDependencies {

    object Version {
        const val appCompat = "1.3.0"
        const val compose = "1.1.0"
        const val composeActivity = "1.3.1"
        const val hiltVersion = "2.38.1"
        const val kotlinCoroutines = "1.5.1"
        const val navigation = "2.3.5"
        const val timber = "5.0.1"
        const val navigationCompose = "2.4.0-alpha08"
        const val dataStorePreference = "1.0.0"
        const val material = "1.3.0"
        const val retrofit = "2.9.0"
        const val okHttp = "4.9.0"
        const val accompanist = "0.24.1-alpha"
    }

    fun DependencyHandler.compose() {
        implementation(compose)
    }

    fun DependencyHandler.firebase() {
        add("implementation", platform("com.google.firebase:firebase-bom:29.0.4"))
        implementation(firebase)
    }

    fun DependencyHandler.coroutines() {
        implementation(coroutines)
    }

    fun DependencyHandler.navigation() {
        implementation(navigation)
    }

    fun DependencyHandler.lifeCycle() {
        implementation(lifeCycle)
    }

    fun DependencyHandler.retrofit() {
        implementation(retrofit)
    }

    fun DependencyHandler.accompanist() {
        implementation(accompanist)
    }

    fun DependencyHandler.hilt() {
        add("implementation", "com.google.dagger:hilt-android:${Version.hiltVersion}")
        add("kapt", "com.google.dagger:hilt-compiler:${Version.hiltVersion}")
    }

    fun DependencyHandler.testLibraries() {
        implementation(Test.testLibraries)
    }

    fun DependencyHandler.androidTestLibraries() {
        implementation(AndroidTest.androidTestLibraries)
    }

    const val androidxAnnotation = "androidx.annotation:annotation:1.2.0"
    const val appcompat = "androidx.appcompat:appcompat:${Version.appCompat}"
    const val material = "com.google.android.material:material:${Version.material}"
    const val coreKtx = "androidx.core:core-ktx:1.7.0"
    const val timber = "com.jakewharton.timber:timber:${Version.timber}"
    const val dataStorePreferences =
        "androidx.datastore:datastore-preferences:${Version.dataStorePreference}"

    private val firebase = dependencies(
        "com.google.firebase:firebase-analytics-ktx",
        "com.google.firebase:firebase-crashlytics-ktx",
        "com.google.firebase:firebase-auth"
    )

    @Suppress("UnstableApiUsage")
    private val compose = dependencies(
        "androidx.compose.ui:ui:${Version.compose}",
        "androidx.compose.material:material:${Version.compose}",
        "androidx.compose.ui:ui-tooling:${Version.compose}",
        "androidx.activity:activity-compose:${Version.composeActivity}",
        "androidx.compose.runtime:runtime-livedata:${Version.compose}"
    )

    private val coroutines = dependencies(
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.kotlinCoroutines}",
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.kotlinCoroutines}",
        "org.jetbrains.kotlinx:kotlinx-coroutines-play-services:${Version.kotlinCoroutines}"
    )

    private val hilt = dependencies(
        "com.google.dagger:hilt-android:${Version.hiltVersion}"
    )

    private val navigation = dependencies(
        "androidx.navigation:navigation-compose:${Version.navigationCompose}",
        "com.google.accompanist:accompanist-navigation-material:0.18.0",
        "androidx.navigation:navigation-ui-ktx:${Version.navigation}",
        "androidx.hilt:hilt-navigation-compose:1.0.0-alpha03",
    )

    private val lifeCycle = dependencies(
        "androidx.lifecycle:lifecycle-runtime-ktx:2.4.0-alpha01",
        "androidx.lifecycle:lifecycle-extensions:2.2.0",
    )

    private val retrofit = dependencies(
        "com.squareup.retrofit2:retrofit:${Version.retrofit}",
        "com.squareup.retrofit2:converter-gson:${Version.retrofit}",
        "com.squareup.okhttp3:okhttp:${Version.okHttp}",
        "com.squareup.okhttp3:logging-interceptor:${Version.okHttp}"
    )

    private val accompanist = dependencies(
        "com.google.accompanist:accompanist-navigation-animation:${Version.accompanist}",
        "com.google.accompanist:accompanist-navigation-material:${Version.accompanist}",
        "com.google.accompanist:accompanist-insets-ui:${Version.accompanist}",
        "com.google.accompanist:accompanist-systemuicontroller:${Version.accompanist}",
        "com.google.accompanist:accompanist-swiperefresh:${Version.accompanist}",
        "com.google.accompanist:accompanist-pager:${Version.accompanist}"
    )

    object Test {
        private object Version {
            // versions common to app dependencies, not referenced externally
            const val androidXJUnit = "1.1.3"
            const val kotest = "4.6.1"
        }

        // here define groups of dependencies and an associated extension function
        val testLibraries = dependencies(
            // keep alphabetized
            "androidx.arch.core:core-testing:2.1.0",
            "androidx.test.ext:junit:${Version.androidXJUnit}",
            "androidx.test.ext:junit-ktx:${Version.androidXJUnit}",
            "app.cash.turbine:turbine:0.6.0",
        )
    }

    object AndroidTest {
        private object Version {
            const val androidXJUnit = "1.1.3"
            const val espresso = "3.4.0"
            const val composeJUnit4 = "1.0.2"
        }

        val androidTestLibraries = dependencies(
            "androidx.test.ext:junit:${Version.androidXJUnit}",
            "androidx.test.espresso:espresso-core:${Version.espresso}",
            "androidx.compose.ui:ui-test-junit4:${Version.composeJUnit4}"
        )
    }

    private fun dependencies(vararg dependency: String) =
        arrayListOf<String>().apply {
            addAll(dependency)
        }
}

val commonCompileArgs = listOfNotNull(
    "-Xuse-experimental=kotlinx.coroutines.ExperimentalCoroutinesApi",
    "-Xuse-experimental=androidx.compose.ui.ExperimentalComposeUiApi",
    "-Xuse-experimental=androidx.compose.animation.ExperimentalAnimationApi",
    "-Xuse-experimental=com.google.accompanist.permissions.ExperimentalPermissionsApi"
)

fun DependencyHandler.implementation(dependency: String) {
    add("implementation", dependency)
}

fun DependencyHandler.implementation(list: List<String>) {
    list.forEach { dependency ->
        add("implementation", dependency)
    }
}


fun DependencyHandler.testImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("testImplementation", dependency)
    }
}

fun DependencyHandler.api(list: List<String>) {
    list.forEach { dependency ->
        add("api", dependency)
    }
}