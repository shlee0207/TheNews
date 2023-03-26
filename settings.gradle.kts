pluginManagement {
    includeBuild("plugins")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "TheNews"
include(":app")
include(":core:design")
include(":feature:mynews")
include(":feature:bookmarks")
include(":feature:interests")
include(":core:domain")
include(":core:model")
