package com.example.ToDoListSpringBootExample.service;

import com.example.ToDoListSpringBootExample.dto.TasksDto;

import java.util.List;

public interface TasksService {
    TasksDto saveTask(TasksDto tasksDto);
    TasksDto putTask(TasksDto tasksDto);
    void deleteTask(Integer taskId);
    void deleteAllTasks();
    TasksDto findById(Integer taskId);
    List<TasksDto> findAll();
}
