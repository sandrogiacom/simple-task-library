package com.giacom.simpletask.application.core.usecase

import com.giacom.simpletask.application.core.domain.TaskInstance
import com.giacom.simpletask.application.core.domain.TaskInstanceAttribute
import com.giacom.simpletask.application.core.domain.TaskStatus
import com.giacom.simpletask.application.ports.input.FindTaskInstanceInput
import com.giacom.simpletask.application.ports.output.SaveTaskInstanceAttributeOutput
import com.giacom.simpletask.application.ports.output.SaveTaskInstanceOutput
import com.giacom.simpletask.builder.TaskInstanceAttributeBuilder
import com.giacom.simpletask.builder.TaskInstanceBuilder
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class StartTaskInstanceUseCaseTest {

    private lateinit var findTaskInstanceInput: FindTaskInstanceInput
    private lateinit var taskInstanceOutput: SaveTaskInstanceOutput
    private lateinit var taskInstanceAttributeOutput: SaveTaskInstanceAttributeOutput
    private lateinit var startTaskInstanceUseCase: StartTaskInstanceUseCase

    @BeforeEach
    fun setUp() {
        findTaskInstanceInput = mockk()
        taskInstanceOutput = mockk()
        taskInstanceAttributeOutput = mockk()
        startTaskInstanceUseCase = StartTaskInstanceUseCase(
            findTaskInstanceInput,
            taskInstanceOutput,
            taskInstanceAttributeOutput
        )
    }

    @Test
    fun `should start task instance with attributes`() {
        // Given
        val taskInstanceId = 1L
        val attributes = mapOf("key1" to "value1", "key2" to "value2")
        val taskInstance = TaskInstanceBuilder().build()

        every { findTaskInstanceInput.findById(taskInstanceId) } returns taskInstance
        every { taskInstanceOutput.save(any()) } returns taskInstance
        val taskInstanceAttribute = TaskInstanceAttributeBuilder().build()
        every { taskInstanceAttributeOutput.save(any()) } returns taskInstanceAttribute andThen taskInstanceAttribute

        // When
        val result = startTaskInstanceUseCase.startTask(taskInstanceId, attributes)

        // Then
        assertThat(result.status).isEqualTo(TaskStatus.RUNNING)
        verify(exactly = 1) { taskInstanceOutput.save(any()) }
        verify(exactly = attributes.size) { taskInstanceAttributeOutput.save(any()) }
    }

//    @Test
//    fun `should start task instance without attributes`() {
//        // Given
//        val taskInstanceId = 1L
//        val taskInstance = TaskInstance(id = taskInstanceId)
//
//        every { findTaskInstanceInput.findById(taskInstanceId) } returns taskInstance
//        every { taskInstanceOutput.save(any()) } returns taskInstance
//
//        // When
//        val result = startTaskInstanceUseCase.startTask(taskInstanceId, null)
//
//        // Then
//        assertThat(result).isEqualTo(taskInstance)
//        verify(exactly = 1) { taskInstanceOutput.save(any()) }
//        verify(exactly = 0) { taskInstanceAttributeOutput.save(any()) }
//    }

    @Test
    fun `should throw NoSuchElementException when task instance is not found`() {
        // Given
        val taskInstanceId = 1L

        every { findTaskInstanceInput.findById(taskInstanceId) } throws NoSuchElementException()

        // When & Then
        assertThrows<NoSuchElementException> {
            startTaskInstanceUseCase.startTask(taskInstanceId, null)
        }
    }
}
