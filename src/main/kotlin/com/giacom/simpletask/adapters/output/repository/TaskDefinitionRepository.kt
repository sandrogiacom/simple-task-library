package com.giacom.simpletask.adapters.output.repository

import com.giacom.simpletask.adapters.out.repository.entity.TaskDefinitionEntity
import org.springframework.data.repository.CrudRepository

interface TaskDefinitionRepository: CrudRepository<TaskDefinitionEntity, Long>
