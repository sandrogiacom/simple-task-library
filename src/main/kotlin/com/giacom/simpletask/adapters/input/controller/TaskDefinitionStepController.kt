package com.giacom.simpletask.adapters.input.controller

import com.giacom.simpletask.adapters.input.controller.mapper.TaskDefinitionStepMapper
import com.giacom.simpletask.adapters.input.controller.request.TaskDefinitionStepCreateRequest
import com.giacom.simpletask.adapters.input.controller.response.TaskDefinitionStepResponse
import com.giacom.simpletask.application.ports.input.DeleteTaskDefinitionStepInput
import com.giacom.simpletask.application.ports.input.SaveTaskDefinitionStepInput
import com.giacom.simpletask.application.ports.input.FindTaskDefinitionStepInput
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/task-definitions/")
class TaskDefinitionStepController(
    private val saveStepInput: SaveTaskDefinitionStepInput,
    private val findStepInput: FindTaskDefinitionStepInput,
    private val deleteStepInput: DeleteTaskDefinitionStepInput,
    private val mapper: TaskDefinitionStepMapper
) {

    @PostMapping("/{taskDefinitionId}/steps")
    fun create(@Valid @RequestBody request: TaskDefinitionStepCreateRequest, @PathVariable taskDefinitionId: Long):
            ResponseEntity<TaskDefinitionStepResponse> {
        val taskDefinitionStep = saveStepInput.create(taskDefinitionId, mapper.toDomain(request))
        return ResponseEntity.ok(mapper.toResponse(taskDefinitionStep))
    }

    @GetMapping("/{taskDefinitionId}/steps")
    fun findAllSteps(@PathVariable taskDefinitionId: Long): ResponseEntity<List<TaskDefinitionStepResponse>> {
        val definitionStepList = findStepInput.findAllByTaskDefinitionId(taskDefinitionId)
        return ResponseEntity.ok(mapper.toResponseList(definitionStepList))
    }

    @GetMapping("/steps/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<TaskDefinitionStepResponse> {
        val taskDefinitionStep = findStepInput.findById(id)
        return ResponseEntity.ok(mapper.toResponse(taskDefinitionStep))
    }

    @PutMapping("/steps/{id}")
    fun updateStep(@PathVariable id: Long, @Valid @RequestBody request: TaskDefinitionStepCreateRequest):
            ResponseEntity<TaskDefinitionStepResponse> {
        val taskDefinitionStep = saveStepInput.update(id, mapper.toDomain(request))
        return ResponseEntity.ok(mapper.toResponse(taskDefinitionStep))
    }

    @DeleteMapping("/steps/{id}")
    fun deleteStep(@PathVariable id: Long): ResponseEntity<Unit> {
        deleteStepInput.deleteById(id)
        return ResponseEntity.noContent().build()
    }

}
