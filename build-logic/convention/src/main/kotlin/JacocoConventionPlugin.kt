import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.testing.Test
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.register
import org.gradle.kotlin.dsl.withType
import org.gradle.testing.jacoco.plugins.JacocoPluginExtension
import org.gradle.testing.jacoco.tasks.JacocoReport

class JacocoConventionPlugin : Plugin<Project> {
    override fun apply(project: Project) = with(project) {
        val fileFilter = listOf(
            "**/R.class",
            "**/R$*.class",
            "**/BuildConfig.*",
            "**/Manifest*.*",
            "**/*Test*.*",
            "android/**/*.*"
        )

        plugins.withId("jacoco") {
            extensions.configure<JacocoPluginExtension> {
                toolVersion = "0.8.14"
            }

            tasks.withType<Test>().configureEach {
                setExcludes(listOf("jdk.internal.*"))
            }

            tasks.register<JacocoReport>("jacocoTestReport") {
                dependsOn("testDebugUnitTest")
                group = "ReportingSonar"
                description = "Generate Jacoco coverage reports after running tests. Path: ${project.path}"

                reports {
                    xml.required.set(true)
                    html.required.set(true)
                    csv.required.set(false)
                }

                val mainSrc = listOf("$projectDir/src/main/java", "$projectDir/src/main/kotlin")

                sourceDirectories.setFrom(
                    files(
                        mainSrc.map {
                            project
                                .file(it)
                        }
                    )
                )

                classDirectories.setFrom(
                    fileTree(layout.buildDirectory.dir("tmp/kotlin-classes")) {
                        exclude(fileFilter)
                    }
                )

                executionData.setFrom(
                    fileTree(
                        layout.buildDirectory
                    ) {
                        include(
                            "jacoco/testDebugUnitTest.exec",
                            "outputs/code-coverage/connected/*coverage.ec"
                        )
                    }
                )
            }
        }
    }
}
