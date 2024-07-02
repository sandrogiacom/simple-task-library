package com.giacom.simpletask.adapters.input.controller

import com.giacom.simpletask.adapters.input.controller.mapper.TaskStepDefinitionMapper
import com.giacom.simpletask.adapters.input.controller.request.TaskStepDefinitionCreateRequest
import com.giacom.simpletask.adapters.input.controller.response.TaskStepDefinitionResponse
import com.giacom.simpletask.application.ports.input.DeleteTaskStepDefinitionInput
import com.giacom.simpletask.application.ports.input.SaveTaskStepDefinitionInput
import com.giacom.simpletask.application.ports.input.FindTaskStepDefinitionInput
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/task-definitions/")
class TaskStepDefinitionController(
    private val saveStepInput: SaveTaskStepDefinitionInput,
    private val findStepInput: FindTaskStepDefinitionInput,
    private val deleteStepInput: DeleteTaskStepDefinitionInput,
    private val mapper: TaskStepDefinitionMapper
) {

    @PostMapping("/{taskDefinitionId}/steps")
    fun create(@Valid @RequestBody request: TaskStepDefinitionCreateRequest, @PathVariable taskDefinitionId: Long):
            ResponseEntity<TaskStepDefinitionResponse> {
        val taskStepDefinition = saveStepInput.create(taskDefinitionId, mapper.toDomain(request))
        return ResponseEntity.ok(mapper.toResponse(taskStepDefinition))
    }

    @GetMapping("/{taskDefinitionId}/steps")
    fun findAllSteps(@PathVariable taskDefinitionId: Long): ResponseEntity<List<TaskStepDefinitionResponse>> {
        val taskStepDefinitions = findStepInput.findAllByTaskDefinitionId(taskDefinitionId)
        return ResponseEntity.ok(mapper.toResponseList(taskStepDefinitions))
    }

    @GetMapping("/steps/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<TaskStepDefinitionResponse> {
        val taskStepDefinition = findStepInput.findById(id)
        return ResponseEntity.ok(mapper.toResponse(taskStepDefinition))
    }

    @PutMapping("/steps/{id}")
    fun updateStep(@PathVariable id: Long, @Valid @RequestBody request: TaskStepDefinitionCreateRequest):
            ResponseEntity<TaskStepDefinitionResponse> {
        val taskStepDefinition = saveStepInput.update(id, mapper.toDomain(request))
        return ResponseEntity.ok(mapper.toResponse(taskStepDefinition))
    }

    @DeleteMapping("/steps/{id}")
    fun deleteStep(@PathVariable id: Long): ResponseEntity<Unit> {
        deleteStepInput.deleteById(id)
        return ResponseEntity.noContent().build()
    }

}
