package com.giacom.simpletask.adapters.output

import com.giacom.simpletask.adapters.output.repository.TaskInstanceStepRepository
import com.giacom.simpletask.adapters.output.repository.mapper.TaskInstanceStepEntityMapper
import com.giacom.simpletask.application.core.domain.TaskInstanceStep
import com.giacom.simpletask.application.ports.output.SaveTaskInstanceStepOutput
import org.springframework.stereotype.Component

@Component
class TaskInstanceStepAdapter(
    private val repository: TaskInstanceStepRepository,
    private val mapper: TaskInstanceStepEntityMapper
) : SaveTaskInstanceStepOutput {

    override fun save(taskStepInstance: TaskInstanceStep): TaskInstanceStep {
        val instanceEntity = repository.save(mapper.toEntity(taskStepInstance))
        return mapper.toDomain(instanceEntity)
    }

}
