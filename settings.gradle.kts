// settings.gradle.kts
pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
 plugins {
        id("com.android.application") version "8.2.2" apply false
        id("org.jetbrains.kotlin.android") version "1.9.22" apply false
        id("org.jetbrains.kotlin.kapt") version "1.9.22" apply false
        
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

rootProject.name = "livegemini"
include(":livegeminiapi")
