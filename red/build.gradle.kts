plugins {
    `java-library`
    kotlin("jvm")
    id("org.jmailen.kotlinter")
    jacoco
    id("com.colors.sharedsettings")
}

dependencies {
    api(platform(project(":platform")))
    api(kotlin("stdlib-jdk8"))
    implementation("org.slf4j:slf4j-api")
    testImplementation("org.junit.jupiter:junit-jupiter")
    // ...
}

