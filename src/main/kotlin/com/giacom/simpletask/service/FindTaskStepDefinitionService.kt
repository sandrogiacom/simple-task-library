package com.giacom.simpletask.service


import com.giacom.simpletask.domain.TaskStepDefinition
import com.giacom.simpletask.repository.TaskStepDefinitionRepository
import com.giacom.simpletask.repository.entity.TaskStepDefinitionEntity
import com.giacom.simpletask.repository.mapper.TaskStepDefinitionEntityMapper
import org.springframework.stereotype.Service

@Service
class FindTaskStepDefinitionService(
    private val repository: TaskStepDefinitionRepository,
    private val mapper: TaskStepDefinitionEntityMapper
) {

    fun findByIdRepository(id: Long): TaskStepDefinitionEntity = repository.findById(id)
        .orElseThrow { RuntimeException("Task step definition not found") }

    fun findById(id: Long): TaskStepDefinition {
        val stepDefinitionEntity = findByIdRepository(id)
        return mapper.toDomain(stepDefinitionEntity)
    }

    fun findAllByTaskDefinitionId(taskDefinitionId: Long): List<TaskStepDefinition> {
        val allByTaskDefinitionId = repository.findAllByTaskDefinitionId(taskDefinitionId)
        return allByTaskDefinitionId.map { mapper.toDomain(it) }
    }

}
