package com.projet.backend.controller;


import com.projet.backend.model.Category;
import com.projet.backend.service.CategoryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Contrôleur REST permettant de gérer les catégories des livres.
 */
/**
 * <h2>Contrôleur de gestion des catégories</h2>
 *
 * <p>
 * Ce contrôleur expose les endpoints REST permettant de gérer les catégories
 * du système de gestion de bibliothèque.
 * </p>
 *
 * <p>Les opérations disponibles incluent :</p>
 * <ul>
 *     <li>Récupération de tous les catégories</li>
 *     <li>Récupération d’un catégorie par identifiant</li>
 *     <li>Création d’un nouveau catégorie</li>
 *     <li>Mise à jour d’un catégorie existant</li>
 *     <li>Suppression d’un catérogie</li>
 * </ul>
 *
 * <p>
 * Toutes les requêtes sont accessibles via le chemin de base :
 * <code>/api/categories</code>
 * </p>
 *
 * @author
 */

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService service;

    /**
     * Constructeur du contrôleur des catégories.
     *
     * @param service service contenant la logique métier liée aux catégories
     */
    public CategoryController(CategoryService service) {
        this.service = service;
    }

    /**
     * Récupère la liste complète des catégories.
     *
     * @return liste de tous les catégories enregistrés dans le système
     */
    @Operation(
            summary  = "Lister tous les catégories",
            description  = "Retourne la liste complète des catégories enregistrés dans la bibliothèque."
    )
    @ApiResponse(responseCode = "200", description = "Liste des catégories récupérée avec succès")
    @GetMapping
    public List<Category> getAllCategory() {
        return service.getAllCategory();
    }

    /**
     * Récupère une catégorie à partir de son identifiant.
     *
     * @param id identifiant unique de l'catégorie
     * @return la catégorie correspondant si trouvé
     */
    @Operation(
            summary = "Rechercher une catégorie par ID",
            description = "Retourne les informations d'une catégorie spécifique."
    )
    @ApiResponse(responseCode = "200", description = "catégorie trouvé")
    @GetMapping("/{id}")
    public Optional<Category> getCategoryId(@PathVariable Long id) {
        return service.getCategoryById(id);
    }

    /**
     * Crée un nouvelle catégorie dans le système.
     *
     * @param category objet catégorie à enregistrer
     * @return catégorie enregistré
    */
    @Operation(
            summary = "Créer une catégorie",
            description = "Permet d'ajouter un nouvelle catégorie dans la base de données."
    )
    @ApiResponse(responseCode = "201", description = "catégorie créée avec succès")
    @PostMapping
    public Category create(@RequestBody Category category) {
        return service.saveCategory(category);
    }

        
    /**
     * Met à jour les informations d'une catégorie existant.
     *
     * @param id identifiant de la catégorie à modifier
     * @param catégorie nouvelles informations de la catégorie
     * @return catégorie mis à jour
     */
    @Operation(
            summary = "Mettre à jour une catégorie",
            description = "Met à jour les informations d'une catégorie existante."
    )
    @ApiResponse(responseCode = "200", description = "Catégorie mis à jour avec succès")
    @PutMapping("/{id}")
    public Category update(@PathVariable Long id, @RequestBody Category category) {
        category.setId(id);
        return service.saveCategory(category);
    }

    /**
     * Supprime une catégorie à partir de son identifiant.
     *
     * @param id identifiant de la catégorie à supprimer
     */
    @Operation(
            summary = "Supprimer une catégorie",
            description = "Supprime une catégorie de la base de données."
    )
    @ApiResponse(responseCode  = "204", description = "catégorie supprimée avec succès")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteCategoryById(id);
    }
}