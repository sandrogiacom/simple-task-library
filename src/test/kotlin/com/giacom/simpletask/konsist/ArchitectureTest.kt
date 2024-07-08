package com.giacom.simpletask.konsist

import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.api.architecture.KoArchitectureCreator.assertArchitecture
import com.lemonappdev.konsist.api.architecture.Layer
import org.junit.jupiter.api.Test

class ArchitectureTest {
    @Test
    fun `clean architecture layers have correct dependencies`() {
        Konsist
            .scopeFromProject() // Define the scope containing all Kotlin files present in project
            .assertArchitecture { // Assert architecture
                // Define layers
                val domain = Layer("Domain", "com.giacom.simpletask.application.core.domain..")
                val useCase = Layer("UseCase", "com.giacom.simpletask.application.core.usecase..")

                // Define architecture assertions
                domain.dependsOnNothing()
                useCase.dependsOn(domain)
            }
    }
}
