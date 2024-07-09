package com.giacom.simpletask.service

import com.giacom.simpletask.domain.TaskStepInstance
import com.giacom.simpletask.repository.TaskStepInstanceRepository
import com.giacom.simpletask.repository.mapper.TaskStepInstanceEntityMapper
import org.springframework.stereotype.Service

@Service
class TaskStepInstanceService(
    private val repository: TaskStepInstanceRepository,
    private val mapper: TaskStepInstanceEntityMapper
) {

    fun create(taskStepInstance: TaskStepInstance): TaskStepInstance {
        val entity = repository.save(
            mapper.toEntity(taskStepInstance)
        )
        return mapper.toDomain(entity)
    }

}
