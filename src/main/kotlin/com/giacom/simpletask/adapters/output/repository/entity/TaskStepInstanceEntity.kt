package com.giacom.simpletask.adapters.output.repository.entity

import com.giacom.simpletask.application.core.domain.TaskStatus
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "task_step_instance")
data class TaskStepInstanceEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val taskInstanceId: Long,
    val taskStepDefinitionId: Long,
    @Enumerated(EnumType.STRING)
    val status: TaskStatus,
    val startedAt: LocalDateTime? = null,
    val endedAt: LocalDateTime? = null
)
