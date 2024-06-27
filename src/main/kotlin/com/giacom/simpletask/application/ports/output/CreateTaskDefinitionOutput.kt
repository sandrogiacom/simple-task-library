package com.giacom.simpletask.application.ports.out

import com.giacom.simpletask.application.core.domain.TaskDefinition

interface CreateTaskDefinitionOutput {

    fun create(taskDefinition: TaskDefinition): TaskDefinition

}
