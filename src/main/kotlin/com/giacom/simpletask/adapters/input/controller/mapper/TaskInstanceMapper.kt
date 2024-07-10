package com.giacom.simpletask.adapters.input.controller.mapper

import com.giacom.simpletask.adapters.input.controller.response.TaskInstanceResponse
import com.giacom.simpletask.application.core.domain.TaskInstance
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface TaskInstanceMapper {

    fun toTaskInstanceResponse(taskInstance: TaskInstance): TaskInstanceResponse
}
