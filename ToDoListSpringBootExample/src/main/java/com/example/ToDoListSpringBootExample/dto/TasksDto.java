package com.example.ToDoListSpringBootExample.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TasksDto {
    private int id;
    private String name;
    private String description;
}
