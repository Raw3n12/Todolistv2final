package com.example.todolistv2final.Repo;

import com.example.todolistv2final.model.Todos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepo extends CrudRepository<Todos, Long> {

}
