package com.projet.backend.service;

import com.projet.backend.model.Author;
import com.projet.backend.repository.AuthorRepository;
import com.projet.backend.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * <h2>Service de gestion des auteurs</h2>
 *
 * <p>
 * Cette classe implémente la logique métier liée à la gestion des auteurs
 * dans le système de gestion de bibliothèque.
 * </p>
 *
 * <p>
 * Elle permet d'effectuer les opérations suivantes :
 * </p>
 * <ul>
 *   <li>Créer un auteur</li>
 *   <li>Rechercher un auteur par son identifiant</li>
 *   <li>Mettre à jour les informations d'un auteur</li>
 *   <li>Supprimer un auteur</li>
 *   <li>Afficher la liste de tous les auteurs</li>
 * </ul>
 *
 * <p>
 * Cette classe utilise le repository {@code AuthorRepository} pour interagir
 * avec la base de données via JPA.
 * </p>
 */
@Service
public class AuthorServiceImpl implements AuthorService{

    /**
     * Repository permettant d'accéder aux données des auteurs
     * dans la base de données.
     */
    private final AuthorRepository repository;

    /**
     * Constructeur permettant l'injection du repository.
     *
     * @param repository repository JPA utilisé pour manipuler les entités Author
     */
    public AuthorServiceImpl(AuthorRepository repository) {
        this.repository = repository;
    }

    /**
     * Enregistre un nouvel auteur dans la base de données.
     *
     * @param author l'auteur à enregistrer
     * @return l'auteur sauvegardé avec son identifiant généré
     */
    @Override
    public Author saveAuthor(Author author) {
        return repository.save(author);
    }

    /**
     * Recherche un auteur à partir de son identifiant.
     *
     * @param id identifiant unique de l'auteur
     * @return un {@link Optional} contenant l'auteur s'il existe
     */
    @Override
    public Optional<Author> getAuthorId(Long id) {
        return repository.findById(id);
    }

    /**
     * Supprime un auteur à partir de son identifiant.
     *
     * <p>
     * Si l'auteur n'existe pas, aucune action n'est effectuée.
     * </p>
     *
     * @param id identifiant de l'auteur à supprimer
     */
    @Override
    public void deleteAuthorById(Long id) {
        repository.deleteById(id);
    }

    /**
     * Met à jour les informations d'un auteur existant.
     *
     * <p>
     * Cette méthode recherche l'auteur dans la base de données.
     * Si l'auteur est trouvé, son nom est mis à jour puis sauvegardé.
     * </p>
     *
     * @param id identifiant de l'auteur à modifier
     * @param newAuthor nouvelles informations de l'auteur
     * @return l'auteur mis à jour ou {@code null} si l'auteur n'existe pas
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
     * Récupère la liste de tous les auteurs enregistrés.
     *
     * @return liste des auteurs présents dans la base de données
     */
    @Override
    public List<Author> getAllAuthor() {
        return repository.findAll();
    }
}
