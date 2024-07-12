package com.giacom.simpletask.application.ports.output

import com.giacom.simpletask.application.core.domain.TaskDefinitionStep

interface SaveTaskDefinitionStepOutput {

    fun save(taskStepDefinition: TaskDefinitionStep): TaskDefinitionStep

}
