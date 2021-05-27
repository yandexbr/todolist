package com.example.ToDoListSpringBootExample.repository;

import com.example.ToDoListSpringBootExample.entity.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TasksRepository extends JpaRepository<Tasks, Integer> {
}
