package com.giacom.simpletask.adapters.output

import com.giacom.simpletask.adapters.output.repository.TaskDefinitionStepRepository
import com.giacom.simpletask.adapters.output.repository.mapper.TaskDefinitionStepEntityMapper
import com.giacom.simpletask.application.core.domain.TaskDefinitionStep
import com.giacom.simpletask.application.ports.output.DeleteTaskDefinitionStepOutput
import com.giacom.simpletask.application.ports.output.FindTaskDefinitionStepOutput
import com.giacom.simpletask.application.ports.output.SaveTaskDefinitionStepOutput
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Component
class TaskDefinitionStepAdapter(
    private val repository: TaskDefinitionStepRepository,
    private val mapper: TaskDefinitionStepEntityMapper
) : SaveTaskDefinitionStepOutput, FindTaskDefinitionStepOutput, DeleteTaskDefinitionStepOutput {

    @Transactional
    override fun save(taskStepDefinition: TaskDefinitionStep): TaskDefinitionStep {
        val taskStepDefinitionEntity = repository.save(mapper.toEntity(taskStepDefinition))
        return mapper.toDomain(taskStepDefinitionEntity)
    }

    override fun findById(id: Long): Optional<TaskDefinitionStep> {
        val taskStepDefinitionEntity = repository.findById(id)
        return taskStepDefinitionEntity.map { mapper.toDomain(it) }
    }

    override fun findAllByTaskDefinitionId(taskDefinitionId: Long): List<TaskDefinitionStep> {
        val taskStepDefinitionEntities = repository.findAllByTaskDefinitionId(taskDefinitionId)
        return taskStepDefinitionEntities.map { mapper.toDomain(it) }
    }

    override fun findByStepName(stepName: String): TaskDefinitionStep {
        val taskStepDefinitionEntity = repository.findByStepName(stepName).orElseThrow {
            NoSuchElementException()
        }
        return mapper.toDomain(taskStepDefinitionEntity)
    }

    override fun deleteById(id: Long) {
        repository.deleteById(id)
    }


}
