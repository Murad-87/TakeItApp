pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "TakeItApp"
include(":app")
include(":network")
include(":common")
include(":ui-kit")
include(":feature-messages")
include(":feature-home")
include(":feature-add-publication")
include(":feature-user-publication")
include(":feature-settings")
include(":authentication-flow")
include(":core-database")
include(":core-data")
include(":feature-api")
