plugins {
    java
    application
}

group = "com.university"
version = "1.0.0"

application {
    mainClass.set("CourseEnrollmentSystem")
}

repositories {
    mavenCentral()
}

sourceSets {
    main {
        java {
            srcDirs(".")  // Look in root directory
            include("*.java")
            exclude("build/**", "gradle/**", ".gradle/**")
        }
        output.dir(file("build/classes/java/main"))
    }
    
    test {
        java {
            srcDirs("test")  // Create this if you have tests
        }
        output.dir(file("build/classes/java/test"))
    }
}

tasks.jar {
    manifest {
        attributes("Main-Class" to "CourseEnrollmentSystem")
    }
    
    // Explicitly depend on main compilation, exclude test classes
    dependsOn(tasks.compileJava)
    from(sourceSets.main.get().output)
    
    // Explicitly exclude test classes if they exist
    exclude("**/*Test.class")
}

// Configure compilation tasks
tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.named<JavaExec>("run") {
    standardInput = System.`in`
}

// Clean task configuration
tasks.clean {
    delete("build", "*.class")
}

// Explicitly define task dependencies to avoid the warning
tasks.named("assemble") {
    dependsOn(tasks.jar)
}

// If you don't have tests, disable test tasks
tasks.named<Test>("test") {
    enabled = false  // Disable tests if you don't have any
}

tasks.named("compileTestJava") {
    enabled = false  // Disable test compilation if no tests
}