package com.example.todolistv2final.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Todos {

    @Id
    @GeneratedValue
    private Long id;

    private String content;
    private boolean status;

    public Todos() {
    }




    public Todos(String content, boolean status) {
        this.content = content;
        this.status = status;
    }
    public Todos(Long id,String content, boolean status) {
        this(content,status);
        this.id = id;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Todos{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", status=" + status +
                '}';
    }
}
