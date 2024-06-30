package com.giacom.simpletask.application.core.domain

import com.giacom.simpletask.builder.TaskDefinitionBuilder
import com.giacom.simpletask.builder.TaskStepDefinitionBuilder
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TaskDefinitionTest {

    @Test
    fun `should create a task definition`() {
        // Given
        val taskDefinition = TaskDefinitionBuilder(
            id = 1,
            taskName = "Task 1",
            taskDescription = "Task 1 description",
        ).build()

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
        val createdTaskDefinition = taskDefinition

        // Then
        assertThat(createdTaskDefinition.taskName).isEqualTo("Task 1")
    }

}
