package com.giacom.simpletask.service

import com.giacom.simpletask.domain.TaskAttributeInstance
import com.giacom.simpletask.domain.TaskInstance
import com.giacom.simpletask.domain.TaskStepInstance
import com.giacom.simpletask.repository.TaskInstanceRepository
import com.giacom.simpletask.repository.mapper.TaskInstanceEntityMapper
import org.springframework.stereotype.Service

@Service
class TaskInstanceService(
    private val repository: TaskInstanceRepository,
    private val mapper: TaskInstanceEntityMapper,
    private val findTaskDefinitionService: FindTaskDefinitionService,
    private val taskStepInstanceService: TaskStepInstanceService,
    private val taskAttributeService: TaskAttributeInstanceService
) {

    fun create(taskName: String): Long {
        val taskDefinition = findTaskDefinitionService.findByName(taskName)
        val taskInstance = TaskInstance(
            taskDefinition = taskDefinition
        )

        if (taskDefinition.taskSteps?.isEmpty() == true) {
            throw IllegalArgumentException("Task definition steps does not exist")
        }

        val instance = repository.save(mapper.toEntity(taskInstance))

        taskDefinition.taskSteps?.forEach { taskStepDefinition ->
            taskStepInstanceService.create(
                TaskStepInstance(
                    taskInstanceId = instance.id,
                    taskStepDefinitionId = taskStepDefinition.id!!
                )
            )
        }
        taskDefinition.attributes?.forEach { taskAttributeDefinition ->
            taskAttributeService.create(
                TaskAttributeInstance(
                    taskInstanceId = instance.id,
                    attributeName = taskAttributeDefinition.attributeName
                )
            )
        }

        return instance.id
    }

    fun startTask(taskInstanceId: Long): TaskInstance {
        val taskInstanceEntity = repository.findById(taskInstanceId)
            .orElseThrow { IllegalArgumentException("Task instance does not exist") }
        val taskInstance = mapper.toDomain(taskInstanceEntity)
        taskInstance.startTask()
        repository.save(mapper.toEntity(taskInstance))
        return taskInstance
    }

}
