package com.giacom.simpletask.adapters.output

import com.giacom.simpletask.adapters.output.repository.TaskInstanceAttributeRepository
import com.giacom.simpletask.adapters.output.repository.mapper.TaskInstanceAttributeEntityMapper
import com.giacom.simpletask.application.core.domain.TaskInstanceAttribute
import com.giacom.simpletask.application.ports.output.SaveTaskInstanceAttributeOutput
import org.springframework.stereotype.Component

@Component
class TaskInstanceAttributeAdapter(
    private val repository: TaskInstanceAttributeRepository,
    private val mapper: TaskInstanceAttributeEntityMapper
) : SaveTaskInstanceAttributeOutput {

    override fun save(taskAttributeInstance: TaskInstanceAttribute): TaskInstanceAttribute {
        val instanceEntity = repository.save(mapper.toEntity(taskAttributeInstance))
        return mapper.toDomain(instanceEntity)
    }



}
