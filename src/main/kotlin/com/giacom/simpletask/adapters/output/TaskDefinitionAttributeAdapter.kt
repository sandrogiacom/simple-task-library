package com.giacom.simpletask.adapters.output

import com.giacom.simpletask.adapters.output.repository.TaskDefinitionAttributeRepository
import com.giacom.simpletask.adapters.output.repository.mapper.TaskDefinitionAttributeEntityMapper
import com.giacom.simpletask.application.core.domain.TaskDefinitionAttribute
import com.giacom.simpletask.application.ports.output.DeleteTaskDefinitionAttributeOutput
import com.giacom.simpletask.application.ports.output.FindTaskDefinitionAttributeOutput
import com.giacom.simpletask.application.ports.output.SaveTaskDefinitionAttributeOutput
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Component
class TaskDefinitionAttributeAdapter(
    private val repository: TaskDefinitionAttributeRepository,
    private val mapper: TaskDefinitionAttributeEntityMapper
) : SaveTaskDefinitionAttributeOutput, FindTaskDefinitionAttributeOutput, DeleteTaskDefinitionAttributeOutput {

    @Transactional
    override fun save(taskDefinitionAttribute: TaskDefinitionAttribute): TaskDefinitionAttribute {
        val taskDefinitionAttributeEntity = repository.save(mapper.toEntity(taskDefinitionAttribute))
        return mapper.toDomain(taskDefinitionAttributeEntity)
    }

    override fun findById(id: Long): Optional<TaskDefinitionAttribute> {
        val taskDefinitionAttributeEntity = repository.findById(id)
        return taskDefinitionAttributeEntity.map { mapper.toDomain(it) }
    }

    override fun findAllByTaskDefinitionId(taskDefinitionId: Long): List<TaskDefinitionAttribute> {
        val taskDefinitionAttributeEntities = repository.findAllByTaskDefinitionId(taskDefinitionId)
        return taskDefinitionAttributeEntities.map { mapper.toDomain(it) }
    }

    override fun findByAttributeName(attributeName: String): TaskDefinitionAttribute {
        val definitionAttributeEntity = repository.findByAttributeName(attributeName)
            .orElseThrow { NoSuchElementException("TaskDefinitionAttribute not found by attributeName: $attributeName") }
        return mapper.toDomain(definitionAttributeEntity)
    }

    override fun deleteById(id: Long) {
        repository.deleteById(id)
    }

}
