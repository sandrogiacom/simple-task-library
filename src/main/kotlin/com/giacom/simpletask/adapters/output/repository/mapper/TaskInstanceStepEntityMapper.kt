package com.giacom.simpletask.adapters.output.repository.mapper

import com.giacom.simpletask.adapters.output.repository.entity.TaskInstanceStepEntity
import com.giacom.simpletask.application.core.domain.TaskInstanceStep
import org.mapstruct.Mapper
import org.springframework.stereotype.Component

@Mapper(componentModel = "spring")
@Component
interface TaskInstanceStepEntityMapper {

    fun toEntity(taskInstanceStep: TaskInstanceStep): TaskInstanceStepEntity

    fun toDomain(taskInstanceStepEntity: TaskInstanceStepEntity): TaskInstanceStep
}
