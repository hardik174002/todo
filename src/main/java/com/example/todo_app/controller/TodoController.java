package com.example.todo_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo_app.dto.TodoRequest;
import com.example.todo_app.entities.Todo;
import com.example.todo_app.service.CustomHealthCheck;
import com.example.todo_app.service.TodoService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "*")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService){
        this.todoService = todoService;
    }

    @PostMapping("todos")
    public ResponseEntity<?> addTodo(@RequestBody TodoRequest todoRequest){
        return ResponseEntity.ofNullable(todoService.saveTodo(todoRequest));
    }
    @GetMapping("todos")
    public ResponseEntity<List<Todo>> getMethodName() {
        return ResponseEntity.status(HttpStatus.OK).body(todoService.getAllTodos());
    }
    @GetMapping("home")
    public String homePage() {
        return new String("Home One");
    }
    @PostMapping("unhealthy")
    public String makeUnhealthy() {
        CustomHealthCheck.setForceUnhealthy(true);
        return "App marked as UNHEALTHY";
    }

    @PostMapping("healthy")
    public String makeHealthy() {
        CustomHealthCheck.setForceUnhealthy(false);
        return "App marked as HEALTHY";
    }
    
}
