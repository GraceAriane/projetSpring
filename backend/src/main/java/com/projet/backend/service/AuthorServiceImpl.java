package com.projet.backend.service;

import com.projet.backend.model.Author;
import com.projet.backend.repository.AuthorRepository;
import com.projet.backend.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService{

    private final AuthorRepository repository;

    public AuthorServiceImpl(AuthorRepository repository) {
        this.repository = repository;
    }

    /** 
     * @param author
     * @return Author
     */
    @Override
    public Author saveAuthor(Author author) {
        return repository.save(author);
    }

    /** 
     * @param id
     * @return Optional<Author>
     */
    @Override
    public Optional<Author> getAuthorId(Long id) {
        return repository.findById(id);
    }

    /** 
     * @param id
     */
    @Override
    public void deleteAuthorById(Long id) {
        repository.deleteById(id);
    }

    /** 
     * @param id
     * @param newAuthor
     * @return Author
     */
    @Override
    public Author updateAuthor(Long id, Author newAuthor) {
        return repository.findById(id)
                .map(author -> {
                    author.setName(newAuthor.getName());
                    return repository.save(author);
                }).orElse(null);
    }

    /** 
     * @return List<Author>
     */
    @Override
    public List<Author> getAllAuthor() {
        return repository.findAll();
    }
}
