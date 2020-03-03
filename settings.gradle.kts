pluginManagement {
    plugins {
        // other plugins not configured in buildSrc could still be here
    }
}

rootProject.name = "gradle-share-configuration-example"

include("platform", "red", "blue", "green")
