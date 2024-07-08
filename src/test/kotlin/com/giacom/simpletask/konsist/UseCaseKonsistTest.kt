package com.giacom.simpletask.konsist

import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.api.ext.list.withNameEndingWith
import com.lemonappdev.konsist.api.verify.assertTrue
import org.junit.jupiter.api.Test

class UseCaseKonsistTest {
    @Test
    fun `every use case reside in use case package`() {
        Konsist
            .scopeFromProject() // Define the scope containing all Kotlin files present in the project
            .classes() // Get all class declarations
            .withNameEndingWith("UseCase") // Filter classes heaving name ending with 'UseCase'
            .assertTrue { it.resideInPackage("..application.core.usecase..") } // Assert that each class resides in 'any domain.usecase any' package
    }
}
