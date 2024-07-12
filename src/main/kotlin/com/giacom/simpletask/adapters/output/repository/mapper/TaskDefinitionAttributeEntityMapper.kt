package com.giacom.simpletask.adapters.output.repository.mapper

import com.giacom.simpletask.adapters.output.repository.entity.TaskDefinitionAttributeEntity
import com.giacom.simpletask.application.core.domain.TaskDefinitionAttribute
import org.mapstruct.Mapper
import org.springframework.stereotype.Component

@Mapper(componentModel = "spring")
@Component
interface TaskDefinitionAttributeEntityMapper {

    fun toEntity(taskDefinitionAttribute: TaskDefinitionAttribute): TaskDefinitionAttributeEntity
    fun toDomain(taskDefinitionAttributeEntity: TaskDefinitionAttributeEntity): TaskDefinitionAttribute
}
