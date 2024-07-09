package com.giacom.simpletask.repository.mapper

import com.giacom.simpletask.domain.TaskStepDefinition
import com.giacom.simpletask.repository.entity.TaskStepDefinitionEntity
import org.mapstruct.Mapper
import org.springframework.stereotype.Component

@Mapper(componentModel = "spring")
@Component
interface TaskStepDefinitionEntityMapper {

    fun toEntity(taskStepDefinition: TaskStepDefinition): TaskStepDefinitionEntity
    fun toDomain(taskStepDefinitionEntity: TaskStepDefinitionEntity): TaskStepDefinition
}
