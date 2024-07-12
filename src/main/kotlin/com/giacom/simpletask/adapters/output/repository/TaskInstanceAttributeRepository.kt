package com.giacom.simpletask.adapters.output.repository

import com.giacom.simpletask.adapters.output.repository.entity.TaskInstanceAttributeEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TaskInstanceAttributeRepository : CrudRepository<TaskInstanceAttributeEntity, Long>
