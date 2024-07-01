package com.giacom.simpletask.adapters.input.controller.mapper

import com.giacom.simpletask.adapters.input.controller.request.TaskStepDefinitionCreateRequest
import com.giacom.simpletask.adapters.input.controller.response.TaskStepDefinitionResponse
import com.giacom.simpletask.application.core.domain.TaskStepDefinition
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(componentModel = "spring")
interface TaskStepDefinitionMapper {

    @Mapping(target = "taskDefinition", ignore = true)
    @Mapping(target = "id", ignore = true)
    fun toDomain(taskStepDefinitionCreateRequest: TaskStepDefinitionCreateRequest): TaskStepDefinition

    @Mapping(target = "taskDefinitionId", source = "taskDefinition.id")
    fun toResponse(taskStepDefinition: TaskStepDefinition): TaskStepDefinitionResponse

    @Mapping(target = "taskDefinitionId", source = "taskDefinition.id")
    fun toResponseList(taskStepDefinitions: List<TaskStepDefinition>): List<TaskStepDefinitionResponse>
}
