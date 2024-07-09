package com.giacom.simpletask.service

import com.giacom.simpletask.domain.TaskAttributeInstance
import com.giacom.simpletask.repository.TaskAttributeInstanceRepository
import com.giacom.simpletask.repository.mapper.TaskAttributeInstanceEntityMapper
import org.springframework.stereotype.Service

@Service
class TaskAttributeInstanceService(
    private val repository: TaskAttributeInstanceRepository,
    private val mapper: TaskAttributeInstanceEntityMapper
) {

    fun create(taskAttributeInstance: TaskAttributeInstance): TaskAttributeInstance {
        val entity = repository.save(
            mapper.toEntity(taskAttributeInstance)
        )
        return mapper.toDomain(entity)
    }

}
