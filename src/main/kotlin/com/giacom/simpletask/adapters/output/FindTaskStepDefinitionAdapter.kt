package com.giacom.simpletask.adapters.output

import com.giacom.simpletask.adapters.output.repository.TaskDefinitionRepository
import com.giacom.simpletask.adapters.output.repository.TaskStepDefinitionRepository
import com.giacom.simpletask.adapters.output.repository.mapper.TaskDefinitionEntityMapper
import com.giacom.simpletask.adapters.output.repository.mapper.TaskStepDefinitionEntityMapper
import com.giacom.simpletask.application.core.domain.TaskDefinition
import com.giacom.simpletask.application.core.domain.TaskStepDefinition
import com.giacom.simpletask.application.ports.output.FindTaskDefinitionOutput
import com.giacom.simpletask.application.ports.output.FindTaskStepDefinitionOutput
import org.springframework.stereotype.Component
import java.util.*

@Component
class FindTaskStepDefinitionAdapter(
    private val repository: TaskStepDefinitionRepository,
    private val mapper: TaskStepDefinitionEntityMapper
) : FindTaskStepDefinitionOutput {

    override fun findById(id: Long): Optional<TaskStepDefinition> {
        val taskStepDefinitionEntity = repository.findById(id)
        return taskStepDefinitionEntity.map { mapper.toDomain(it) }
    }

    override fun findAllByTaskDefinitionId(taskDefinitionId: Long): List<TaskStepDefinition> {
        val taskStepDefinitionEntities = repository.findAllByTaskDefinitionId(taskDefinitionId)
        return taskStepDefinitionEntities.map { mapper.toDomain(it) }
    }

}
