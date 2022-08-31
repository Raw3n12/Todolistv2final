package com.example.todolistv2final.Controller;


import com.example.todolistv2final.Repo.TodoRepo;
import com.example.todolistv2final.Service.ServiceTodo;
import com.example.todolistv2final.model.Todos;
import com.sun.istack.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

@Controller
public class TaskController {
    private final ServiceTodo serviceTodo;

    public TaskController (ServiceTodo serviceTodo){
        this.serviceTodo = serviceTodo;
    }
    private TodoRepo todoRepo;


    @GetMapping("/create")
    public String createentry(Model model){
    serviceTodo.createdatabase();
    return "/create";
    }

    @GetMapping("/create/get")
    public String getTodolist (Model model){
    List<Todos>database = List.copyOf(serviceTodo.getTodosList());
    model.addAttribute("todolist",database);
    return "/get";
    }

    @PostMapping("/create/setNew")
    public String setnew(Todos todos){
        serviceTodo.saveTodos(todos);
        return "redirect:/create/get";
    }
    @GetMapping("/crete/setNew")
    public String getnew(Todos todos){
        serviceTodo.saveTodos(todos);
        return "SetNew";
    }

    @GetMapping("/create/delTodo")
    public String delTodo(@RequestParam Long id) {
        serviceTodo.deleteTodos(id);
        return "redurect:/create/get";
    }
    @PutMapping
    public Todos update(@Validated @NotNull @RequestBody Todos todos){
        return todoRepo.save(todos);
    }
    @DeleteMapping
    public void delete(@PathVariable Long id){
        todoRepo.deleteById(id);
    }
}
