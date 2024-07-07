package com.giacom.simpletask.adapters.output.repository.mapper

import com.giacom.simpletask.adapters.output.repository.entity.TaskStepInstanceEntity
import com.giacom.simpletask.application.core.domain.TaskStepInstance
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface TaskStepInstanceEntityMapper {

    fun toEntity(taskStepInstance: TaskStepInstance): TaskStepInstanceEntity

    fun toDomain(taskStepInstanceEntity: TaskStepInstanceEntity): TaskStepInstance
}
