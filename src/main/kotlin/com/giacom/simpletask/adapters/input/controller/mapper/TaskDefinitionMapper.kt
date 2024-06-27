package com.giacom.simpletask.adapters.`in`.controller.mapper

import com.giacom.simpletask.adapters.`in`.controller.request.TaskDefinitionCreateRequest
import com.giacom.simpletask.adapters.`in`.controller.response.TaskDefinitionResponse
import com.giacom.simpletask.application.core.domain.TaskDefinition
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface TaskDefinitionMapper {

    fun toDomain(taskDefinitionCreateRequest: TaskDefinitionCreateRequest): TaskDefinition
    fun toResponse(taskDefinition: TaskDefinition): TaskDefinitionResponse

}
