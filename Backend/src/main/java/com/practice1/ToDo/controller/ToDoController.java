package com.practice1.ToDo.controller;

import com.practice1.ToDo.model.ToDo;
import com.practice1.ToDo.repository.ToDoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/task")
public class ToDoController {
    private final ToDoRepository toDoRepository;

    public ToDoController(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    @GetMapping
    public ResponseEntity<List<ToDo>> getAllTasks() {
        List<ToDo> taskList = (List<ToDo>) toDoRepository.findAll();
        return ResponseEntity.ok(taskList);
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<ToDo> getTaskById(@PathVariable Long taskId) {
        Optional<ToDo> task = toDoRepository.findByTaskId(taskId);
        if (task.isPresent()) {
            return ResponseEntity.ok(task.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ToDo> createTask(@RequestBody ToDo newTask) {
    // Realiza las validaciones necesarias
    if (newTask.getName_task() == null || newTask.getName_task().isEmpty()) {
        return ResponseEntity.badRequest().build();
    }

    // Guarda la tarea en la base de datos
    ToDo savedTask = toDoRepository.save(newTask);

    return ResponseEntity.ok(savedTask);
}


    @DeleteMapping("/{taskId}")
    public ResponseEntity<String> deleteTask(@PathVariable Long taskId) {
        // Elimina la tarea de la base de datos si existe
        if (toDoRepository.existsById(taskId)) {
            toDoRepository.deleteById(taskId);
            return ResponseEntity.ok("Tarea borrada con ID: " + taskId);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
