package com.giacom.simpletask.repository.mapper

import com.giacom.simpletask.domain.TaskStepInstance
import com.giacom.simpletask.repository.entity.TaskStepInstanceEntity
import org.mapstruct.Mapper
import org.springframework.stereotype.Component

@Mapper(componentModel = "spring")
@Component
interface TaskStepInstanceEntityMapper {

    fun toEntity(taskStepInstance: TaskStepInstance): TaskStepInstanceEntity

    fun toDomain(taskStepInstanceEntity: TaskStepInstanceEntity): TaskStepInstance
}
