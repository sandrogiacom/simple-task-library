package com.giacom.simpletask.adapters.out.repository.entity

import jakarta.persistence.*

@Entity
data class TaskAttributeDefinitionEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val attributeName: String,
    @ManyToOne
    val taskDefinitionEntity: TaskDefinitionEntity
)
