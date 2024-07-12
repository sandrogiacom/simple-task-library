package com.giacom.simpletask.application.ports.output

import com.giacom.simpletask.application.core.domain.TaskDefinitionAttribute

interface SaveTaskDefinitionAttributeOutput {

    fun save(taskDefinitionAttribute: TaskDefinitionAttribute): TaskDefinitionAttribute

}
