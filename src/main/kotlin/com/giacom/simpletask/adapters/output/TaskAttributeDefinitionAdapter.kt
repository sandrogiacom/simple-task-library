package com.giacom.simpletask.adapters.output

import com.giacom.simpletask.adapters.output.repository.TaskAttributeDefinitionRepository
import com.giacom.simpletask.adapters.output.repository.mapper.TaskAttributeDefinitionEntityMapper
import com.giacom.simpletask.application.core.domain.TaskAttributeDefinition
import com.giacom.simpletask.application.ports.output.DeleteTaskAttributeDefinitionOutput
import com.giacom.simpletask.application.ports.output.FindTaskAttributeDefinitionOutput
import com.giacom.simpletask.application.ports.output.SaveTaskAttributeDefinitionOutput
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Component
class TaskAttributeDefinitionAdapter(
    private val repository: TaskAttributeDefinitionRepository,
    private val mapper: TaskAttributeDefinitionEntityMapper
) : SaveTaskAttributeDefinitionOutput, FindTaskAttributeDefinitionOutput, DeleteTaskAttributeDefinitionOutput {

    @Transactional
    override fun save(taskAttributeDefinition: TaskAttributeDefinition): TaskAttributeDefinition {
        val taskAttributeDefinitionEntity = repository.save(mapper.toEntity(taskAttributeDefinition))
        return mapper.toDomain(taskAttributeDefinitionEntity)
    }

    override fun findById(id: Long): Optional<TaskAttributeDefinition> {
        val taskAttributeDefinitionEntity = repository.findById(id)
        return taskAttributeDefinitionEntity.map { mapper.toDomain(it) }
    }

    override fun findAllByTaskDefinitionId(taskDefinitionId: Long): List<TaskAttributeDefinition> {
        val taskAttributeDefinitionEntities = repository.findAllByTaskDefinitionId(taskDefinitionId)
        return taskAttributeDefinitionEntities.map { mapper.toDomain(it) }
    }

    override fun findByAttributeName(attributeName: String): TaskAttributeDefinition {
        val taskAttributeDefinitionEntity = repository.findByAttributeName(attributeName)
        return mapper.toDomain(taskAttributeDefinitionEntity)
    }

    override fun deleteById(id: Long) {
        repository.deleteById(id)
    }

}
