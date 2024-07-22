package com.giacom.simpletask.application.core.usecase

import com.giacom.simpletask.application.ports.input.FindTaskDefinitionInput
import com.giacom.simpletask.application.ports.output.SaveTaskDefinitionOutput
import com.giacom.simpletask.builder.TaskDefinitionBuilder
import com.giacom.simpletask.builder.TaskDefinitionStepBuilder
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SaveTaskDefinitionUseCaseTest {

    private val saveTaskDefinitionOutput = mockk<SaveTaskDefinitionOutput>()
    private val findTaskDefinitionInput = mockk<FindTaskDefinitionInput>()
    private val saveTaskDefinitionUseCase = SaveTaskDefinitionUseCase(
        saveTaskDefinitionOutput, findTaskDefinitionInput
    )

    @Test
    fun `should create a task definition`() {
        // Given
        val taskDefinition = TaskDefinitionBuilder().build()

        every { saveTaskDefinitionOutput.save(any()) } returns taskDefinition
        every { findTaskDefinitionInput.findByName(any()) } throws NoSuchElementException()

        taskDefinition.addTaskStep(
            TaskDefinitionStepBuilder(
                taskDefinition = taskDefinition
            ).withId(1).build()
        )
        taskDefinition.addTaskStep(
            TaskDefinitionStepBuilder(
                taskDefinition = taskDefinition,
            ).withId(2).build()
        )

        // When
        val create = saveTaskDefinitionUseCase.create(taskDefinition)

        // Then
        assertThat(create.id).isEqualTo(1)
        assertThat(create.taskName).isEqualTo("Task 1")
        assertThat(create.taskDescription).isEqualTo("Task 1 description")
        assertThat(create.taskSteps?.size).isEqualTo(2)

        verify { saveTaskDefinitionOutput.save(any()) }

    }

}
