package com.giacom.simpletask.adapters.output.repository.entity

import jakarta.persistence.*

@Entity
@Table(name = "task_definition_attribute")
data class TaskDefinitionAttributeEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val attributeName: String,
    @ManyToOne
    @JoinColumn(name = "task_definition_id")
    val taskDefinition: TaskDefinitionEntity
)
