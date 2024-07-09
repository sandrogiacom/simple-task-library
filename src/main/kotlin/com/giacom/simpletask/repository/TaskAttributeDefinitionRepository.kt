package com.giacom.simpletask.repository

import com.giacom.simpletask.repository.entity.TaskAttributeDefinitionEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TaskAttributeDefinitionRepository : CrudRepository<TaskAttributeDefinitionEntity, Long> {
    fun findAllByTaskDefinitionId(taskDefinitionId: Long): List<TaskAttributeDefinitionEntity>
}
