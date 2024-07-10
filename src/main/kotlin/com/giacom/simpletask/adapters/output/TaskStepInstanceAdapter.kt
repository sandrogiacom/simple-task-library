package com.giacom.simpletask.adapters.output

import com.giacom.simpletask.adapters.output.repository.TaskStepInstanceRepository
import com.giacom.simpletask.adapters.output.repository.mapper.TaskStepInstanceEntityMapper
import com.giacom.simpletask.application.core.domain.TaskStepInstance
import com.giacom.simpletask.application.ports.output.SaveTaskStepInstanceOutput
import org.springframework.stereotype.Component

@Component
class TaskStepInstanceAdapter(
    private val repository: TaskStepInstanceRepository,
    private val mapper: TaskStepInstanceEntityMapper
) : SaveTaskStepInstanceOutput {

    override fun save(taskStepInstance: TaskStepInstance): TaskStepInstance {
        val instanceEntity = repository.save(mapper.toEntity(taskStepInstance))
        return mapper.toDomain(instanceEntity)
    }

}
