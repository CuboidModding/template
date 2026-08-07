plugins {
    alias(libs.plugins.mdg)
    alias(libs.plugins.configure.platform)
}

neoForge {
    version = libs.versions.neoforge.get()

    runs {
        create("client") {
            client()
        }

        create("server") {
            server()
        }

        configureEach {
            jvmArgument("-Dmixin.debug.export=true")
            jvmArgument("-XX:+AllowEnhancedClassRedefinition")
            jvmArgument("-XX:+IgnoreUnrecognizedVMOptions")
        }
    }

    mods {
        create("teabridge") {
            sourceSet(sourceSets.main.get())
        }
    }
}
