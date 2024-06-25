package com.giacom.simple_workflow.service

import com.giacom.simple_workflow.persistence.entity.ProcessDefinitionJpa
import com.giacom.simple_workflow.persistence.repository.ProcessDefinitionRepository
import org.springframework.stereotype.Service

@Service
class ProcessDefinitionService(
    private val repository: ProcessDefinitionRepository
) {

    fun create(processDefinitionJpa: ProcessDefinitionJpa): ProcessDefinitionJpa {
        return repository.save(processDefinitionJpa)
    }




}