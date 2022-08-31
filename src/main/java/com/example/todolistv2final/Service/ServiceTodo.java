package com.example.todolistv2final.Service;

import com.example.todolistv2final.Repo.TodoRepo;
import com.example.todolistv2final.model.Todos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceTodo {

    private List<Todos> todosList = List.of(
            new Todos(1L,"Progmatic todolist", true),
            new Todos(2L,"Projectmunka leadás", false),
            new Todos(3L,"Bevásárlás",true),
            new Todos(4L,"Aramco tender",false)

    );

    private TodoRepo todoRepo;

    @Autowired
    public ServiceTodo(TodoRepo todoRepo) {
        this.todoRepo = todoRepo;
    }
    public void createdatabase(){
        todoRepo.saveAll(todosList);
    }
    public List<Todos> getTodosList(){
        return (List<Todos>)todoRepo.findAll();
    }
    public void saveTodos (Todos todos){
        todoRepo.save(todos);
    }
    public void deleteTodos (Long id){
        todoRepo.deleteById(id);
    }
    public Optional<Todos> getTodos (Long id){
        return todoRepo.findById(id);
    }

}
