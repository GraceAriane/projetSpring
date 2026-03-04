package com.projet.backend.controller;

import com.projet.backend.model.Book;
import com.projet.backend.model.User;
import com.projet.backend.service.BookService;
import com.projet.backend.service.BookServiceImpl;
import com.projet.backend.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping
    public List<Book> getAllBook() {
        return service.getAllBook();
    }

    @GetMapping("/{id}")
    public Optional<Book> geAuthorId(@PathVariable Long id) {
        return service.getBookById(id);
    }

    @PostMapping
    public Book create(@RequestBody Book book) {
        return service.saveBook(book);
    }

    @PutMapping("/{id}")
    public Book update(@PathVariable Long id, @RequestBody Book book) {
        book.setId(id);
        return service.saveBook(book);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteBookById(id);
    }
}
