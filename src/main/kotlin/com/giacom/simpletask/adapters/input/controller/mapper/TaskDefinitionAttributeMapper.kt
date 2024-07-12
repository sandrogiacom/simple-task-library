package com.giacom.simpletask.adapters.input.controller.mapper

import com.giacom.simpletask.adapters.input.controller.request.TaskDefinitionAttributeCreateRequest
import com.giacom.simpletask.adapters.input.controller.response.TaskDefinitionAttributeResponse
import com.giacom.simpletask.application.core.domain.TaskDefinitionAttribute
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(componentModel = "spring")
interface TaskDefinitionAttributeMapper {

    @Mapping(target = "taskDefinition", ignore = true)
    @Mapping(target = "id", ignore = true)
    fun toDomain(taskAttributeDefinitionCreateRequest: TaskDefinitionAttributeCreateRequest): TaskDefinitionAttribute

    @Mapping(target = "taskDefinitionId", source = "taskDefinition.id")
    fun toResponse(taskAttributeDefinition: TaskDefinitionAttribute): TaskDefinitionAttributeResponse

    @Mapping(target = "taskDefinitionId", source = "taskDefinition.id")
    fun toResponseList(taskAttributeDefinitions: List<TaskDefinitionAttribute>): List<TaskDefinitionAttributeResponse>
}
