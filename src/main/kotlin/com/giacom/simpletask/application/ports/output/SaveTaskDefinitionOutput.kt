package com.giacom.simpletask.application.ports.output

import com.giacom.simpletask.application.core.domain.TaskDefinition

interface SaveTaskDefinitionOutput {

    fun save(taskDefinition: TaskDefinition): TaskDefinition

}
