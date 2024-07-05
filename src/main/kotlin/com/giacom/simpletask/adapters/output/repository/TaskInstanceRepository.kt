package com.giacom.simpletask.adapters.output.repository

import com.giacom.simpletask.adapters.output.repository.entity.TaskInstanceEntity
import org.springframework.data.repository.CrudRepository

interface TaskInstanceRepository : CrudRepository<TaskInstanceEntity, Long> {
}
