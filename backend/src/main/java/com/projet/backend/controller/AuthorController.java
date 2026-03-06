package com.projet.backend.controller;

import com.projet.backend.model.Author;
import com.projet.backend.service.AuthorService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Contrôleur REST permettant de gérer les auteurs.
 */
/**
 * <h2>Contrôleur de gestion des auteurs</h2>
 *
 * <p>
 * Ce contrôleur expose les endpoints REST permettant de gérer les auteurs
 * du système de gestion de bibliothèque.
 * </p>
 *
 * <p>
 * Les opérations disponibles incluent :
 * </p>
 * <ul>
 * <li>Récupération de tous les auteurs</li>
 * <li>Récupération d’un auteur par identifiant</li>
 * <li>Création d’un nouvel auteur</li>
 * <li>Mise à jour d’un auteur existant</li>
 * <li>Suppression d’un auteur</li>
 * </ul>
 *
 * <p>
 * Toutes les requêtes sont accessibles via le chemin de base :
 * <code>/api/authors</code>
 * </p>
 *
 * @author
 */
@Tag(name = "Auteurs", description = "Gestion des auteurs")
@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private final AuthorService service;
    
    /**
     * Constructeur du contrôleur des auteurs.
     *
     * @param service service contenant la logique métier liée aux auteurs
     */
    public AuthorController(AuthorService service) {
        this.service = service;
    }

    /**
     * Récupère la liste complète des auteurs.
     *
     * @return liste de tous les auteurs enregistrés dans le système
     */
    @Operation(summary = "Lister tous les auteurs", description = "Retourne la liste complète des auteurs enregistrés dans la bibliothèque.")
    @ApiResponse(responseCode = "200", description = "Liste des auteurs récupérée avec succès")
    @GetMapping
    public List<Author> getAllAuthor() {
        return service.getAllAuthor();
    }

    /**
     * Récupère un auteur à partir de son identifiant.
     *
     * @param id identifiant unique du auteur
     * @return l'auteur correspondant si trouvé
     */
    @Operation(summary = "Rechercher un auteur par ID", description = "Retourne les informations d'un auteur spécifique.")
    @ApiResponse(responseCode = "200", description = "auteur trouvé")
    @ApiResponse(responseCode = "404", description = "auteur non trouvé")
    @GetMapping("/{id}")
    public Optional<Author> geAuthorId(@PathVariable Long id) {
        return service.getAuthorId(id);
    }

    /**
     * Crée un nouvel auteur dans le système.
     *
     * @param auteur objet auteur à enregistrer
     * @return auteur enregistré
     */
    @Operation(summary = "Créer un auteur", description = "Permet d'ajouter un nouvel auteur dans la base de données.")
    @ApiResponse(responseCode = "201", description = "auteur créé avec succès")
    @PostMapping
    public Author create(@RequestBody Author author) {
        return service.saveAuthor(author);
    }

    /**
     * Met à jour les informations d'un auteur existant.
     *
     * @param id   identifiant du auteur à modifier
     * @param author nouvelles informations du auteur
     * @return auteur mis à jour
     */
    @Operation(summary = "Mettre à jour un auteur", description = "Met à jour les informations d'un auteur existant.")
    @ApiResponse(responseCode = "200", description = "auteur mis à jour avec succès")
    @PutMapping("/{id}")
    public Author update(@PathVariable Long id, @RequestBody Author author) {
        author.setId(id);
        return service.saveAuthor(author);
    }

    /**
     * Supprime un auteur à partir de son identifiant.
     *
     * @param id identifiant du auteur à supprimer
    */
    @Operation(summary = "Supprimer un auteur", description = "Supprime un auteur de la base de données.")
    @ApiResponse(responseCode = "204", description = "auteur supprimé avec succès")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteAuthorById(id);
    }
}