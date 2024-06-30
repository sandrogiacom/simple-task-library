package com.giacom.simpletask.adapters.input.controller.mapper

import com.giacom.simpletask.adapters.input.controller.request.TaskDefinitionCreateRequest
import com.giacom.simpletask.adapters.input.controller.request.TaskStepDefinitionCreateRequest
import com.giacom.simpletask.adapters.input.controller.response.TaskDefinitionResponse
import com.giacom.simpletask.adapters.input.controller.response.TaskStepDefinitionResponse
import com.giacom.simpletask.application.core.domain.TaskDefinition
import com.giacom.simpletask.application.core.domain.TaskStepDefinition
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(componentModel = "spring")
interface TaskDefinitionMapper {

    fun toDomain(taskDefinitionCreateRequest: TaskDefinitionCreateRequest): TaskDefinition

    fun toResponse(taskDefinition: TaskDefinition): TaskDefinitionResponse

    @Mapping(target = "taskDefinition", ignore = true)
    @Mapping(target = "id", ignore = true)
    fun toStepDomain(taskStepDefinitionCreateRequest: TaskStepDefinitionCreateRequest): TaskStepDefinition

    fun toStepResponse(taskStepDefinition: TaskStepDefinition): TaskStepDefinitionResponse
}
