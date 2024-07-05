package com.giacom.simpletask.adapters.output

import com.giacom.simpletask.adapters.output.repository.TaskAttributeInstanceRepository
import com.giacom.simpletask.adapters.output.repository.mapper.TaskAttributeInstanceEntityMapper
import com.giacom.simpletask.application.core.domain.TaskAttributeInstance
import com.giacom.simpletask.application.ports.output.CreateTaskAttributeInstanceOutput
import org.springframework.stereotype.Component

@Component
class CreateTaskAttributeInstanceAdapter(
    private val repository: TaskAttributeInstanceRepository,
    private val mapper: TaskAttributeInstanceEntityMapper
) : CreateTaskAttributeInstanceOutput {

    override fun create(taskAttributeInstance: TaskAttributeInstance): TaskAttributeInstance {
        TODO("Not yet implemented")
    }

}
