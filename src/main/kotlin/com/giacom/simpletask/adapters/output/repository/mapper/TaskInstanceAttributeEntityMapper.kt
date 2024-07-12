package com.giacom.simpletask.adapters.output.repository.mapper

import com.giacom.simpletask.adapters.output.repository.entity.TaskInstanceAttributeEntity
import com.giacom.simpletask.application.core.domain.TaskInstanceAttribute
import org.mapstruct.Mapper
import org.springframework.stereotype.Component

@Mapper(componentModel = "spring")
@Component
interface TaskInstanceAttributeEntityMapper {

    fun toEntity(taskInstanceAttribute: TaskInstanceAttribute): TaskInstanceAttributeEntity

    fun toDomain(taskInstanceAttributeEntity: TaskInstanceAttributeEntity): TaskInstanceAttribute
}
