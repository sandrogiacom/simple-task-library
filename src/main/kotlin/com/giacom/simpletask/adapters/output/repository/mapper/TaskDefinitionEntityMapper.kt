package com.giacom.simpletask.adapters.out.repository.mapper

import com.giacom.simpletask.adapters.out.repository.entity.TaskDefinitionEntity
import com.giacom.simpletask.application.core.domain.TaskDefinition
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface TaskDefinitionEntityMapper {

    fun toEntity(taskDefinition: TaskDefinition): TaskDefinitionEntity
    fun toDomain(taskDefinitionEntity: TaskDefinitionEntity): TaskDefinition

}
