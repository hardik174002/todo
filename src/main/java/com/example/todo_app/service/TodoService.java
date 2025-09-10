package com.example.todo_app.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.example.todo_app.dto.TodoRequest;
import com.example.todo_app.entities.Todo;
import com.example.todo_app.repos.TodoRepos;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import jakarta.websocket.server.ServerEndpoint;

@Service
public class TodoService {
    
    private TodoRepos todoRepos;

    public TodoService(TodoRepos todoRepos){
        this.todoRepos = todoRepos;
    }

    public TodoRequest saveTodo(TodoRequest todoRequest){
        Todo todo = new Todo();
        BeanUtils.copyProperties(todoRequest, todo);
        todoRepos.save(todo);
        return todoRequest;
    }

    public List<Todo> getAllTodos(){
        return todoRepos.findAll();
    }
}
