package com.projet.backend.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projet.backend.model.User;
import com.projet.backend.service.UserService;

/**
 * <h2>Contrôleur de gestion des utilisateurs</h2>
 *
 * <p>
 * Ce contrôleur expose les endpoints REST permettant de gérer les utilisateurs
 * du système de gestion de bibliothèque.
 * </p>
 *
 * <p>Les opérations disponibles incluent :</p>
 * <ul>
 *     <li>Récupération de tous les utilisateurs</li>
 *     <li>Récupération d’un utilisateur par identifiant</li>
 *     <li>Création d’un nouvel utilisateur</li>
 *     <li>Mise à jour d’un utilisateur existant</li>
 *     <li>Suppression d’un utilisateur</li>
 * </ul>
 *
 * <p>
 * Toutes les requêtes sont accessibles via le chemin de base :
 * <code>/api/users</code>
 * </p>
 *
 * @author
 */
@Tag(name = "Utilisateurs", description = "API de gestion des utilisateurs de la bibliothèque")
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    /**
     * Constructeur du contrôleur des utilisateurs.
     *
     * @param service service contenant la logique métier liée aux utilisateurs
     */
    public UserController(UserService service) {
        this.service = service;
    }

    /**
     * Récupère la liste complète des utilisateurs.
     *
     * @return liste de tous les utilisateurs enregistrés dans le système
     */
    @Operation(
            summary  = "Lister tous les utilisateurs",
            description  = "Retourne la liste complète des utilisateurs enregistrés dans la bibliothèque."
    )
    @ApiResponse(responseCode = "200", description = "Liste des utilisateurs récupérée avec succès")
    @GetMapping
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    /**
     * Récupère un utilisateur à partir de son identifiant.
     *
     * @param id identifiant unique de l'utilisateur
     * @return l'utilisateur correspondant si trouvé
     */
    @Operation(
            summary = "Rechercher un utilisateur par ID",
            description = "Retourne les informations d'un utilisateur spécifique."
    )
    @ApiResponse(responseCode = "200", description = "Utilisateur trouvé")
    @ApiResponse(responseCode = "404", description = "Utilisateur non trouvé")
    @GetMapping("/{id}")
    public Optional<User> getUserId(
            @Parameter(description = "Identifiant de l'utilisateur", example = "1")
            @PathVariable Long id) {
        return service.getUserById(id);
    }

    /**
     * Crée un nouvel utilisateur dans le système.
     *
     * @param user objet utilisateur à enregistrer
     * @return utilisateur enregistré
     */
    @Operation(
            summary = "Créer un utilisateur",
            description = "Permet d'ajouter un nouvel utilisateur dans la base de données."
    )
    @ApiResponse(responseCode = "201", description = "Utilisateur créé avec succès")
    @PostMapping
    public User create(@RequestBody User user) {
        return service.saveUser(user);
    }

    /**
     * Met à jour les informations d'un utilisateur existant.
     *
     * @param id identifiant de l'utilisateur à modifier
     * @param user nouvelles informations de l'utilisateur
     * @return utilisateur mis à jour
     */
    @Operation(
            summary = "Mettre à jour un utilisateur",
            description = "Met à jour les informations d'un utilisateur existant."
    )
    @ApiResponse(responseCode = "200", description = "Utilisateur mis à jour avec succès")
    @PutMapping("/{id}")
    public User update(
            @Parameter(description = "Identifiant de l'utilisateur")
            @PathVariable Long id,
            @RequestBody User user) {
    	

        user.setId(id);
        return service.saveUser(user);
    }

    /**
     * Supprime un utilisateur à partir de son identifiant.
     *
     * @param id identifiant de l'utilisateur à supprimer
     */
    @Operation(
            summary = "Supprimer un utilisateur",
            description = "Supprime un utilisateur de la base de données."
    )
    @ApiResponse(responseCode  = "204", description = "Utilisateur supprimé avec succès")
    @DeleteMapping("/{id}")
    public void delete(
            @Parameter(description = "Identifiant de l'utilisateur")
            @PathVariable Long id) {

        service.deleteUserById(id);
    }
}
