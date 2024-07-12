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
    override fun save(taskDefinitionStep: TaskDefinitionStep): TaskDefinitionStep {
        val taskDefinitionStepEntity = repository.save(mapper.toEntity(taskDefinitionStep))
        return mapper.toDomain(taskDefinitionStepEntity)
    }

    override fun findById(id: Long): Optional<TaskDefinitionStep> {
        val taskDefinitionStepEntityOptional = repository.findById(id)
        return taskDefinitionStepEntityOptional.map { mapper.toDomain(it) }
    }

    override fun findAllByTaskDefinitionId(taskDefinitionId: Long): List<TaskDefinitionStep> {
        val taskDefinitionStepEntityList = repository.findAllByTaskDefinitionId(taskDefinitionId)
        return taskDefinitionStepEntityList.map { mapper.toDomain(it) }
    }

    override fun findByStepName(stepName: String): TaskDefinitionStep {
        val taskDefinitionStepEntity = repository.findByStepName(stepName).orElseThrow {
            NoSuchElementException()
        }
        return mapper.toDomain(taskDefinitionStepEntity)
    }

    override fun deleteById(id: Long) {
        repository.deleteById(id)
    }


}
