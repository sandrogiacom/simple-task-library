package com.giacom.simpletask.persistence.repository

import com.giacom.simpletask.persistence.entity.TaskStepDefinitionJpa
import org.springframework.data.repository.CrudRepository

interface TaskStepDefinitionRepository: CrudRepository<TaskStepDefinitionJpa, Long>
