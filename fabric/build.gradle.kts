plugins {
    alias(libs.plugins.loom)
    alias(libs.plugins.configure.platform)
}

dependencies {
    minecraft(libs.minecraft)
    api(libs.bundles.fabric)
}

loom {
    runs {
        configureEach {
            @Suppress("DEPRECATION")
            ideConfigGenerated(true)
            preferGradleTask = true

            systemProperties.put("mixin.debug.export", "true")
            jvmArguments.add("-XX:+AllowEnhancedClassRedefinition")
            jvmArguments.add("-XX:+IgnoreUnrecognizedVMOptions")
        }
    }
}
