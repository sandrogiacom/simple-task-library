package com.giacom.simpletask.adapters.output.repository

import com.giacom.simpletask.adapters.output.repository.entity.TaskStepDefinitionEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TaskStepDefinitionRepository : CrudRepository<TaskStepDefinitionEntity, Long>{
    fun findAllByTaskDefinitionId(taskDefinitionId: Long): List<TaskStepDefinitionEntity>
}
