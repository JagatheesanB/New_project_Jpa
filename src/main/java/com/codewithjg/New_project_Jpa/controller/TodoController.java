package com.codewithjg.New_project_Jpa.controller;

import com.codewithjg.New_project_Jpa.model.Todo;
import com.codewithjg.New_project_Jpa.request.TodoRequest;
import com.codewithjg.New_project_Jpa.service.AppUserService;
import com.codewithjg.New_project_Jpa.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/all/{userId}")
    public List<Todo> getAllTodo(@PathVariable int userId){
        return todoService.findAll(userId);
    }

    @PostMapping
    public List<Todo> createTodo(@RequestBody TodoRequest todo){
        return todoService.insert(todo) ;
    }

    @PutMapping
    public List<Todo> updateTodo(@RequestBody TodoRequest todo){
        return todoService.update(todo);
    }

    @DeleteMapping("/{id}")
    public List<Todo> deleteTodo(@PathVariable Integer id){
        return todoService.deleteById(id);
    }


}
