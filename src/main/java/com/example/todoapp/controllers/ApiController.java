package com.example.todoapp.controllers;

import com.example.todoapp.models.Task;
import com.example.todoapp.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class ApiController {

    @Autowired
    TaskRepository taskrepo;

    @GetMapping(value = "/todos")
    public List<Task> tasklist(){
        return taskrepo.findAll();
    }

    @GetMapping(value = "todo/{id}")
    public Optional<Task> retrieve(@PathVariable Long id){
        return taskrepo.findById(id);
    }

    @PostMapping(value = "/todo")
    public ResponseEntity<Task> newTask(@RequestBody Task task){
        Task result = taskrepo.save(task);
        return new ResponseEntity<Task> (result, HttpStatus.CREATED);
    }

    @PutMapping(value = "/todo/{id}")
    public Task update(@PathVariable Long id, @RequestBody Task task){
        task.setId(id);
        return taskrepo.save(task);
    }

    @DeleteMapping(value = "/todo/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        taskrepo.deleteById(id);
    }
}
