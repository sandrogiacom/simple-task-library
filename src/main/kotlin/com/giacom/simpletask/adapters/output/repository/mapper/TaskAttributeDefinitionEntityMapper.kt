package com.giacom.simpletask.adapters.output.repository.mapper

import com.giacom.simpletask.adapters.output.repository.entity.TaskAttributeDefinitionEntity
import com.giacom.simpletask.application.core.domain.TaskAttributeDefinition
import org.mapstruct.Mapper
import org.springframework.stereotype.Component

@Mapper(componentModel = "spring")
@Component
interface TaskAttributeDefinitionEntityMapper {

    fun toEntity(taskAttributeDefinition: TaskAttributeDefinition): TaskAttributeDefinitionEntity
    fun toDomain(taskAttributeDefinitionEntity: TaskAttributeDefinitionEntity): TaskAttributeDefinition
}
