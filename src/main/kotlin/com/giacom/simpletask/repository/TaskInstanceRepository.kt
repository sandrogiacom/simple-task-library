package com.giacom.simpletask.repository

import com.giacom.simpletask.repository.entity.TaskInstanceEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TaskInstanceRepository : CrudRepository<TaskInstanceEntity, Long>
