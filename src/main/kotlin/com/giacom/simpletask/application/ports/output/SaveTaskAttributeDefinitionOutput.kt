package com.giacom.simpletask.application.ports.output

import com.giacom.simpletask.application.core.domain.TaskAttributeDefinition

interface SaveTaskAttributeDefinitionOutput {

    fun save(taskAttributeDefinition: TaskAttributeDefinition): TaskAttributeDefinition

}
