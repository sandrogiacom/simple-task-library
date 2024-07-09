package com.giacom.simpletask.controller.mapper

import com.giacom.simpletask.controller.request.TaskAttributeDefinitionCreateRequest
import com.giacom.simpletask.controller.response.TaskAttributeDefinitionResponse
import com.giacom.simpletask.domain.TaskAttributeDefinition
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(componentModel = "spring")
interface TaskAttributeDefinitionMapper {

    @Mapping(target = "taskDefinition", ignore = true)
    @Mapping(target = "id", ignore = true)
    fun toDomain(taskAttributeDefinitionCreateRequest: TaskAttributeDefinitionCreateRequest): TaskAttributeDefinition

    @Mapping(target = "taskDefinitionId", source = "taskDefinition.id")
    fun toResponse(taskAttributeDefinition: TaskAttributeDefinition): TaskAttributeDefinitionResponse

    @Mapping(target = "taskDefinitionId", source = "taskDefinition.id")
    fun toResponseList(taskAttributeDefinitions: List<TaskAttributeDefinition>): List<TaskAttributeDefinitionResponse>
}
