package com.app.todoapp.controller;

import com.app.todoapp.models.Task;
import com.app.todoapp.services.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
//@RequestMapping("/tasks")
public class TaskController {
    private final TodoService todoService;

    public TaskController(TodoService todoService) {
        this.todoService = todoService;
    }


    @GetMapping
    public String getTasks(Model model) {
        List<Task> tasks = todoService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "tasks";
        //as we are using thymleaf it is going to look for task.hmtl in resources
    }

    @PostMapping
    public String createTasks(@RequestParam String title) {
        todoService.createTask(title);
        return "redirect:/";
        //as we are using thymleaf it is going to look for task.hmtl in resources
    }


    @GetMapping("/{id}/delete")
    public String deleteTask(@PathVariable Long id) {
        todoService.deleteTask(id);
        return "redirect:/";
    }

    @GetMapping("/{id}/toggle")
    public String toggleTask(@PathVariable Long id) {
        todoService.toggleTask(id);
        return "redirect:/";
    }


}
