package com.projet.backend.controller;

import com.projet.backend.model.Author;
import com.projet.backend.service.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private final AuthorService service;;

    public AuthorController(AuthorService service) {
        this.service = service;
    }

    @GetMapping
    public List<Author> getAllAuthor() {
        return service.getAllAuthor();
    }

    @GetMapping("/{id}")
    public Optional<Author> geAuthorId(@PathVariable Long id) {
        return service.getAuthorId(id);
    }

    @PostMapping
    public Author create(@RequestBody Author author) {
        return service.saveAuthor(author);
    }

    @PutMapping("/{id}")
    public Author update(@PathVariable Long id, @RequestBody Author author) {
        author.setId(id);
        return service.saveAuthor(author);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteAuthorById(id);
    }
}