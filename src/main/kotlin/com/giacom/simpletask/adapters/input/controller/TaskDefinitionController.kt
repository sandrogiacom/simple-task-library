package com.giacom.simpletask.adapters.input.controller

import com.giacom.simpletask.adapters.input.controller.mapper.TaskDefinitionMapper
import com.giacom.simpletask.adapters.input.controller.request.TaskDefinitionCreateRequest
import com.giacom.simpletask.adapters.input.controller.request.TaskStepDefinitionCreateRequest
import com.giacom.simpletask.adapters.input.controller.response.TaskDefinitionResponse
import com.giacom.simpletask.adapters.input.controller.response.TaskStepDefinitionResponse
import com.giacom.simpletask.application.ports.input.CreateTaskDefinitionInput
import com.giacom.simpletask.application.ports.input.CreateTaskStepDefinitionInput
import com.giacom.simpletask.application.ports.input.FindTaskDefinitionInput
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/task-definitions")
class TaskDefinitionController(
    private val createInput: CreateTaskDefinitionInput,
    private val createStepInput: CreateTaskStepDefinitionInput,
    private val findInput: FindTaskDefinitionInput,
    private val mapper: TaskDefinitionMapper
) {

    @PostMapping
    fun create(@Valid @RequestBody request: TaskDefinitionCreateRequest): ResponseEntity<TaskDefinitionResponse> {
        val taskDefinition = createInput.create(mapper.toDomain(request))
        return ResponseEntity.ok(mapper.toResponse(taskDefinition))
    }

    @PostMapping("/{id}/steps")
    fun createStep(@Valid @RequestBody request: TaskStepDefinitionCreateRequest, @PathVariable id: Long):
            ResponseEntity<TaskStepDefinitionResponse> {
        val taskStepDefinition = createStepInput.create(id, mapper.toStepDomain(request))
        return ResponseEntity.ok(mapper.toStepResponse(taskStepDefinition))
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<TaskDefinitionResponse> {
        val taskDefinition = findInput.findById(id)
        return ResponseEntity.ok(mapper.toResponse(taskDefinition))
    }

}
