package com.example.ToDoListSpringBootExample.service;

import com.example.ToDoListSpringBootExample.dto.TasksDto;
import com.example.ToDoListSpringBootExample.entity.Tasks;
import com.example.ToDoListSpringBootExample.repository.TasksRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class DefaultTasksService implements TasksService{

    private TasksConverter tasksConverter;
    @Autowired
    private TasksRepository tasksRepository;

    public DefaultTasksService(TasksConverter tasksConverter) {
        this.tasksConverter = tasksConverter;
    }

    @Override
    public TasksDto saveTask(TasksDto tasksDto){
        Tasks savedTasks = tasksRepository.save(tasksConverter.fromTasksDtoToTask(tasksDto));
        return tasksConverter.fromTaskToTasksDto(savedTasks);
    }

    @Override
    public TasksDto putTask(TasksDto tasksDto){
        Tasks putTask = tasksRepository.save(tasksConverter.fromTasksDtoToTask(tasksDto));
        return tasksConverter.fromTaskToTasksDto(putTask);
    }

    @Override
    public void deleteTask(Integer id){
        tasksRepository.deleteById(id);
    }

    @Override
    public void deleteAllTasks(){
        tasksRepository.deleteAll();
    }

    @Override
    public TasksDto findById(Integer taskId) {
        Optional<Tasks> tasksOptional = tasksRepository.findById(taskId);
        if (tasksOptional.isPresent()){
            Tasks tasks = tasksOptional.get();
            return tasksConverter.fromTaskToTasksDto(tasks);
        }
        return null;
    }

    private TasksDto findByIdReturnNull() {
        return null;
    }

    @Override
    public List<TasksDto> findAll(){
        return tasksRepository.findAll()
                .stream()
                .map(tasksConverter::fromTaskToTasksDto)
                .collect(Collectors.toList());
    }
}
