package com.giacom.simpletask.adapters.output.repository

import com.giacom.simpletask.adapters.output.repository.entity.TaskStepDefinitionEntity
import com.giacom.simpletask.application.core.domain.TaskStepDefinition
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface TaskStepDefinitionRepository : CrudRepository<TaskStepDefinitionEntity, Long>{
    fun findAllByTaskDefinitionId(taskDefinitionId: Long): List<TaskStepDefinitionEntity>
    fun findByStepName(stepName: String): Optional<TaskStepDefinitionEntity>
}
