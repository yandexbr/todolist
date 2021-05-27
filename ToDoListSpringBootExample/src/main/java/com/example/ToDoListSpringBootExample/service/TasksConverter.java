package com.example.ToDoListSpringBootExample.service;

import com.example.ToDoListSpringBootExample.dto.TasksDto;
import com.example.ToDoListSpringBootExample.entity.Tasks;
import org.springframework.stereotype.Component;

@Component
public class TasksConverter {

    public Tasks fromTasksDtoToTask(TasksDto tasksDto){
        Tasks tasks = new Tasks();
        tasks.setId(tasksDto.getId());
        tasks.setName(tasksDto.getName());
        tasks.setDescription(tasksDto.getDescription());
        return tasks;
    }

    public TasksDto fromTaskToTasksDto(Tasks tasks){
        return TasksDto.builder()
                .id(tasks.getId())
                .name(tasks.getName())
                .description(tasks.getDescription())
                .build();
    }
}
