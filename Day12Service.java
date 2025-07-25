package com.example.pratice.services;

import com.example.pratice.controller.HelloController;
import com.example.pratice.model.Book;
import com.example.pratice.repository.BookRepository;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
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

    public void deleteBook(Long id)
    {
        repository.deleteById(id);
    }

    public boolean exists(Long id)
    {
        return repository.existsById(id);
    }

    public void updateBook(Book book, Long id)
    {
        Book currentBook = repository.findById(id).orElseThrow(() -> new RuntimeException("Book not found")); //before -> is the parameters and after the -> is the body(like an if statement and the body is the code you run).
        currentBook.setTitle(book.getTitle());
        currentBook.setAuthor(book.getAuthor());
        repository.save(currentBook);
    }

    public List<Book> findByTitle(String title)
    {
        return repository.findByTitleContainingIgnoreCase(title);
    }


}
