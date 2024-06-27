package com.giacom.simpletask.adapters.output

import com.giacom.simpletask.adapters.out.repository.mapper.TaskDefinitionEntityMapper
import com.giacom.simpletask.adapters.output.repository.TaskDefinitionRepository
import com.giacom.simpletask.application.core.domain.TaskDefinition
import com.giacom.simpletask.application.ports.out.CreateTaskDefinitionOutput
import org.springframework.stereotype.Component

@Component
class InsertTaskDefinitionAdapter(
    private val repository: TaskDefinitionRepository,
    private val mapper: TaskDefinitionEntityMapper
) : CreateTaskDefinitionOutput {

    override fun create(taskDefinition: TaskDefinition): TaskDefinition {
        val taskDefinitionEntity = repository.save(mapper.toEntity(taskDefinition))
        return mapper.toDomain(taskDefinitionEntity)
    }

}
