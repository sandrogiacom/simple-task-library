package com.giacom.simpletask.repository.mapper

import com.giacom.simpletask.domain.TaskAttributeDefinition
import com.giacom.simpletask.repository.entity.TaskAttributeDefinitionEntity
import org.mapstruct.Mapper
import org.springframework.stereotype.Component

@Mapper(componentModel = "spring")
@Component
interface TaskAttributeDefinitionEntityMapper {

    fun toEntity(taskAttributeDefinition: TaskAttributeDefinition): TaskAttributeDefinitionEntity
    fun toDomain(taskAttributeDefinitionEntity: TaskAttributeDefinitionEntity): TaskAttributeDefinition
}
