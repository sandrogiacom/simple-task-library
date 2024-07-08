package com.giacom.simpletask.adapters.output.repository

import com.giacom.simpletask.adapters.output.repository.entity.TaskAttributeInstanceEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TaskAttributeInstanceRepository : CrudRepository<TaskAttributeInstanceEntity, Long>
