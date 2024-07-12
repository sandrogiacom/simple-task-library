package com.giacom.simpletask.application.ports.output

interface DeleteTaskDefinitionStepOutput {
    fun deleteById(id: Long)
}
