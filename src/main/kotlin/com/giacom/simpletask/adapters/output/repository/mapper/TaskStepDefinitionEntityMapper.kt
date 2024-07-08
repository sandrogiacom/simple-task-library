package com.giacom.simpletask.adapters.output.repository.mapper

import com.giacom.simpletask.adapters.output.repository.entity.TaskStepDefinitionEntity
import com.giacom.simpletask.application.core.domain.TaskStepDefinition
import org.mapstruct.Mapper
import org.springframework.stereotype.Component

@Mapper(componentModel = "spring")
@Component
interface TaskStepDefinitionEntityMapper {

    fun toEntity(taskStepDefinition: TaskStepDefinition): TaskStepDefinitionEntity
    fun toDomain(taskStepDefinitionEntity: TaskStepDefinitionEntity): TaskStepDefinition
}
