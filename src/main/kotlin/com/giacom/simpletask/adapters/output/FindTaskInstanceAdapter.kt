package com.giacom.simpletask.adapters.output

import com.giacom.simpletask.adapters.output.repository.TaskInstanceRepository
import com.giacom.simpletask.adapters.output.repository.mapper.TaskInstanceEntityMapper
import com.giacom.simpletask.application.core.domain.TaskInstance
import com.giacom.simpletask.application.ports.output.FindTaskInstanceOutput
import org.springframework.stereotype.Component

@Component
class FindTaskInstanceAdapter(
    private val repository: TaskInstanceRepository,
    private val mapper: TaskInstanceEntityMapper
) : FindTaskInstanceOutput {

    override fun findById(id: Long): TaskInstance {
        val taskInstanceEntity = repository.findById(id).orElseThrow { NoSuchElementException() }
        return mapper.toDomain(taskInstanceEntity)
    }

}
