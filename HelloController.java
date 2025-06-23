package com.example.pratice;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    @GetMapping(path = "/hello")
    public String hello(){
        return "Hello Ryan";
    }

    @GetMapping(path = "square")
    public int squareNum(@RequestParam(name = "num") int num) //RequestParam is where Spring handles the Query part
    //Look in the URL query string for a parameter named num, and assign its value to the method variable num (as an int)
    {
        return num * num;
    }

    @GetMapping(path = "greet/{name}")//{name} tells Spring that this endpoint expects a variable in the URL path
    public String name(@PathVariable String name)
    {
        return "Hello " + name;
    }
}
