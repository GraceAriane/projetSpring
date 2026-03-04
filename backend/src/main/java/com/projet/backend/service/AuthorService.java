package com.projet.backend.service;

import com.projet.backend.model.Author;
import com.projet.backend.model.Role;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    public Author saveAuthor(Author author);
//    public Optional<Object> getAuthorId(Long id);
    public Optional<Author> getAuthorId(Long id);
    public void deleteAuthorById(Long id);
    public Author updateAuthor(Long id, Author newAuthor);
    public List<Author> getAllAuthor();



}
