package com.projet.backend.service;

import com.projet.backend.model.Book;
import com.projet.backend.model.User;
import com.projet.backend.repository.BookRepository;
import com.projet.backend.repository.RoleRepository;
import com.projet.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{
    private final BookRepository repository;

    public BookServiceImpl(BookRepository repository){
        this.repository=repository;
    }

    /** 
     * @param book
     * @return Book
     */
    @Override
    public Book saveBook(Book book) {

        return repository.save(book);
    }

    /** 
     * @param id
     * @return Optional<Book>
     */
    @Override
    public Optional<Book> getBookById(Long id) {
        return repository.findById(id);
    }


    /** 
     * @param id
     */
    @Override
    public void deleteBookById(Long id) {
        repository.deleteById(id);
    }

    /** 
     * @param id
     * @param newBook
     * @return Book
     */
    @Override
    public Book updateBook(Long id, Book newBook) {
        return repository.findById(id)
                .map(book -> {
                    book.setTitle(newBook.getTitle());
                    return repository.save(book);
                }).orElse(null);
    }

    /** 
     * @return List<Book>
     */
    @Override
    public List<Book> getAllBook() {
        return repository.findAll();
    }
}
