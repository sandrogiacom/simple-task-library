package com.giacom.simpletask.application.ports.input

interface DeleteTaskDefinitionInput {
    fun deleteById(id: Long)
}
