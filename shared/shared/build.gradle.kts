import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
}

kotlin {
    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser {
            val rootDirPath = project.rootDir.path
            val projectDirPath = project.projectDir.path
            commonWebpackConfig {
                devServer = (devServer ?: KotlinWebpackConfig.DevServer()).apply {
                    static = (static ?: mutableListOf()).apply {
                        // Serve sources to debug inside browser
                        add(rootDirPath)
                        add(projectDirPath)
                    }
                }
            }
        }
    }

    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    jvm()

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "Shared"
            isStatic = true

            export(projects.shared.feature.root)
            export(projects.shared.feature.home)
            export(projects.shared.feature.onboarding)

            export(projects.core.uikit)
            export(projects.core.domain)
            export(libs.moko.resources)
            export(libs.moko.graphics)

            export(libs.kotlinx.coroutines.core)
            export(libs.decompose)
            export(libs.essenty.lifecycle)
            export(libs.essenty.stateKeeper)
            export(libs.essenty.backHandler)
            export(libs.essenty.instanceKeeper)

        }
    }



    sourceSets {
        commonMain.dependencies {
            api(projects.shared.feature.onboarding)
            api(projects.shared.feature.home)
            api(projects.shared.feature.root)
            api(projects.core.uikit)


            api(libs.kotlinx.coroutines.core)
            api(libs.decompose)
            api(libs.essenty.lifecycle)
            api(libs.essenty.backHandler)
            api(libs.essenty.stateKeeper)
            api(libs.essenty.instanceKeeper)
            // implementation зависимости
            implementation(projects.core.data)
            implementation(projects.core.domain)
            implementation(projects.core.common)
            implementation(libs.koin.core)
        }

        jvmMain.dependencies {
            implementation(libs.sqlite.bundled)
        }

        iosMain.dependencies {
            implementation(libs.sqlite.bundled)
        }
    }
}

android {
    namespace = "com.hadj.skillingo.shared"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
}