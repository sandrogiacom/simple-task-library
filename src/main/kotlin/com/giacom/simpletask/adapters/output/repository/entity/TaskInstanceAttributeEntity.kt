package com.giacom.simpletask.adapters.output.repository.entity

import jakarta.persistence.*

@Entity
@Table(name = "task_instance_attribute")
data class TaskInstanceAttributeEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val attributeName: String,
    val attributeValue: String? = null,
    val taskInstanceId: Long
)
