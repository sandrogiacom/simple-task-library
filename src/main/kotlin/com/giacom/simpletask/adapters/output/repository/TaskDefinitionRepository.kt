package com.giacom.simpletask.adapters.output.repository

import com.giacom.simpletask.adapters.output.repository.entity.TaskDefinitionEntity
import org.springframework.data.repository.CrudRepository
import java.util.*

interface TaskDefinitionRepository : CrudRepository<TaskDefinitionEntity, Long> {
    fun findByTaskName(taskName: String): Optional<TaskDefinitionEntity>
}
