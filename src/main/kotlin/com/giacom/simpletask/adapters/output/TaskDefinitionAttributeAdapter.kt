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
    override fun save(taskAttributeDefinition: TaskDefinitionAttribute): TaskDefinitionAttribute {
        val taskAttributeDefinitionEntity = repository.save(mapper.toEntity(taskAttributeDefinition))
        return mapper.toDomain(taskAttributeDefinitionEntity)
    }

    override fun findById(id: Long): Optional<TaskDefinitionAttribute> {
        val taskAttributeDefinitionEntity = repository.findById(id)
        return taskAttributeDefinitionEntity.map { mapper.toDomain(it) }
    }

    override fun findAllByTaskDefinitionId(taskDefinitionId: Long): List<TaskDefinitionAttribute> {
        val taskAttributeDefinitionEntities = repository.findAllByTaskDefinitionId(taskDefinitionId)
        return taskAttributeDefinitionEntities.map { mapper.toDomain(it) }
    }

    override fun findByAttributeName(attributeName: String): TaskDefinitionAttribute {
        val taskAttributeDefinitionEntity = repository.findByAttributeName(attributeName)
        return mapper.toDomain(taskAttributeDefinitionEntity)
    }

    override fun deleteById(id: Long) {
        repository.deleteById(id)
    }

}
