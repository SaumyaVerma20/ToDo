package com.app.todoapp.repository;

import com.app.todoapp.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

//in the jpa repository we need to define the entity i.e task and what is the type of id which is long here
public interface TaskRepository extends JpaRepository<Task, Long> {

}
