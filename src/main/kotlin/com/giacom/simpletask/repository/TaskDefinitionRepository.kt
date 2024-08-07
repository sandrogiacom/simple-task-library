package com.giacom.simpletask.repository

import com.giacom.simpletask.repository.entity.TaskDefinitionEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface TaskDefinitionRepository : CrudRepository<TaskDefinitionEntity, Long> {
    fun findByTaskName(taskName: String): Optional<TaskDefinitionEntity>
}
