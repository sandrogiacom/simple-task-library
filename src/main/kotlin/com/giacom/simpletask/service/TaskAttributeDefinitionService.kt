package com.giacom.simpletask.service

import com.giacom.simpletask.domain.TaskAttributeDefinition
import com.giacom.simpletask.repository.TaskAttributeDefinitionRepository
import com.giacom.simpletask.repository.mapper.TaskAttributeDefinitionEntityMapper
import org.springframework.stereotype.Service

@Service
class TaskAttributeDefinitionService(
    private val repository: TaskAttributeDefinitionRepository,
    private val mapper: TaskAttributeDefinitionEntityMapper,
    private val findService: FindTaskAttributeDefinitionService,
    private val findTaskDefinitionService: FindTaskDefinitionService
) {

    fun create(taskDefinitionId: Long, taskAttributeDefinition: TaskAttributeDefinition): TaskAttributeDefinition {
        val taskDefinition = findTaskDefinitionService.findById(taskDefinitionId)
        val entity = repository.save(
            mapper.toEntity(taskAttributeDefinition.copy(taskDefinition = taskDefinition))
        )
        return mapper.toDomain(entity)
    }

    fun update(id: Long, taskAttributeDefinition: TaskAttributeDefinition): TaskAttributeDefinition {
        val existTaskAttribute = findService.findByIdRepository(id)

        val attributeDefinition = existTaskAttribute.copy(
            attributeName = taskAttributeDefinition.attributeName,
        )
        repository.save(attributeDefinition)
        return mapper.toDomain(attributeDefinition)
    }

    fun delete(id: Long) {
        val existTaskAttribute = findService.findByIdRepository(id)
        repository.delete(existTaskAttribute)
    }

}
