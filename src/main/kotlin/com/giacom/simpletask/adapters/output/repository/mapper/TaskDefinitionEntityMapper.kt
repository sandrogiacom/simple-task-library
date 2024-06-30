package com.giacom.simpletask.adapters.output.repository.mapper

import com.giacom.simpletask.adapters.output.repository.entity.TaskDefinitionEntity
import com.giacom.simpletask.adapters.output.repository.entity.TaskStepDefinitionEntity
import com.giacom.simpletask.application.core.domain.TaskDefinition
import com.giacom.simpletask.application.core.domain.TaskStepDefinition
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface TaskDefinitionEntityMapper {

    fun toEntity(taskDefinition: TaskDefinition): TaskDefinitionEntity
    fun toDomain(taskDefinitionEntity: TaskDefinitionEntity): TaskDefinition
    fun toStepEntity(taskStepDefinition: TaskStepDefinition): TaskStepDefinitionEntity
    fun toStepDomain(taskStepDefinitionEntity: TaskStepDefinitionEntity): TaskStepDefinition
}
