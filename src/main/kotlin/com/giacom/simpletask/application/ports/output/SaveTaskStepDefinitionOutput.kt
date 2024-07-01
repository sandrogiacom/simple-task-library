package com.giacom.simpletask.application.ports.output

import com.giacom.simpletask.application.core.domain.TaskStepDefinition

interface SaveTaskStepDefinitionOutput {

    fun save(taskStepDefinition: TaskStepDefinition): TaskStepDefinition

}
