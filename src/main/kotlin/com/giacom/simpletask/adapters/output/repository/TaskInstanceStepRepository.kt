package com.giacom.simpletask.adapters.output.repository

import com.giacom.simpletask.adapters.output.repository.entity.TaskInstanceStepEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TaskInstanceStepRepository : CrudRepository<TaskInstanceStepEntity, Long> {
}
