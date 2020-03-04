pluginManagement {
    plugins {
        kotlin("jvm") version "1.3.61"
        id("org.jmailen.kotlinter") version "2.3.1"
    }
}

rootProject.name = "gradle-share-configuration-example"

include("platform", "red", "blue", "green")
