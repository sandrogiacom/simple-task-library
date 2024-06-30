package com.giacom.simpletask.adapters.output

import com.giacom.simpletask.adapters.output.repository.TaskStepDefinitionRepository
import com.giacom.simpletask.adapters.output.repository.mapper.TaskDefinitionEntityMapper
import com.giacom.simpletask.application.core.domain.TaskStepDefinition
import com.giacom.simpletask.application.ports.output.CreateTaskStepDefinitionOutput
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class CreateTaskStepDefinitionAdapter(
    private val repository: TaskStepDefinitionRepository,
    private val mapper: TaskDefinitionEntityMapper
) : CreateTaskStepDefinitionOutput {

    @Transactional
    override fun create(taskStepDefinition: TaskStepDefinition): TaskStepDefinition {
        val taskStepDefinitionEntity = repository.save(mapper.toStepEntity(taskStepDefinition))
        return mapper.toStepDomain(taskStepDefinitionEntity)
    }

}
