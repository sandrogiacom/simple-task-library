package com.giacom.simpletask.application.ports.input

interface DeleteTaskDefinitionStepInput {
    fun deleteById(id: Long)
}
