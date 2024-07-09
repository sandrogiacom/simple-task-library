package com.giacom.simpletask.repository.entity

import jakarta.persistence.*

@Entity
@Table(name = "task_definition")
data class TaskDefinitionEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val taskName: String,
    val taskDescription: String
)
