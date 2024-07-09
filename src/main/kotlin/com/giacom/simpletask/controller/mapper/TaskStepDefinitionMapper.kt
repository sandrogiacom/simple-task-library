package com.giacom.simpletask.controller.mapper

import com.giacom.simpletask.controller.request.TaskStepDefinitionCreateRequest
import com.giacom.simpletask.controller.response.TaskStepDefinitionResponse
import com.giacom.simpletask.domain.TaskStepDefinition
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
