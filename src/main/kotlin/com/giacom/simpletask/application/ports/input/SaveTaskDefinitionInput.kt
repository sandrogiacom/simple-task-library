package com.giacom.simpletask.application.ports.input

import com.giacom.simpletask.application.core.domain.TaskDefinition

interface SaveTaskDefinitionInput {

    fun save(taskDefinition: TaskDefinition): TaskDefinition

}
