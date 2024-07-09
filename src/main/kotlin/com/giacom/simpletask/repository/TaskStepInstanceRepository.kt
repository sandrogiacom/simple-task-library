package com.giacom.simpletask.repository

import com.giacom.simpletask.repository.entity.TaskStepInstanceEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TaskStepInstanceRepository : CrudRepository<TaskStepInstanceEntity, Long> {
}
