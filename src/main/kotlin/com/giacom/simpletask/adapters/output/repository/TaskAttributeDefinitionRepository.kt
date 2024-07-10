package com.giacom.simpletask.adapters.output.repository

import com.giacom.simpletask.adapters.output.repository.entity.TaskAttributeDefinitionEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TaskAttributeDefinitionRepository : CrudRepository<TaskAttributeDefinitionEntity, Long>{
    fun findAllByTaskDefinitionId(taskDefinitionId: Long): List<TaskAttributeDefinitionEntity>
    fun findByAttributeName(attributeName: String): TaskAttributeDefinitionEntity
}
