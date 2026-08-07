plugins {
    alias(libs.plugins.loom)
    alias(libs.plugins.configure.common)
}

dependencies {
    minecraft(libs.minecraft)
    compileOnly(libs.bundles.mixin)
}
