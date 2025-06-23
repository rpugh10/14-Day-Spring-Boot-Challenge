package com.example.pratice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
