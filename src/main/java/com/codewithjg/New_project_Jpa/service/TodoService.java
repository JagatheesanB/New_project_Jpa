package com.codewithjg.New_project_Jpa.service;

import com.codewithjg.New_project_Jpa.model.AppUser;
import com.codewithjg.New_project_Jpa.model.Todo;
import com.codewithjg.New_project_Jpa.repository.AppUserRepository;
import com.codewithjg.New_project_Jpa.repository.TodoRepository;
import com.codewithjg.New_project_Jpa.request.TodoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private AppUserRepository appUserRepository;

    public List<Todo> findAll(int userId) {
        return todoRepository.findAll()
                .stream()
                .filter(todo -> todo.getAppUser().getId() == userId)
                .collect(Collectors.toList());
    }


    public List<Todo> insert(TodoRequest todo) {
        Todo originalTodo = new Todo();
        originalTodo.setTodo(todo.getTodo());
        AppUser user = appUserRepository.findById(todo.getUserid()).get();
        originalTodo.setAppUser(user);
        todoRepository.save(originalTodo);
        return findAll(todo.getUserid());
    }

    public List<Todo> update(TodoRequest todo) {
        Todo originalTodo = new Todo();
        originalTodo.setId(todo.getId());
        originalTodo.setTodo(todo.getTodo());
        AppUser user = appUserRepository.findById(todo.getUserid()).get();
        originalTodo.setAppUser(user);
        todoRepository.save(originalTodo);
        return findAll(todo.getUserid());
    }

    public List<Todo> deleteById(Integer id) {
        int userId = todoRepository.findById(id).get().getAppUser().getId();
        todoRepository.deleteById(id);
        return findAll(userId);
    }
}
