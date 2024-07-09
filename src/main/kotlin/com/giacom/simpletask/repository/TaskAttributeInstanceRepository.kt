package com.giacom.simpletask.repository

import com.giacom.simpletask.repository.entity.TaskAttributeInstanceEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TaskAttributeInstanceRepository : CrudRepository<TaskAttributeInstanceEntity, Long>
