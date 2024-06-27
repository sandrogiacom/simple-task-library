package com.giacom.simpletask.application.ports.input

import com.giacom.simpletask.application.core.domain.TaskDefinition

interface CreateTaskDefinitionInput {

    fun create(taskDefinition: TaskDefinition): TaskDefinition

}
