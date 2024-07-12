package com.giacom.simpletask.adapters.output.repository

import com.giacom.simpletask.adapters.output.repository.entity.TaskDefinitionStepEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface TaskDefinitionStepRepository : CrudRepository<TaskDefinitionStepEntity, Long>{
    fun findAllByTaskDefinitionId(taskDefinitionId: Long): List<TaskDefinitionStepEntity>
    fun findByStepName(stepName: String): Optional<TaskDefinitionStepEntity>
}
