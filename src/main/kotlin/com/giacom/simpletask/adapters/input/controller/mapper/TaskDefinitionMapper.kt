package com.giacom.simpletask.adapters.input.controller.mapper

import com.giacom.simpletask.adapters.input.controller.request.TaskDefinitionCreateRequest
import com.giacom.simpletask.adapters.input.controller.response.TaskDefinitionResponse
import com.giacom.simpletask.application.core.domain.TaskDefinition
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface TaskDefinitionMapper {

    fun toDomain(taskDefinitionCreateRequest: TaskDefinitionCreateRequest): TaskDefinition

    fun toResponse(taskDefinition: TaskDefinition): TaskDefinitionResponse

    fun toResponseList(taskDefinitions: List<TaskDefinition>): List<TaskDefinitionResponse>
}
