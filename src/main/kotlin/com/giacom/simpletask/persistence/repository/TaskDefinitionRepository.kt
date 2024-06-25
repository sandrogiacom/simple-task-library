package com.giacom.simpletask.persistence.repository

import com.giacom.simpletask.persistence.entity.TaskDefinitionJpa
import org.springframework.data.repository.CrudRepository

interface TaskDefinitionRepository: CrudRepository<TaskDefinitionJpa, Long>
