package com.example.pratice.services;

import com.example.pratice.controller.HelloController;
import com.example.pratice.dto.BookDTO;
import com.example.pratice.model.Book;
import com.example.pratice.repository.BookRepository;
import org.apache.coyote.Response;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SquareService {
    @Autowired
    private final BookRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public SquareService(BookRepository repository)
    {
        this.repository = repository;
    }

    public BookDTO saveBook(BookDTO bookDTO){
        Book book = modelMapper.map(bookDTO, Book.class);
        Book saved = repository.save(book);
        return modelMapper.map(saved, BookDTO.class);
    }

    public void deleteBook(Long id)
    {
        repository.deleteById(id);
    }

    public boolean exists(Long id)
    {
        return repository.existsById(id);
    }

    public void updateBook(BookDTO bookDTO, Long id)
    {
        Book currentBook = repository.findById(id).orElseThrow(() -> new RuntimeException("Book not found")); //before -> is the parameters and after the -> is the body(like an if statement and the body is the code you run).
        modelMapper.map(bookDTO, currentBook);
        repository.save(currentBook);
    }

    public List<BookDTO> searchBooks(String title, String author)
    {
        List<Book> books;
        if(title != null && author != null)
        {
            books = repository.findByTitleContainingIgnoreCaseAndAuthorContainingIgnoreCase(title,author);
        }
        else if(title != null)
        {
            books = repository.findByTitleContainingIgnoreCase(title);
        }
        else if(author != null){
            books = repository.findByAuthorContainingIgnoreCase(author);
        }
        else{
            books = repository.findAll();
        }

        return books.stream()
                .map(book -> modelMapper.map(book, BookDTO.class))
                .collect(Collectors.toList());
    }

    public BookDTO convertEntityToDTO(Book book)
    {
        BookDTO bookDTO = new BookDTO();
        bookDTO = modelMapper.map(book, BookDTO.class);
        return bookDTO;
    }

    public List<BookDTO> getAllBookDTOs(){
        return repository.findAll()
                .stream()// turns the list of Book entities into a stream
                .map(this::convertEntityToDTO)// transforms each Book into a BookDTO using modelMapper
                .collect(Collectors.toList()); //turns the stream back into a List<BookDTO> to return
    }


}
