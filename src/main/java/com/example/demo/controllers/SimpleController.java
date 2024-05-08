package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.HandlerInterceptor;

@RestController
@RequestMapping(value="/greet")
public class SimpleController {
    @GetMapping
    public String greet(){
        System.out.println("recived");
        return "Hello...";
    }
    @RequestMapping(method = RequestMethod.GET, path = "/say")
    public String greetWithId(@RequestParam("identifier") int id){
        System.out.println("Recived by ID ");
        return "Hello "+ id;
    }

    // Path Variable example
    @RequestMapping(method = RequestMethod.GET, path = "/bye/{id}")
    public String greetByeWithID(@PathVariable int id){
        System.out.println("recived for Bye for Id : "+id);
        return "Bye "+id;
    }

    // Suppose we want to return object of ExamResult
    @RequestMapping(method = RequestMethod.GET, path = "/result", produces = "application/xml")
    public ExamResult getResult(){
        System.out.println("Received by result ");
        return new ExamResult(90,90,90);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/result/examine")
    public String examineResult(ExamResult examResult){
        if(examResult.getChemistry()>90 && examResult.getPhysics()>90 && examResult.getMaths()>90)
            return "Good result";

        return "Bad Result";
    }
}
