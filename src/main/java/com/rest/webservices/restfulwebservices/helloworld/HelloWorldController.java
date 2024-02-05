package com.rest.webservices.restfulwebservices.helloworld;

import com.rest.webservices.restfulwebservices.helloworld.HelloWorldBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//Tell Spring that this is a controller by adding the @RestController annotation
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class HelloWorldController {

//    create a method that will return ''Hello World''

//    create a RequestMapping by adding the @RequestMapping annotation
    @RequestMapping(method = RequestMethod.GET,path = "/hello-world")
    public String helloWorld(){
        return "Hello World";
    }

//    Want to return a "Hello World1" string
    @GetMapping(path = "/hello")
    public String helloWorld1(){
        return "Hello World1";
    }

//    Want to return a HelloWorldBean
    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello Mahabir");
    }

//    using hello-world/path-variable/in28minutes
//    It should return name
    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name){

        return new HelloWorldBean(String.format("Hello World, %s",name));
    }
}
