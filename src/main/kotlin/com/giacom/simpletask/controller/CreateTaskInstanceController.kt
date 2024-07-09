package com.giacom.simpletask.controller

import com.giacom.simpletask.service.TaskInstanceService
import jakarta.validation.Valid
import jakarta.validation.constraints.NotBlank
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/task-instance/")
class CreateTaskInstanceController(
    private val taskInstanceService: TaskInstanceService
) {

    @PostMapping
    fun create(@Valid @NotBlank taskName: String): ResponseEntity<Long> {
        val id = taskInstanceService.create(taskName)
        return ResponseEntity.ok(id)
    }

}
