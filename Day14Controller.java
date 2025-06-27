package com.example.pratice.controller;

import com.example.pratice.dto.BookDTO;
import com.example.pratice.model.Book;
import com.example.pratice.services.LoggerComponent;
import com.example.pratice.services.SquareService;
import org.springframework.http.HttpStatus;
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


    @GetMapping(path = "greet/{name}")//{name} tells Spring that this endpoint expects a variable in the URL path
    public String name(@PathVariable String name)//Path Variable so the url changes based on the content received
    {
        return "Hello " + name;
    }

    @PostMapping(path = "/books")
    public BookDTO createBook(@RequestBody BookDTO bookDTO)
    {
        return service.saveBook(bookDTO);
    }

    @GetMapping(path = "/books")
    public List<BookDTO> getAllBooks(){
        return service.getAllBookDTOs();
    }

    @DeleteMapping(path = "/books/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id)
    {
       if(!service.exists(id)){
           return ResponseEntity.notFound().build();
       }
       service.deleteBook(id);
       return ResponseEntity.ok("Book deleted successfully");
    }

    @PutMapping(path = "/books/{id}")
    public ResponseEntity<?> updateBook(@PathVariable Long id, @RequestBody BookDTO bookDTO) //This method will return a ResponseEntity with some type, but I’m not committing to what type exactly(?)
    {
        try{
            service.updateBook(bookDTO, id);
            return ResponseEntity.ok("Book updated successfully");
        }catch(RuntimeException e)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage()); //ResponseEntity lets you control the HTTP status code
        }
    }

   @GetMapping(path = "/books/search")
   public List<BookDTO> searchBook(@RequestParam(required = false) String title, @RequestParam(required = false) String author)//required = false makes this parameter not required when searching
   {
       return service.searchBooks(title, author);
   }



}
