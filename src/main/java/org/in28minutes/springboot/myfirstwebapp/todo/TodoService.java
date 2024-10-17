package org.in28minutes.springboot.myfirstwebapp.todo;

import jakarta.validation.Valid;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();

    public static int todosCount = 0;
    static {
        todos.add(new Todo(++todosCount,"Tanishk","Get AWS certified 1",
                            LocalDate.now().plusYears(1),false));
        todos.add(new Todo(++todosCount,"Tanishk","Learn Devops 1",
                            LocalDate.now().plusYears(2),false));
        todos.add(new Todo(++todosCount,"Tanishk","Learn spring 1",
                            LocalDate.now().plusYears(3),false));
    }


    public List<Todo> findByUsername(String username){
        Predicate<? super Todo> predicate =
                todo -> todo.getUsername().equalsIgnoreCase(username);
        return todos.stream().filter(predicate).toList();
    }

    public void addTodo(String username, String description, LocalDate targetDate, boolean done){
        Todo todo = new Todo(++todosCount,username,description,targetDate,done);
        // we are adding this todo in the todo list
        todos.add(todo);
    }


    public void deleteById(int id){
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        todos.removeIf(predicate);
    }

    public void updateTodo(@Valid Todo todo){
        deleteById(todo.getId());
        todos.add(todo);
    }

    public Todo findById(int id) {
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        Todo todo = todos.stream().filter(predicate).findFirst().get();
        return todo;
    }
}
