package com.giacom.simpletask.controller.mapper

import com.giacom.simpletask.controller.request.TaskDefinitionCreateRequest
import com.giacom.simpletask.controller.response.TaskDefinitionResponse
import com.giacom.simpletask.domain.TaskDefinition
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface TaskDefinitionMapper {

    fun toDomain(taskDefinitionCreateRequest: TaskDefinitionCreateRequest): TaskDefinition

    fun toResponse(taskDefinition: TaskDefinition): TaskDefinitionResponse

    fun toResponseList(taskDefinitions: List<TaskDefinition>): List<TaskDefinitionResponse>
}
