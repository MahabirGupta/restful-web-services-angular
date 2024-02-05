package com.rest.webservices.restfulwebservices.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TodoResource {

    @Autowired
    private TodoHardCodedService todoService;

//    create a GET method to get the List of Todos for a Specific user

    @GetMapping("/users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable String username) {
        return todoService.findAll();
    }

    //    create a delete method to delete by id
//    Delete /users/{username}/todos/{id}
    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id) {
        Todo todo = todoService.deleteById(id);
//           check whether it is successfully deleted
        if (todo != null) {
            return ResponseEntity.noContent().build(); // ResponseEntity uses Builder Pattern
        }
        return ResponseEntity.notFound().build();
    }
}
