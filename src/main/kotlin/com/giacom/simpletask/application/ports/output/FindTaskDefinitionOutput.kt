package com.giacom.simpletask.application.ports.output

import com.giacom.simpletask.application.core.domain.TaskDefinition
import java.util.*

interface FindTaskDefinitionOutput {
    fun findById(id: Long): TaskDefinition
    fun findAll(): List<TaskDefinition>
    fun findByName(taskName: String): TaskDefinition
}
