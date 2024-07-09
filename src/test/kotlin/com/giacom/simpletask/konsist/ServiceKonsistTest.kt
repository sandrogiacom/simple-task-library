package com.giacom.simpletask.konsist

import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.api.ext.list.withNameEndingWith
import com.lemonappdev.konsist.api.verify.assertTrue
import org.junit.jupiter.api.Test

class ServiceKonsistTest {
    @Test
    fun `every service reside in service package`() {
        Konsist
            .scopeFromProject() // Define the scope containing all Kotlin files present in the project
            .classes() // Get all class declarations
            .withNameEndingWith("Service") // Filter classes heaving name ending with 'UseCase'
            .assertTrue { it.resideInPackage("..service..") } // Assert that each class resides in 'any domain.usecase any' package
    }
}
