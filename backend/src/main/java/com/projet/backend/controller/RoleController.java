package com.projet.backend.controller;

import com.projet.backend.model.Author;
import com.projet.backend.model.Role;
import com.projet.backend.service.AuthorService;
import com.projet.backend.service.RoleService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Contrôleur REST permettant de gérer les rôles des utilisateurs.
 */
/**
 * <h2>Contrôleur de gestion des rôles</h2>
 *
 * <p>
 * Ce contrôleur expose les endpoints REST permettant de gérer les rôles
 * du système de gestion de bibliothèque.
 * </p>
 *
 * <p>Les opérations disponibles incluent :</p>
 * <ul>
 *     <li>Récupération de tous les rôles</li>
 *     <li>Récupération d’un role par identifiant</li>
 *     <li>Création d’un nouveau rôle</li>
 *     <li>Mise à jour d’un rôle existant</li>
 *     <li>Suppression d’un rôle</li>
 * </ul>
 *
 * <p>
 * Toutes les requêtes sont accessibles via le chemin de base :
 * <code>/api/roles</code>
 * </p>
 *
 * @author
 */

@Tag(name = "Rôles", description = "Gestion des rôles des utilisateurs")
@RestController
@RequestMapping("/api/roles")
public class RoleController {

    private final RoleService service;
    
    /**
     * Constructeur du contrôleur des roles.
     *
     * @param service service contenant la logique métier liée aux roles
     */
    public RoleController(RoleService service) {
        this.service = service;
    }
    /**
     * Récupère la liste complète des roles.
     *
     * @return liste de tous les roles enregistrés dans le système
     */
    @Operation(
            summary  = "Lister tous les roles",
            description  = "Retourne la liste complète des roles enregistrés dans la bibliothèque."
    )
    @ApiResponse(responseCode = "200", description = "Liste des roles récupérée avec succès")
    @GetMapping
    public List<Role> getAllRoles() {
        return service.getAllRole();
    }
    
    /**
     * Crée un nouveau rôle dans le système.
     *
     * @param role objet Rôle à enregistrer
     * @return rôle enregistré
    */
    @Operation(
            summary = "Créer un rôle",
            description = "Permet d'ajouter un nouveau rôle dans la base de données."
    )
    @ApiResponse(responseCode = "201", description = "rôle créé avec succès")
    @PostMapping
    public Role create(@RequestBody Role role) {
        return service.saveRole(role);
    }
    
    /**
     * Met à jour les informations d'un role existant.
     *
     * @param id identifiant du role à modifier
     * @param role nouvelles informations du role
     * @return role mis à jour
     */
    @Operation(
            summary = "Mettre à jour un role",
            description = "Met à jour les informations d'un role existant."
    )
    @ApiResponse(responseCode = "200", description = "Rôle mis à jour avec succès")
    @PutMapping("/{id}")
    public Role update(@PathVariable Long id, @RequestBody Role role) {
        role.setId(id);
        return service.saveRole(role);
    }
    
    /**
     * Supprime un role à partir de son identifiant.
     *
     * @param id identifiant du role à supprimer
     */
    @Operation(
            summary = "Supprimer un role",
            description = "Supprime un role de la base de données."
    )
    @ApiResponse(responseCode  = "204", description = "Role supprimé avec succès")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteRoleById(id);
    }
}