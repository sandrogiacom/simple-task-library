package com.giacom.simpletask.adapters.output.repository

import com.giacom.simpletask.adapters.output.repository.entity.TaskStepDefinitionEntity
import org.springframework.data.repository.CrudRepository

interface TaskStepDefinitionRepository : CrudRepository<TaskStepDefinitionEntity, Long>
