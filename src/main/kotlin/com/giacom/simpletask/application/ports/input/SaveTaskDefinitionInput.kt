package com.giacom.simpletask.application.ports.input

import com.giacom.simpletask.application.core.domain.TaskDefinition

interface SaveTaskDefinitionInput {

    fun create(taskDefinition: TaskDefinition): TaskDefinition
    fun update(id: Long, taskDefinition: TaskDefinition): TaskDefinition

}
