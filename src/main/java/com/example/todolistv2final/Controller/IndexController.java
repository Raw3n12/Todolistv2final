package com.example.todolistv2final.Controller;


import com.example.todolistv2final.Service.ServiceTodo;
import com.example.todolistv2final.model.Todos;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class IndexController {

    public final ServiceTodo serviceTodo;

    public IndexController(ServiceTodo serviceTodo) {
        this.serviceTodo = serviceTodo;
    }

    @GetMapping("/index")
    public String getindex(Model model){
        List<Todos> todosList = List.copyOf(serviceTodo.getTodosList());
        model.addAttribute("todolist",todosList);
        return "/index";
    }

    @GetMapping("/createTempList")
    public String createDatabase (Model model){
        serviceTodo.createdatabase();

        return "redirect:/index";
    }

    @GetMapping("/index/addnew")
    public String getnew(Model model){
        return "/addnew";
    }


    @PostMapping("/index/addNew")
    public String addnew(Todos todos){
        serviceTodo.saveTodos(todos);
        return "redirect:/index";
    }
    @GetMapping("/index/delTodo")
    public String delTodo(@RequestParam Long id) {
    serviceTodo.deleteTodos(id);
    return "redurect:/index";
    }



}
