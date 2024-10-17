package org.in28minutes.springboot.myfirstwebapp.todo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// JPA Repository  <what you have to manage , What is the type of the ID field>
public interface TodoRepository extends JpaRepository<Todo,Integer> {
    public List<Todo> findByUsername(String username);
}
