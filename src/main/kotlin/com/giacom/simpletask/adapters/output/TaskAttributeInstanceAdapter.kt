package com.giacom.simpletask.adapters.output

import com.giacom.simpletask.adapters.output.repository.TaskAttributeInstanceRepository
import com.giacom.simpletask.adapters.output.repository.mapper.TaskAttributeInstanceEntityMapper
import com.giacom.simpletask.application.core.domain.TaskAttributeInstance
import com.giacom.simpletask.application.ports.output.SaveTaskAttributeInstanceOutput
import org.springframework.stereotype.Component

@Component
class TaskAttributeInstanceAdapter(
    private val repository: TaskAttributeInstanceRepository,
    private val mapper: TaskAttributeInstanceEntityMapper
) : SaveTaskAttributeInstanceOutput {

    override fun save(taskAttributeInstance: TaskAttributeInstance): TaskAttributeInstance {
        val instanceEntity = repository.save(mapper.toEntity(taskAttributeInstance))
        return mapper.toDomain(instanceEntity)
    }

}
