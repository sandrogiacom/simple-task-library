package com.giacom.simpletask.service


import com.giacom.simpletask.domain.TaskStepDefinition
import com.giacom.simpletask.repository.TaskStepDefinitionRepository
import com.giacom.simpletask.repository.mapper.TaskStepDefinitionEntityMapper
import org.springframework.stereotype.Service

@Service
class TaskStepDefinitionService(
    private val repository: TaskStepDefinitionRepository,
    private val mapper: TaskStepDefinitionEntityMapper,
    private val findService: FindTaskStepDefinitionService,
    private val findTaskDefinitionService: FindTaskDefinitionService
) {

    fun create(taskDefinitionId: Long, taskStepDefinition: TaskStepDefinition): TaskStepDefinition {
        val taskDefinitionEntity = findTaskDefinitionService.findByIdRepository(taskDefinitionId)
        val taskStepDefinitionEntity = mapper.toEntity(taskStepDefinition)

        val entity = repository.save(
            taskStepDefinitionEntity.copy(taskDefinition = taskDefinitionEntity)
        )
        return mapper.toDomain(entity)
    }

    fun update(id: Long, taskStepDefinition: TaskStepDefinition): TaskStepDefinition {
        val existTaskStep = findService.findByIdRepository(id)
        val taskStepDefinitionEntity = mapper.toEntity(taskStepDefinition)
        val entity = repository.save(
            taskStepDefinitionEntity.copy(
                id = existTaskStep.id, taskDefinition = existTaskStep.taskDefinition
            )
        )
        return mapper.toDomain(entity)
    }

    fun delete(id: Long) {
        val existTaskStep = findService.findByIdRepository(id)
        repository.delete(existTaskStep)
    }
}
