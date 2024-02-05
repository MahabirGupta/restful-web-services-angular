package com.rest.webservices.restfulwebservices.todo;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@Component //Since this is a business use the annotation @Service
@Service

public class TodoHardCodedService {

    //    Create a static list of todos
    private static List<Todo> todos = new ArrayList();
    //    create an id for the counter
    private static int idCounter = 0;

    //    initialize the data
    static {
        todos.add(new Todo(idCounter++, "Mahabir", "Learn JavaScript", new Date(), true));
        todos.add(new Todo(idCounter++, "Mahabir", "Learn Angular", new Date(), false));
        todos.add(new Todo(idCounter++, "Mahabir", "Learn Java", new Date(), false));
        todos.add(new Todo(idCounter++, "Mahabir", "Learn Python", new Date(), false));
        todos.add(new Todo(idCounter++, "Mahabir", "Learn AWS", new Date(), true));

    }

//    create a method to retrive all the todos
    public List<Todo> findAll(){
        return todos;
    }

//    create method to delete by id
    public Todo deleteById(long id) {
        Todo todo = findById(id);
//        Check to see whether the todo exist
        if (todo == null) return null;
//        if todo exist
        if (todos.remove(todo)) {
            return todo;
        }
        return null;
    }
//    create method to findById
    public Todo findById(long id) {
//        reiterate through all the Todo List
        for(Todo todo:todos){
            if (todo.getId() == id){
               return todo;
            }

        }
        return null;
    }
}
