package com.giacom.simpletask.adapters.input.controller.mapper

import com.giacom.simpletask.adapters.input.controller.response.TaskInstanceAttributeResponse
import com.giacom.simpletask.adapters.input.controller.response.TaskInstanceResponse
import com.giacom.simpletask.adapters.input.controller.response.TaskInstanceStepResponse
import com.giacom.simpletask.application.core.domain.TaskInstance
import com.giacom.simpletask.application.core.domain.TaskInstanceAttribute
import com.giacom.simpletask.application.core.domain.TaskInstanceStep
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(componentModel = "spring")
interface TaskInstanceMapper {

    @Mapping(target = "taskDefinitionId", source = "taskDefinition.id")
    @Mapping(target = "taskDefinitionName", source = "taskDefinition.taskName")
    @Mapping(target = "taskDefinitionDescription", source = "taskDefinition.taskDescription")
    fun toTaskInstanceResponse(taskInstance: TaskInstance): TaskInstanceResponse

    fun toTaskInstanceAttributeResponse(taskInstanceAttribute: TaskInstanceAttribute): TaskInstanceAttributeResponse

    @Mapping(target = "stepName", source = "taskDefinitionStep.stepName")
    @Mapping(target = "stepDescription", source = "taskDefinitionStep.stepDescription")
    @Mapping(target = "stepNumber", source = "taskDefinitionStep.stepNumber")
    fun toTaskInstanceStepResponse(taskInstanceStep: TaskInstanceStep): TaskInstanceStepResponse

}
