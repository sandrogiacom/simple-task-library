package com.giacom.simpletask.adapters.output.repository.entity

import jakarta.persistence.*

@Entity
@Table(name = "task_attribute_instance")
data class TaskAttributeInstanceEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val attributeName: String,
    val attributeValue: String
)
