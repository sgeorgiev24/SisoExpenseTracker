object AppConfig {
    const val compileSdk = 31
    const val minSdk = 26
    const val targetSdk = 31

    const val versionCode = 1
    const val versionName = "1.0"

    const val appId = "com.github.sgeorgiev24.sisoexpensetracker"
    const val androidTestInstrumentation = "androidx.test.runner.AndroidJUnitRunner"
    const val dimension = "environment"

    enum class Flavor(
        val flavorName: String,
        val useNameAsApplicationIdSuffix: Boolean = true,
        val dimension: String = AppConfig.dimension,
        val hasSourceSet: Boolean = true
    ) {
        Production("production", useNameAsApplicationIdSuffix = false, hasSourceSet = false),
        Develop("develop"),
        Stable("stable")
    }
}