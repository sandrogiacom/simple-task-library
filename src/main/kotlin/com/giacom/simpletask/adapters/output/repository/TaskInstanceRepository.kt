package com.giacom.simpletask.adapters.output.repository

import com.giacom.simpletask.adapters.output.repository.entity.TaskInstanceEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TaskInstanceRepository : CrudRepository<TaskInstanceEntity, Long>
