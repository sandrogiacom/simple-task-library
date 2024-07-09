package com.giacom.simpletask.repository.entity

import com.giacom.simpletask.domain.TaskStepStatus
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
    val status: TaskStepStatus,
    val startedAt: LocalDateTime? = null,
    val endedAt: LocalDateTime? = null
)
