package com.giacom.simpletask.adapters.output.repository

import com.giacom.simpletask.adapters.output.repository.entity.TaskDefinitionAttributeEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface TaskDefinitionAttributeRepository : CrudRepository<TaskDefinitionAttributeEntity, Long> {
    fun findAllByTaskDefinitionId(taskDefinitionId: Long): List<TaskDefinitionAttributeEntity>
    fun findByAttributeName(attributeName: String): Optional<TaskDefinitionAttributeEntity>
}
