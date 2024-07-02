package com.giacom.simpletask.adapters.output

import com.giacom.simpletask.adapters.output.repository.TaskAttributeDefinitionRepository
import com.giacom.simpletask.adapters.output.repository.mapper.TaskAttributeDefinitionEntityMapper
import com.giacom.simpletask.application.core.domain.TaskAttributeDefinition
import com.giacom.simpletask.application.ports.output.SaveTaskAttributeDefinitionOutput
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class SaveTaskAttributeDefinitionAdapter(
    private val repository: TaskAttributeDefinitionRepository,
    private val mapper: TaskAttributeDefinitionEntityMapper
) : SaveTaskAttributeDefinitionOutput {

    @Transactional
    override fun save(taskAttributeDefinition: TaskAttributeDefinition): TaskAttributeDefinition {
        val taskAttributeDefinitionEntity = repository.save(mapper.toEntity(taskAttributeDefinition))
        return mapper.toDomain(taskAttributeDefinitionEntity)
    }

}
