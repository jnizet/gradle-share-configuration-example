package com.colors.gradle

import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPlugin
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.api.tasks.testing.Test
import org.gradle.kotlin.dsl.the
import org.gradle.kotlin.dsl.withType
import org.gradle.testing.jacoco.plugins.JacocoPlugin
import org.gradle.testing.jacoco.tasks.JacocoReport
import org.jetbrains.kotlin.gradle.plugin.KotlinPluginWrapper
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jmailen.gradle.kotlinter.KotlinterExtension
import org.jmailen.gradle.kotlinter.KotlinterPlugin

class SharedSettingsPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        // using project.plugins.withType makes sure that the action is executed after the plugin
        // has been applied, allowing to apply this plugin before or after the plugins that it reacts to
        project.plugins.withType<KotlinterPlugin> {
            project.the<KotlinterExtension>().disabledRules = arrayOf("import-ordering", "final-newline")
        }
        project.plugins.withType<JavaPlugin> {
            project.the<JavaPluginExtension>().sourceCompatibility = JavaVersion.VERSION_1_8
            project.repositories.mavenCentral()
            project.tasks.withType<Test> {
                useJUnitPlatform()
            }
        }
        project.plugins.withType<KotlinPluginWrapper> {
            project.tasks.withType<KotlinCompile> {
                kotlinOptions {
                    freeCompilerArgs = listOf("-Xjsr305=strict")
                    jvmTarget = "1.8"
                }
            }
        }
        project.plugins.withType<JacocoPlugin> {
            project.tasks.withType<JacocoReport> {
                reports {
                    xml.setEnabled(true)
                    html.setEnabled(true)
                }
            }
        }
    }
}
