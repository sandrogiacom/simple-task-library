package com.giacom.simpletask.adapters.output

import com.giacom.simpletask.adapters.output.repository.TaskAttributeDefinitionRepository
import com.giacom.simpletask.adapters.output.repository.mapper.TaskAttributeDefinitionEntityMapper
import com.giacom.simpletask.application.core.domain.TaskAttributeDefinition
import com.giacom.simpletask.application.ports.output.FindTaskAttributeDefinitionOutput
import org.springframework.stereotype.Component
import java.util.*

@Component
class FindTaskAttributeDefinitionAdapter(
    private val repository: TaskAttributeDefinitionRepository,
    private val mapper: TaskAttributeDefinitionEntityMapper
) : FindTaskAttributeDefinitionOutput {

    override fun findById(id: Long): Optional<TaskAttributeDefinition> {
        val taskAttributeDefinitionEntity = repository.findById(id)
        return taskAttributeDefinitionEntity.map { mapper.toDomain(it) }
    }

    override fun findAllByTaskDefinitionId(taskDefinitionId: Long): List<TaskAttributeDefinition> {
        val taskAttributeDefinitionEntities = repository.findAllByTaskDefinitionId(taskDefinitionId)
        return taskAttributeDefinitionEntities.map { mapper.toDomain(it) }
    }

}
