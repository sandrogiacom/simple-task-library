package com.giacom.simple_workflow.persistence.repository

import com.giacom.simple_workflow.persistence.entity.TaskDefinitionJpa
import org.springframework.data.repository.CrudRepository

interface TaskDefinitionRepository: CrudRepository<TaskDefinitionJpa, Long>