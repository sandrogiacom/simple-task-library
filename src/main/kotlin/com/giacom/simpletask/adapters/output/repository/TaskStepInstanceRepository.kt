package com.giacom.simpletask.adapters.output.repository

import com.giacom.simpletask.adapters.output.repository.entity.TaskStepInstanceEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TaskStepInstanceRepository : CrudRepository<TaskStepInstanceEntity, Long> {
}
