plugins {
    java
    application
}

application {
    mainClass.set("CourseEnrollmentSystem")
}

repositories {
    mavenCentral()
}

sourceSets {
    main {
        java {
            srcDirs("src")
        }
    }
}

tasks.jar {
    manifest {
        attributes("Main-Class" to "CourseEnrollmentSystem")
    }
}