pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        // other repositories...
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "MyToDoApp"
include(":app")
