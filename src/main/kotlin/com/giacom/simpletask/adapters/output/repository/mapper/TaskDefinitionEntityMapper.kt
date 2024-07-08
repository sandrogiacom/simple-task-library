package com.giacom.simpletask.adapters.output.repository.mapper

import com.giacom.simpletask.adapters.output.repository.entity.TaskDefinitionEntity
import com.giacom.simpletask.application.core.domain.TaskDefinition
import org.mapstruct.Mapper
import org.springframework.stereotype.Component

@Mapper(componentModel = "spring")
@Component
interface TaskDefinitionEntityMapper {

    fun toEntity(taskDefinition: TaskDefinition): TaskDefinitionEntity
    fun toDomain(taskDefinitionEntity: TaskDefinitionEntity): TaskDefinition
}
