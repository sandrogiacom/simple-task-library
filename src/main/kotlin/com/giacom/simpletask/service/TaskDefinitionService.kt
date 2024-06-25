package com.giacom.simpletask.service

import com.giacom.simpletask.persistence.entity.TaskDefinitionJpa
import com.giacom.simpletask.persistence.repository.TaskDefinitionRepository
import org.springframework.stereotype.Service

@Service
class TaskDefinitionService(
    private val repository: TaskDefinitionRepository
) {

    fun create(taskDefinitionJpa: TaskDefinitionJpa): TaskDefinitionJpa {
        return repository.save(taskDefinitionJpa)
    }




}
