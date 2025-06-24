package com.example.pratice.services;

import com.example.pratice.controller.HelloController;
import com.example.pratice.model.Book;
import com.example.pratice.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class SquareService {
    private final BookRepository repository;

    public SquareService(BookRepository repository)
    {
        this.repository = repository;
    }

    public int squareNum(int num)
    {
        return num * num;
    }

    public Book saveBook(Book book){
        return repository.save(book);
    }

    public List<Book> seeAllBooks(){
        return repository.findAll();
    }


}
