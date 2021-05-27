package com.example.ToDoListSpringBootExample.controller;

import com.example.ToDoListSpringBootExample.dto.TasksDto;
import com.example.ToDoListSpringBootExample.service.TasksService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("tasks")
@AllArgsConstructor
public class TasksController {
    private final TasksService tasksService;

    @PostMapping("/save")
    public TasksDto saveTasks(@RequestBody TasksDto tasksDto){
        return tasksService.saveTask(tasksDto);
    }

    @PutMapping("/put")
    public TasksDto putTask(@RequestBody TasksDto tasksDto){
        return tasksService.saveTask(tasksDto);
    }

    @GetMapping("/find/{id}")
    public TasksDto findByIdTasks(@PathVariable Integer id){
        return tasksService.findById(id);
    }

    @GetMapping("/findAll")
    public List<TasksDto> findAllTasks(){
        return tasksService.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTasks(@PathVariable Integer id){
        tasksService.deleteTask(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteAllTasks(){
        tasksService.deleteAllTasks();
        return ResponseEntity.ok().build();
    }
}
