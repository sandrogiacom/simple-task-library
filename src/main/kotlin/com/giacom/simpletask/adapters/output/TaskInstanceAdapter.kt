package com.giacom.simpletask.adapters.output

import com.giacom.simpletask.adapters.output.repository.TaskInstanceRepository
import com.giacom.simpletask.adapters.output.repository.mapper.TaskInstanceEntityMapper
import com.giacom.simpletask.application.core.domain.TaskInstance
import com.giacom.simpletask.application.ports.output.SaveTaskInstanceOutput
import org.springframework.stereotype.Component

@Component
class TaskInstanceAdapter(
    private val repository: TaskInstanceRepository,
    private val mapper: TaskInstanceEntityMapper
) : SaveTaskInstanceOutput {

    override fun save(taskInstance: TaskInstance): TaskInstance {
        val instanceEntity = repository.save(mapper.toEntity(taskInstance))
        return mapper.toDomain(instanceEntity)
    }

}
