package com.example.todo_app.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todo_app.entities.Todo;

public interface TodoRepos extends JpaRepository<Todo,Integer>{
    
}
