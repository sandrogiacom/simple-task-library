package com.giacom.simpletask.application.core.usecase

import com.giacom.simpletask.builder.TaskDefinitionBuilder
import com.giacom.simpletask.builder.TaskStepDefinitionBuilder
import com.giacom.simpletask.repository.TaskDefinitionRepository
import com.giacom.simpletask.repository.mapper.TaskDefinitionEntityMapper
import com.giacom.simpletask.repository.mapper.TaskDefinitionEntityMapperImpl
import com.giacom.simpletask.service.FindTaskDefinitionService
import com.giacom.simpletask.service.TaskDefinitionService
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SaveTaskDefinitionUseCaseTest {

    private val repository = mockk<TaskDefinitionRepository>()
    private val findService = mockk<FindTaskDefinitionService>()
    private val mapper = TaskDefinitionEntityMapperImpl()
    private val service = TaskDefinitionService(
        repository, mapper, findService
    )

    @Test
    fun `should create a task definition`() {
        // Given
        val taskDefinition = TaskDefinitionBuilder(
            id = 1,
            taskName = "Task 1",
            taskDescription = "Task 1 description",
        ).build()

//        taskDefinition.addTaskStep(
//            TaskStepDefinitionBuilder(
//                id = 1,
//                stepName = "Task Step 1",
//                stepDescription = "Task Step 1 description",
//                taskDefinition = taskDefinition,
//                stepHandler = "Task Step 1 handler"
//            ).build()
//        )
//        taskDefinition.addTaskStep(
//            TaskStepDefinitionBuilder(
//                id = 2,
//                stepName = "Task Step 2",
//                stepDescription = "Task Step 2 description",
//                taskDefinition = taskDefinition,
//                stepHandler = "Task Step 2 handler"
//            ).build()
//        )

        val taskDefinitionEntity = mapper.toEntity(taskDefinition)
        every { repository.save(any()) } returns taskDefinitionEntity

        // When

        val create = repository.save(taskDefinitionEntity)

        // Then
        assertThat(create.id).isEqualTo(1)
        assertThat(create.taskName).isEqualTo("Task 1")
        assertThat(create.taskDescription).isEqualTo("Task 1 description")

        verify { repository.save(any()) }

    }

}
