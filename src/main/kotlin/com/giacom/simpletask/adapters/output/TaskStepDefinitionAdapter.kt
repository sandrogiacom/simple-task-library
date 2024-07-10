package com.giacom.simpletask.adapters.output

import com.giacom.simpletask.adapters.output.repository.TaskStepDefinitionRepository
import com.giacom.simpletask.adapters.output.repository.mapper.TaskStepDefinitionEntityMapper
import com.giacom.simpletask.application.core.domain.TaskStepDefinition
import com.giacom.simpletask.application.ports.output.DeleteTaskStepDefinitionOutput
import com.giacom.simpletask.application.ports.output.FindTaskStepDefinitionOutput
import com.giacom.simpletask.application.ports.output.SaveTaskStepDefinitionOutput
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Component
class TaskStepDefinitionAdapter(
    private val repository: TaskStepDefinitionRepository,
    private val mapper: TaskStepDefinitionEntityMapper
) : SaveTaskStepDefinitionOutput, FindTaskStepDefinitionOutput, DeleteTaskStepDefinitionOutput {

    @Transactional
    override fun save(taskStepDefinition: TaskStepDefinition): TaskStepDefinition {
        val taskStepDefinitionEntity = repository.save(mapper.toEntity(taskStepDefinition))
        return mapper.toDomain(taskStepDefinitionEntity)
    }

    override fun findById(id: Long): Optional<TaskStepDefinition> {
        val taskStepDefinitionEntity = repository.findById(id)
        return taskStepDefinitionEntity.map { mapper.toDomain(it) }
    }

    override fun findAllByTaskDefinitionId(taskDefinitionId: Long): List<TaskStepDefinition> {
        val taskStepDefinitionEntities = repository.findAllByTaskDefinitionId(taskDefinitionId)
        return taskStepDefinitionEntities.map { mapper.toDomain(it) }
    }

    override fun findByStepName(stepName: String): TaskStepDefinition {
        val taskStepDefinitionEntity = repository.findByStepName(stepName).orElseThrow {
            NoSuchElementException()
        }
        return mapper.toDomain(taskStepDefinitionEntity)
    }

    override fun deleteById(id: Long) {
        repository.deleteById(id)
    }


}
