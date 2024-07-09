package com.giacom.simpletask.repository.mapper

import com.giacom.simpletask.domain.TaskDefinition
import com.giacom.simpletask.repository.entity.TaskDefinitionEntity
import org.mapstruct.Mapper
import org.springframework.stereotype.Component

@Mapper(componentModel = "spring")
@Component
interface TaskDefinitionEntityMapper {

    fun toEntity(taskDefinition: TaskDefinition): TaskDefinitionEntity
    fun toDomain(taskDefinitionEntity: TaskDefinitionEntity): TaskDefinition
}
