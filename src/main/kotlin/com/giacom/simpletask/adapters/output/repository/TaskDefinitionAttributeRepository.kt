package com.giacom.simpletask.adapters.output.repository

import com.giacom.simpletask.adapters.output.repository.entity.TaskDefinitionAttributeEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TaskDefinitionAttributeRepository : CrudRepository<TaskDefinitionAttributeEntity, Long>{
    fun findAllByTaskDefinitionId(taskDefinitionId: Long): List<TaskDefinitionAttributeEntity>
    fun findByAttributeName(attributeName: String): TaskDefinitionAttributeEntity
}
