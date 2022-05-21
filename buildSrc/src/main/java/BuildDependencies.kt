object BuildDependencies {
    // plugins
    val ktlint = NameVersion("org.jlleitschuh.gradle.ktlint", "10.1.0")
    val versions = NameVersion("com.github.ben-manes.versions", "0.39.0")

    object Version {
        val ktlint = "0.41.0"
        val jacoco = "0.8.7"
    }
}

data class NameVersion(val name: String, val version: String) {
    operator fun invoke() = "$name:$version"
}

