package com.giacom.simpletask.adapters.output

import com.giacom.simpletask.adapters.output.repository.TaskDefinitionRepository
import com.giacom.simpletask.adapters.output.repository.mapper.TaskDefinitionEntityMapper
import com.giacom.simpletask.application.core.domain.TaskDefinition
import com.giacom.simpletask.application.ports.output.CreateTaskDefinitionOutput
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class CreateTaskDefinitionAdapter(
    private val repository: TaskDefinitionRepository,
    private val mapper: TaskDefinitionEntityMapper
) : CreateTaskDefinitionOutput {

    @Transactional
    override fun create(taskDefinition: TaskDefinition): TaskDefinition {
        val taskDefinitionEntity = repository.save(mapper.toEntity(taskDefinition))
        return mapper.toDomain(taskDefinitionEntity)
    }

}
