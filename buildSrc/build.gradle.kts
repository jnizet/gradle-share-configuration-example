plugins {
    `kotlin-dsl`
}

kotlinDslPluginOptions {
    experimentalWarning.set(false)
}

repositories {
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    implementation(gradleApi())

    // having the plugins in the classpath here apparently has the same effect
    // as declaring them in the pluginManagemet block of the root settings.gradle.kts file:
    // other projects don't need to specify their versions anymore when applying them
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.61")
    implementation("org.jmailen.gradle:kotlinter-gradle:2.3.2")
}
