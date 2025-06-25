package com.example.pratice.controller;

import com.example.pratice.model.Book;
import com.example.pratice.services.LoggerComponent;
import com.example.pratice.services.SquareService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloController {
    private final SquareService service;
    private final LoggerComponent logger;

    public HelloController(SquareService service, LoggerComponent logger)
    {
        this.service = service;
        this.logger = logger;
    }

    @GetMapping(path = "/hello")
    public String hello(){
        logger.log("Hello I'm Ryan");
        return "Hello Ryan";
    }

    @GetMapping(path = "/square")//The logic is in the service class Controller is calling the service class here
    public int square(@RequestParam int num)
    {
        return service.squareNum(num);
    }

    @GetMapping(path = "greet/{name}")//{name} tells Spring that this endpoint expects a variable in the URL path
    public String name(@PathVariable String name)//Path Variable so the url changes based on the content received
    {
        return "Hello " + name;
    }

    @PostMapping(path = "/books")
    public Book getBook(@RequestBody Book book)
    {
        return service.saveBook(book);
    }

    @GetMapping(path = "/books")
    public List<Book> getAllBooks(){
        return service.seeAllBooks();
    }

    @DeleteMapping(path = "books/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id)
    {
       if(!service.exists(id)){
           return ResponseEntity.notFound().build();
       }
       service.deleteBook(id);
       return ResponseEntity.ok("Book deleted successfully");
    }

}
