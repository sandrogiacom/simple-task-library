package com.giacom.simpletask.service

import com.giacom.simpletask.domain.TaskDefinition
import com.giacom.simpletask.repository.TaskDefinitionRepository
import com.giacom.simpletask.repository.entity.TaskDefinitionEntity
import com.giacom.simpletask.repository.mapper.TaskDefinitionEntityMapper
import org.springframework.stereotype.Service

@Service
class FindTaskDefinitionService(
    private val repository: TaskDefinitionRepository,
    private val mapper: TaskDefinitionEntityMapper,
    private val findTaskStepDefinitionService: FindTaskStepDefinitionService,
    private val findTaskAttributeDefinitionService: FindTaskAttributeDefinitionService
) {

    fun findByIdRepository(id: Long): TaskDefinitionEntity = repository.findById(id)
        .orElseThrow { RuntimeException("Task definition not found") }

    fun findById(id: Long): TaskDefinition {
        val taskDefinitionJpa = findByIdRepository(id)
        val taskDefinition = mapper.toDomain(taskDefinitionJpa)
        return taskDefinition.also { withRelations(it) }
    }

    fun findAll(): List<TaskDefinition> {
        val allTasksDefinition = repository.findAll()
        return allTasksDefinition.map {
            val taskDefinition = mapper.toDomain(it)
            taskDefinition
        }
    }

    fun findByName(name: String): TaskDefinition {
        val findByName = repository.findByTaskName(name)
            .orElseThrow { RuntimeException("Task definition not found") }
        return mapper.toDomain(findByName).also { withRelations(it) }
    }

    private fun withRelations(taskDefinition: TaskDefinition) {
        withSteps(taskDefinition)
        withAttributes(taskDefinition)
    }

    private fun withSteps(taskDefinition: TaskDefinition) {
        taskDefinition.taskSteps = findTaskStepDefinitionService.findAllByTaskDefinitionId(taskDefinition.id!!)
    }

    private fun withAttributes(taskDefinition: TaskDefinition) {
        taskDefinition.attributes = findTaskAttributeDefinitionService.findAllByTaskDefinitionId(taskDefinition.id!!)
    }

}
