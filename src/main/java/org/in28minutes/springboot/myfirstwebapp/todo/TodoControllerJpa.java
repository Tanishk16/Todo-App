package org.in28minutes.springboot.myfirstwebapp.todo;

import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;


@Controller
@SessionAttributes("name")
public class TodoControllerJpa {

    private TodoRepository todoRepository;

    public TodoControllerJpa( TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap modelMap){
        String username = getLoggedInUsername(modelMap);
        List<Todo> todos = todoRepository.findByUsername(username);
        modelMap.addAttribute("todos",todos);
        return "listTodos";
    }

    @RequestMapping(value="add-todo", method = RequestMethod.GET)
    public String showNewTodoPage(ModelMap modelMap){
        String username = (String) modelMap.get("name");
        Todo todo = new Todo(0,username,"",LocalDate.now().plusYears(1),false);
        modelMap.put("todo",todo);
        return "todo";
    }

    @RequestMapping(value="add-todo", method = RequestMethod.POST)
        public String addNewTodo(ModelMap modelMap, @Valid Todo todo, BindingResult result){
        if(result.hasErrors()){
            return "todo";
        }
        String username = getLoggedInUsername(modelMap);
        todo.setUsername(username);
        todoRepository.save(todo);
//        todoService.addTodo(username,todo.getDescription(),
//                            todo.getTargetDate(),todo.getDone());
        return "redirect:list-todos";
    }

    @RequestMapping("delete-todo")
    public String deleteTodo(@RequestParam int id){
        // Delete
        todoRepository.deleteById(id);
        return "redirect:list-todos";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam int id, ModelMap modelMap){
        Todo todo = todoRepository.findById(id).get();
        modelMap.addAttribute("todo",todo);
        return "todo";      // This shows our controller goes to the todo jsp fie
    }

    @RequestMapping(value="update-todo", method = RequestMethod.POST)
    public String updateTodo(ModelMap modelMap, @Valid Todo todo, BindingResult result){
        if(result.hasErrors()){
            return "todo";
        }
//        String username = (String) modelMap.get("name");
        String username = getLoggedInUsername(modelMap);
        todo.setUsername(username);
        todoRepository.save(todo);
//        todoService.updateTodo(todo);
        return "redirect:list-todos";
    }

    private String getLoggedInUsername(ModelMap modelMap){
         Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
         return authentication.getName();
    }

}
