package com.giacom.simpletask.adapters.input.controller

import com.giacom.simpletask.adapters.input.controller.mapper.TaskDefinitionAttributeMapper
import com.giacom.simpletask.adapters.input.controller.request.TaskDefinitionAttributeCreateRequest
import com.giacom.simpletask.adapters.input.controller.response.TaskDefinitionAttributeResponse
import com.giacom.simpletask.application.ports.input.DeleteTaskDefinitionAttributeInput
import com.giacom.simpletask.application.ports.input.FindTaskDefinitionAttributeInput
import com.giacom.simpletask.application.ports.input.SaveTaskDefinitionAttributeInput
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/task-definitions/")
class TaskDefinitionAttributeController(
    private val saveAttributeInput: SaveTaskDefinitionAttributeInput,
    private val findAttributeInput: FindTaskDefinitionAttributeInput,
    private val deleteAttributeInput: DeleteTaskDefinitionAttributeInput,
    private val mapper: TaskDefinitionAttributeMapper
) {

    @PostMapping("/{taskDefinitionId}/attributes")
    fun create(
        @Valid @RequestBody request: TaskDefinitionAttributeCreateRequest, @PathVariable taskDefinitionId: Long
    ): ResponseEntity<TaskDefinitionAttributeResponse> {
        val taskAttributeDefinition = saveAttributeInput.create(taskDefinitionId, mapper.toDomain(request))
        return ResponseEntity.ok(mapper.toResponse(taskAttributeDefinition))
    }

    @GetMapping("/{taskDefinitionId}/attributes")
    fun findAllSteps(@PathVariable taskDefinitionId: Long): ResponseEntity<List<TaskDefinitionAttributeResponse>> {
        val taskAttributeDefinitions = findAttributeInput.findAllByTaskDefinitionId(taskDefinitionId)
        return ResponseEntity.ok(mapper.toResponseList(taskAttributeDefinitions))
    }

    @GetMapping("/attributes/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<TaskDefinitionAttributeResponse> {
        val taskAttributeDefinition = findAttributeInput.findById(id)
        return ResponseEntity.ok(mapper.toResponse(taskAttributeDefinition))
    }

    @PutMapping("/attributes/{id}")
    fun updateAttribute(
        @PathVariable id: Long,
        @Valid @RequestBody request: TaskDefinitionAttributeCreateRequest
    ): ResponseEntity<TaskDefinitionAttributeResponse> {
        val taskAttributeDefinition = saveAttributeInput.update(id, mapper.toDomain(request))
        return ResponseEntity.ok(mapper.toResponse(taskAttributeDefinition))
    }

    @DeleteMapping("/attributes/{id}")
    fun deleteAttribute(@PathVariable id: Long): ResponseEntity<Unit> {
        deleteAttributeInput.deleteById(id)
        return ResponseEntity.noContent().build()
    }

}