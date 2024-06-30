package com.giacom.simpletask.application.core.usecase

import com.giacom.simpletask.application.ports.output.CreateTaskDefinitionOutput
import com.giacom.simpletask.builder.TaskDefinitionBuilder
import com.giacom.simpletask.builder.TaskStepDefinitionBuilder
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CreateTaskDefinitionUseCaseTest {

    private val createTaskDefinitionOutput = mockk<CreateTaskDefinitionOutput>()
    private val createTaskDefinitionUseCase = CreateTaskDefinitionUseCase(
        createTaskDefinitionOutput
    )

    @Test
    fun `should create a task definition`() {
        // Given
        val taskDefinition = TaskDefinitionBuilder(
            id = 1,
            taskName = "Task 1",
            taskDescription = "Task 1 description",
        ).build()

        every { createTaskDefinitionOutput.create(any()) } returns taskDefinition

        taskDefinition.addTaskStep(
            TaskStepDefinitionBuilder(
                id = 1,
                stepName = "Task Step 1",
                stepDescription = "Task Step 1 description",
                taskDefinition = taskDefinition,
                stepHandler = "Task Step 1 handler"
            ).build()
        )
        taskDefinition.addTaskStep(
            TaskStepDefinitionBuilder(
                id = 2,
                stepName = "Task Step 2",
                stepDescription = "Task Step 2 description",
                taskDefinition = taskDefinition,
                stepHandler = "Task Step 2 handler"
            ).build()
        )

        // When
        val create = createTaskDefinitionUseCase.create(taskDefinition)

        // Then
        assertThat(create.id).isEqualTo(1)
        assertThat(create.taskName).isEqualTo("Task 1")
        assertThat(create.taskDescription).isEqualTo("Task 1 description")
        assertThat(create.taskSteps?.size).isEqualTo(2)

        verify { createTaskDefinitionOutput.create(any()) }

    }

}
