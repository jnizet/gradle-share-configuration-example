import org.jetbrains.kotlin.gradle.plugin.KotlinPluginWrapper
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jmailen.gradle.kotlinter.KotlinterExtension
import org.jmailen.gradle.kotlinter.KotlinterPlugin

plugins {
    kotlin("jvm") apply false
    id("org.jmailen.kotlinter") apply false
}

subprojects {
    // using project.plugins.withType makes sure that the action is executed after the plugin
    // has been applied by the subproject.
    plugins.withType<KotlinterPlugin> {
        the<KotlinterExtension>().disabledRules = arrayOf("import-ordering", "final-newline")
    }
    plugins.withType<JavaPlugin> {
        the<JavaPluginExtension>().sourceCompatibility = JavaVersion.VERSION_1_8
        repositories.mavenCentral()
        tasks.withType<Test> {
            useJUnitPlatform()
        }
    }
    plugins.withType<KotlinPluginWrapper> {
        tasks.withType<KotlinCompile> {
            kotlinOptions {
                freeCompilerArgs = listOf("-Xjsr305=strict")
                jvmTarget = "1.8"
            }
        }
    }
    plugins.withType<JacocoPlugin> {
        tasks.withType<JacocoReport> {
            reports {
                xml.setEnabled(true)
                html.setEnabled(true)
            }
        }
    }
}
