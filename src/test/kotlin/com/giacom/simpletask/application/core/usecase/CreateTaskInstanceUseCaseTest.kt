package com.giacom.simpletask.application.core.usecase

import com.giacom.simpletask.application.core.domain.TaskDefinition
import com.giacom.simpletask.application.core.domain.TaskInstance
import com.giacom.simpletask.application.core.domain.TaskInstanceAttribute
import com.giacom.simpletask.application.core.domain.TaskInstanceStep
import com.giacom.simpletask.application.ports.input.FindTaskDefinitionInput
import com.giacom.simpletask.application.ports.output.SaveTaskInstanceAttributeOutput
import com.giacom.simpletask.application.ports.output.SaveTaskInstanceOutput
import com.giacom.simpletask.application.ports.output.SaveTaskInstanceStepOutput
import com.giacom.simpletask.builder.TaskDefinitionAttributeBuilder
import com.giacom.simpletask.builder.TaskDefinitionBuilder
import com.giacom.simpletask.builder.TaskDefinitionStepBuilder
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CreateTaskInstanceUseCaseTest {

    private lateinit var findTaskDefinitionInput: FindTaskDefinitionInput
    private lateinit var createTaskInstanceOutput: SaveTaskInstanceOutput
    private lateinit var saveTaskInstanceStepOutput: SaveTaskInstanceStepOutput
    private lateinit var saveTaskInstanceAttributeOutput: SaveTaskInstanceAttributeOutput
    private lateinit var createTaskInstanceUseCase: CreateTaskInstanceUseCase

    @BeforeEach
    fun setUp() {
        findTaskDefinitionInput = mockk()
        createTaskInstanceOutput = mockk()
        saveTaskInstanceStepOutput = mockk()
        saveTaskInstanceAttributeOutput = mockk()
        createTaskInstanceUseCase = CreateTaskInstanceUseCase(
            findTaskDefinitionInput,
            createTaskInstanceOutput,
            saveTaskInstanceStepOutput,
            saveTaskInstanceAttributeOutput
        )
    }

    @Test
    fun `should create task instance with steps and attributes`() {
        // Given
        val taskName = "Task 01"
        val taskDefinition = createTaskDefinition(taskName)

        val taskInstance = TaskInstance(taskDefinition = taskDefinition)

        val taskInstanceStep1 = TaskInstanceStep(
            taskInstanceId = taskInstance.id,
            taskDefinitionStep = taskDefinition.taskSteps!![0]
        )
        val taskInstanceStep2 = TaskInstanceStep(
            taskInstanceId = taskInstance.id,
            taskDefinitionStep = taskDefinition.taskSteps!![1]
        )

        val taskInstanceAttribute1 = TaskInstanceAttribute(
            taskInstanceId = taskInstance.id,
            attributeName = taskDefinition.attributes!![0].attributeName
        )
        val taskInstanceAttribute2 = TaskInstanceAttribute(
            taskInstanceId = taskInstance.id,
            attributeName = taskDefinition.attributes!![1].attributeName
        )

        every { findTaskDefinitionInput.findByName(taskName) } returns taskDefinition
        every { createTaskInstanceOutput.save(any()) } returns taskInstance

        every { saveTaskInstanceStepOutput.save(any()) } returns taskInstanceStep1 andThen taskInstanceStep2
        every { saveTaskInstanceAttributeOutput.save(any()) } returns taskInstanceAttribute1 andThen taskInstanceAttribute2

        // When
        val result = createTaskInstanceUseCase.create(taskName)

        // Then
        assertThat(result).isEqualTo(taskInstance)
        verify(exactly = 1) { createTaskInstanceOutput.save(any()) }
        verify(exactly = taskDefinition.taskSteps!!.size) { saveTaskInstanceStepOutput.save(any()) }
        verify(exactly = taskDefinition.attributes!!.size) { saveTaskInstanceAttributeOutput.save(any()) }
    }

    private fun createTaskDefinition(taskName: String): TaskDefinition {
        val taskDefinition = TaskDefinitionBuilder()
            .withTaskName(taskName)
            .build()

        val taskStep1 = TaskDefinitionStepBuilder(taskDefinition = taskDefinition)
            .withId(1)
            .build()
        taskDefinition.addTaskStep(taskStep1)

        val taskStep2 = TaskDefinitionStepBuilder(taskDefinition = taskDefinition)
            .withId(2)
            .build()
        taskDefinition.addTaskStep(taskStep2)

        val attribute1 = TaskDefinitionAttributeBuilder(taskDefinition = taskDefinition)
            .withId(1)
            .withAttributeName("Attribute 01")
            .build()
        taskDefinition.addTaskAttribute(attribute1)

        val attribute2 = TaskDefinitionAttributeBuilder(taskDefinition = taskDefinition)
            .withId(2)
            .withAttributeName("Attribute 02")
            .build()
        taskDefinition.addTaskAttribute(attribute2)

        return taskDefinition
    }

    @Test
    fun `should throw IllegalArgumentException when task definition has no steps`() {
        // Given
        val taskName = "Task Without Steps"
        val taskDefinition = TaskDefinitionBuilder().withTaskName(taskName).build()

        every { findTaskDefinitionInput.findByName(taskName) } returns taskDefinition

        // When & Then
        assertThrows<IllegalArgumentException> {
            createTaskInstanceUseCase.create(taskName)
        }
    }

    @Test
    fun `should throw NoSuchElementException when task definition is not found`() {
        // Given
        val taskName = "Nonexistent Task"

        every { findTaskDefinitionInput.findByName(taskName) } throws NoSuchElementException()

        // When & Then
        assertThrows<NoSuchElementException> {
            createTaskInstanceUseCase.create(taskName)
        }
    }
}
