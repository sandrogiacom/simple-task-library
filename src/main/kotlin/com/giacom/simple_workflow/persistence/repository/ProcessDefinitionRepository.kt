package com.giacom.simple_workflow.persistence.repository

import com.giacom.simple_workflow.persistence.entity.ProcessDefinitionJpa
import org.springframework.data.repository.CrudRepository

interface ProcessDefinitionRepository: CrudRepository<ProcessDefinitionJpa, Long>