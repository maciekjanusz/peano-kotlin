import com.beust.kobalt.plugin.application.application
import com.beust.kobalt.plugin.packaging.assemble
import com.beust.kobalt.project

val proj = project {
    name = "peano-kotlin"
    group = "com.maciekjanusz"
    artifactId = name
    version = "0.1"

    dependencies {
        compile("org.jetbrains.kotlin:kotlin-stdlib:1.1.3-2")
    }

    dependenciesTest {

    }

    assemble {
        jar {

        }
    }

    application {
        mainClass = "com.maciekjanusz.PeanoKt"
    }
}
