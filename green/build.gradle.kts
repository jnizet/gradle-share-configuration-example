plugins {
    base
}

tasks {
    assemble {
        doLast {
            println("I'm green: not a JVM project")
        }
    }
}
