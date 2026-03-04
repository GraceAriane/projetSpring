package com.projet.backend.service;

import com.projet.backend.model.Book;
import com.projet.backend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface BookService {
    public Book saveBook(Book book);
    public Optional<Book> getBookById(Long id);
    public void deleteBookById(Long id);
    public Book updateBook(Long id, Book newBook);
    public List<Book> getAllBook();

}
