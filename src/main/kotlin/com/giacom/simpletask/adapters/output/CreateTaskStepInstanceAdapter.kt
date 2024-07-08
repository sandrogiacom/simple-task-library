package com.giacom.simpletask.adapters.output

import com.giacom.simpletask.adapters.output.repository.TaskStepInstanceRepository
import com.giacom.simpletask.adapters.output.repository.mapper.TaskStepInstanceEntityMapper
import com.giacom.simpletask.application.core.domain.TaskStepInstance
import com.giacom.simpletask.application.ports.output.CreateTaskStepInstanceOutput
import org.springframework.stereotype.Component

@Component
class CreateTaskStepInstanceAdapter(
    private val repository: TaskStepInstanceRepository,
    private val mapper: TaskStepInstanceEntityMapper
) : CreateTaskStepInstanceOutput {

    override fun create(taskStepInstance: TaskStepInstance): TaskStepInstance {
        val instanceEntity = repository.save(mapper.toEntity(taskStepInstance))
        return mapper.toDomain(instanceEntity)
    }

}
