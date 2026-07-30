plugins {
	alias(libs.plugins.loom)
}

group = "me.cuboid"

val buildNum = providers.environmentVariable("GITHUB_RUN_NUMBER")
    .filter(String::isNotEmpty)
	.map { "build.$it" }
    .orElse("local")
    .get()

version = "0.1.0+$buildNum-mc${libs.versions.minecraft.get()}"

dependencies {
    minecraft(libs.minecraft)
	api(libs.bundles.fabric)
}

java {
    withSourcesJar()
    toolchain.languageVersion = JavaLanguageVersion.of(25)
}

tasks.withType<Jar> {
    from(rootProject.file("LICENSE"))
}

tasks.processResources {
    inputs.properties(
        "version" to version,
        "minecraft_version" to libs.versions.minecraft.get().replace("snapshot-", "alpha.").replace("pre-", "pre."),
        "loader_version" to libs.versions.loader.get()
    )

    filesMatching("fabric.mod.json") {
        expand(inputs.properties)
    }
}

loom {
	runs {
        configureEach {
            preferGradleTask = true

            systemProperties.put("mixin.debug.export", "true")
            jvmArguments.add("-XX:+AllowEnhancedClassRedefinition")
            jvmArguments.add("-XX:+IgnoreUnrecognizedVMOptions")
        }
	}
}
