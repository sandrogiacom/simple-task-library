package com.giacom.simpletask.adapters.output.repository.entity

import com.giacom.simpletask.application.core.domain.TaskDefinitionStep
import com.giacom.simpletask.application.core.domain.TaskStatus
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "task_instance_step")
data class TaskInstanceStepEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val taskInstanceId: Long,
    @ManyToOne
    @JoinColumn(name = "task_definition_step_id")
    val taskDefinitionStep: TaskDefinitionStepEntity,
    @Enumerated(EnumType.STRING)
    val status: TaskStatus,
    val startedAt: LocalDateTime? = null,
    val endedAt: LocalDateTime? = null
)
