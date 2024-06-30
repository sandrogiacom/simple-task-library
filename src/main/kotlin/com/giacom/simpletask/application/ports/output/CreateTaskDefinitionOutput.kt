package com.giacom.simpletask.application.ports.output

import com.giacom.simpletask.application.core.domain.TaskDefinition

interface CreateTaskDefinitionOutput {

    fun create(taskDefinition: TaskDefinition): TaskDefinition

}
