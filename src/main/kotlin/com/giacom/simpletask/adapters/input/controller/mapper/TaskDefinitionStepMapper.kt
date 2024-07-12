package com.giacom.simpletask.adapters.input.controller.mapper

import com.giacom.simpletask.adapters.input.controller.request.TaskDefinitionStepCreateRequest
import com.giacom.simpletask.adapters.input.controller.response.TaskDefinitionStepResponse
import com.giacom.simpletask.application.core.domain.TaskDefinitionStep
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(componentModel = "spring")
interface TaskDefinitionStepMapper {

    @Mapping(target = "taskDefinition", ignore = true)
    @Mapping(target = "id", ignore = true)
    fun toDomain(taskDefinitionStepCreateRequest: TaskDefinitionStepCreateRequest): TaskDefinitionStep

    @Mapping(target = "taskDefinitionId", source = "taskDefinition.id")
    fun toResponse(taskDefinitionStep: TaskDefinitionStep): TaskDefinitionStepResponse

    @Mapping(target = "taskDefinitionId", source = "taskDefinition.id")
    fun toResponseList(taskDefinitionStepList: List<TaskDefinitionStep>): List<TaskDefinitionStepResponse>
}
