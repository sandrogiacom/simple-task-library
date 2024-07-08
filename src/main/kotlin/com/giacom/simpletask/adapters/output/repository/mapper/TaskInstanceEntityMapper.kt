package com.giacom.simpletask.adapters.output.repository.mapper

import com.giacom.simpletask.adapters.output.repository.entity.TaskInstanceEntity
import com.giacom.simpletask.application.core.domain.TaskInstance
import org.mapstruct.Mapper
import org.springframework.stereotype.Component

@Mapper(componentModel = "spring")
@Component
interface TaskInstanceEntityMapper {

    fun toEntity(taskInstance: TaskInstance): TaskInstanceEntity

    fun toDomain(taskInstanceEntity: TaskInstanceEntity): TaskInstance
}
