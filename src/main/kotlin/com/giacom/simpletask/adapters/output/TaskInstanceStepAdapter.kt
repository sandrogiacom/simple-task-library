package com.giacom.simpletask.adapters.output

import com.giacom.simpletask.adapters.output.repository.TaskInstanceStepRepository
import com.giacom.simpletask.adapters.output.repository.mapper.TaskInstanceStepEntityMapper
import com.giacom.simpletask.application.core.domain.TaskInstanceStep
import com.giacom.simpletask.application.ports.output.FindTaskInstanceStepOutput
import com.giacom.simpletask.application.ports.output.SaveTaskInstanceStepOutput
import org.springframework.stereotype.Component

@Component
class TaskInstanceStepAdapter(
    private val repository: TaskInstanceStepRepository,
    private val mapper: TaskInstanceStepEntityMapper
) : SaveTaskInstanceStepOutput, FindTaskInstanceStepOutput {

    override fun save(taskInstanceStep: TaskInstanceStep): TaskInstanceStep {
        val instanceEntity = repository.save(mapper.toEntity(taskInstanceStep))
        return mapper.toDomain(instanceEntity)
    }

    override fun findAllByTaskInstanceId(taskInstanceId: Long): List<TaskInstanceStep> {
        return repository.findAllByTaskInstanceId(taskInstanceId).map { mapper.toDomain(it) }
    }

}
