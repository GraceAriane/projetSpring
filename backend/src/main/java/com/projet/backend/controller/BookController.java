package com.projet.backend.controller;

import com.projet.backend.model.Book;
import com.projet.backend.model.User;
import com.projet.backend.service.BookService;
import com.projet.backend.service.BookServiceImpl;
import com.projet.backend.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


/**
 * <h2>Controlêur de gestion des livres</h2>
 *
 * <p>
 * Ce contrôleur expose les endpoints REST permettant de gérer les livres
 * du système de gestion de bibliothèque.
 * </p>
 *
 * <p>
 * Les opérations disponibles incluent :
 * </p>
 * <ul>
 * <li>Récupération de tous les livres</li>
 * <li>Récupération d’un livre par identifiant</li>
 * <li>Création d’un nouvel livre</li>
 * <li>Mise à jour d’un livre existant</li>
 * <li>Suppression d’un livre</li>
 * </ul>
 *
 * <p>
 * Toutes les requêtes sont accessibles via le chemin de base :
 * <code>/api/books</code>
 * </p>
 *
 * @author
 */
@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService service;

    /**
     * Constructeur du contrôleur des livres.
     *
     * @param service service contenant la logique métier liée aux livres
     */
    public BookController(BookService service) {
        this.service = service;
    }

    /**
     * Récupère la liste complète des livres.
     *
     * @return liste de tous les livres enregistrés dans le système
     */
    @Operation(summary = "Lister tous les livres", description = "Retourne la liste complète des livres enregistrés dans la bibliothèque.")
    @ApiResponse(responseCode = "200", description = "Liste des livres récupérée avec succès")
    @GetMapping
    public List<Book> getAllBook() {
        return service.getAllBook();
    }

    /**
     * Récupère un livre à partir de son identifiant.
     *
     * @param id identifiant unique du livre
     * @return le livre correspondant si trouvé
     */
    @Operation(summary = "Rechercher un livre par ID", description = "Retourne les informations d'un livre spécifique.")
    @ApiResponse(responseCode = "200", description = "livre trouvé")
    @ApiResponse(responseCode = "404", description = "livre non trouvé")
    @GetMapping("/{id}")
    public Optional<Book> getBookById(@PathVariable Long id) {
        return service.getBookById(id);
    }

    /**
     * Crée un nouveau livre dans le système.
     *
     * @param livre objet livre à enregistrer
     * @return livre enregistré
     */
    @Operation(summary = "Créer un livre", description = "Permet d'ajouter un nouveau livre dans la base de données.")
    @ApiResponse(responseCode = "201", description = "livre créé avec succès")
    @PostMapping
    public Book create(@RequestBody Book book) {
        return service.saveBook(book);
    }

    /**
     * Met à jour les informations d'un livre existant.
     *
     * @param id   identifiant du livre à modifier
     * @param loan nouvelles informations du livre
     * @return livre mis à jour
     */
    @Operation(summary = "Mettre à jour un livre", description = "Met à jour les informations d'un livre existant.")
    @ApiResponse(responseCode = "200", description = "livre mis à jour avec succès")
    @PutMapping("/{id}")
    public Book update(@PathVariable Long id, @RequestBody Book book) {
        book.setId(id);
        return service.saveBook(book);
    }

    /**
     * Supprime un livre à partir de son identifiant.
     *
     * @param id identifiant du livre à supprimer
    */
    @Operation(summary = "Supprimer un livre", description = "Supprime un livre de la base de données.")
    @ApiResponse(responseCode = "204", description = "livre supprimé avec succès")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteBookById(id);
    }
}
