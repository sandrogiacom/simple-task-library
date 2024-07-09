package com.giacom.simpletask.service

import com.giacom.simpletask.domain.TaskAttributeDefinition
import com.giacom.simpletask.repository.TaskAttributeDefinitionRepository
import com.giacom.simpletask.repository.entity.TaskAttributeDefinitionEntity
import com.giacom.simpletask.repository.mapper.TaskAttributeDefinitionEntityMapper
import org.springframework.stereotype.Service

@Service
class FindTaskAttributeDefinitionService(
    private val repository: TaskAttributeDefinitionRepository,
    private val mapper: TaskAttributeDefinitionEntityMapper
) {

    fun findAllByTaskDefinitionId(taskDefinitionId: Long): List<TaskAttributeDefinition> {
        val allByTaskDefinitionId = repository.findAllByTaskDefinitionId(taskDefinitionId)
        return allByTaskDefinitionId.map { mapper.toDomain(it) }
    }

    fun findById(id: Long): TaskAttributeDefinition {
        val definitionEntity = repository.findById(id).orElseThrow { RuntimeException("Task definition Attribute not found") }
        return mapper.toDomain(definitionEntity)
    }

    fun findByIdRepository(id: Long): TaskAttributeDefinitionEntity =
        repository.findById(id).orElseThrow { RuntimeException("Task definition Attribute not found") }

}
