package com.giacom.simpletask.adapters.input.controller

import com.giacom.simpletask.adapters.input.controller.mapper.TaskAttributeDefinitionMapper
import com.giacom.simpletask.adapters.input.controller.request.TaskAttributeDefinitionCreateRequest
import com.giacom.simpletask.adapters.input.controller.response.TaskAttributeDefinitionResponse
import com.giacom.simpletask.application.ports.input.DeleteTaskAttributeDefinitionInput
import com.giacom.simpletask.application.ports.input.FindTaskAttributeDefinitionInput
import com.giacom.simpletask.application.ports.input.SaveTaskAttributeDefinitionInput
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/task-definitions/")
class TaskAttributeDefinitionController(
    private val saveAttributeInput: SaveTaskAttributeDefinitionInput,
    private val findAttributeInput: FindTaskAttributeDefinitionInput,
    private val deleteAttributeInput: DeleteTaskAttributeDefinitionInput,
    private val mapper: TaskAttributeDefinitionMapper
) {

    @PostMapping("/{taskDefinitionId}/attributes")
    fun create(
        @Valid @RequestBody request: TaskAttributeDefinitionCreateRequest, @PathVariable taskDefinitionId: Long
    ): ResponseEntity<TaskAttributeDefinitionResponse> {
        val taskAttributeDefinition = saveAttributeInput.create(taskDefinitionId, mapper.toDomain(request))
        return ResponseEntity.ok(mapper.toResponse(taskAttributeDefinition))
    }

    @GetMapping("/{taskDefinitionId}/attributes")
    fun findAllSteps(@PathVariable taskDefinitionId: Long): ResponseEntity<List<TaskAttributeDefinitionResponse>> {
        val taskAttributeDefinitions = findAttributeInput.findAllByTaskDefinitionId(taskDefinitionId)
        return ResponseEntity.ok(mapper.toResponseList(taskAttributeDefinitions))
    }

    @GetMapping("/attributes/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<TaskAttributeDefinitionResponse> {
        val taskAttributeDefinition = findAttributeInput.findById(id)
        return ResponseEntity.ok(mapper.toResponse(taskAttributeDefinition))
    }

    @PutMapping("/attributes/{id}")
    fun updateAttribute(
        @PathVariable id: Long,
        @Valid @RequestBody request: TaskAttributeDefinitionCreateRequest
    ): ResponseEntity<TaskAttributeDefinitionResponse> {
        val taskAttributeDefinition = saveAttributeInput.update(id, mapper.toDomain(request))
        return ResponseEntity.ok(mapper.toResponse(taskAttributeDefinition))
    }

    @DeleteMapping("/attributes/{id}")
    fun deleteAttribute(@PathVariable id: Long): ResponseEntity<Unit> {
        deleteAttributeInput.deleteById(id)
        return ResponseEntity.noContent().build()
    }

}
