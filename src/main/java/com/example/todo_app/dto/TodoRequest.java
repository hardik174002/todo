package com.example.todo_app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TodoRequest {
    
    private String title;

    @JsonProperty("is_completed")
    private boolean isCompleted;
}
