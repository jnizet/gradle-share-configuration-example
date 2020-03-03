import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `java-library`
    kotlin("jvm")
    id("org.jmailen.kotlinter")
    jacoco
}

java.sourceCompatibility = JavaVersion.VERSION_1_8

kotlinter {
    disabledRules = arrayOf("import-ordering", "final-newline")
}

repositories {
    mavenCentral()
}

tasks {
    test {
        useJUnitPlatform()
    }

    withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "1.8"
        }
    }

    jacocoTestReport {
        reports {
            xml.setEnabled(true)
            html.setEnabled(true)
        }
    }
}

dependencies {
    api(kotlin("stdlib-jdk8"))
    implementation("org.slf4j:slf4j-api:1.7.30")
    testImplementation("org.junit.jupiter:junit-jupiter:5.6.0")
    // ...
}

