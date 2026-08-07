rootProject.name = "template"

enableFeaturePreview("STABLE_CONFIGURATION_CACHE")

pluginManagement {
	repositories {
		maven("https://maven.fabricmc.net/" )
        mavenCentral()
        gradlePluginPortal()
	}
}

includeBuild("build-logic")

for (platform in listOf("common", "fabric", "neoforge")) {
    val name = "${rootProject.name}-$platform"
    include(name)
    project(":$name").projectDir = file(platform)
}
