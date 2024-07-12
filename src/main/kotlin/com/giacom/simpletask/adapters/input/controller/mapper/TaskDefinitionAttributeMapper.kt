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
    fun toDomain(request: TaskDefinitionAttributeCreateRequest): TaskDefinitionAttribute

    @Mapping(target = "taskDefinitionId", source = "taskDefinition.id")
    fun toResponse(taskDefinitionAttribute: TaskDefinitionAttribute): TaskDefinitionAttributeResponse

    @Mapping(target = "taskDefinitionId", source = "taskDefinition.id")
    fun toResponseList(definitionAttributeList: List<TaskDefinitionAttribute>): List<TaskDefinitionAttributeResponse>
}
