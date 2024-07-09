package com.giacom.simpletask.service

import com.giacom.simpletask.domain.TaskDefinition
import com.giacom.simpletask.repository.TaskDefinitionRepository
import com.giacom.simpletask.repository.mapper.TaskDefinitionEntityMapper
import org.springframework.stereotype.Service

@Service
class TaskDefinitionService(
    private val repository: TaskDefinitionRepository,
    private val mapper: TaskDefinitionEntityMapper,
    private val findService: FindTaskDefinitionService
) {

    fun create(taskDefinition: TaskDefinition): TaskDefinition {
        try {
            val existTask = repository.findByTaskName(taskDefinition.taskName!!)
            if (existTask != null) {
                throw RuntimeException("Task definition already exists!")
            }
        } catch (ex: NoSuchElementException) {
            //nothing to do
        } catch (ex: Exception) {
            throw ex
        }
        val taskDefinitionEntity = repository.save(mapper.toEntity(taskDefinition))
        return mapper.toDomain(taskDefinitionEntity)
    }

    fun update(id: Long, taskDefinition: TaskDefinition): TaskDefinition {
        val existTask = findService.findByIdRepository(id)
        val definitionEntity = mapper.toEntity(taskDefinition)
        val saved = repository.save(
            definitionEntity.copy(id = existTask.id)
        )
        return return mapper.toDomain(saved)
    }

    fun delete(id: Long) {
        val existTask = findService.findByIdRepository(id)
        repository.delete(existTask)
    }

}
