package com.projet.backend.controller;



import com.projet.backend.model.Loan;
import com.projet.backend.service.LoanService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * <h2>Contrôleur de gestion des emprunts</h2>
 *
 * <p>
 * Ce contrôleur expose les endpoints REST permettant de gérer les emprunts
 * du système de gestion de bibliothèque.
 * </p>
 *
 * <p>Les opérations disponibles incluent :</p>
 * <ul>
 *     <li>Récupération de tous les emprunts</li>
 *     <li>Récupération d’un emprunt par identifiant</li>
 *     <li>Création d’un nouvel emprunt</li>
 *     <li>Mise à jour d’un emprunt existant</li>
 *     <li>Suppression d’un emprunt</li>
 * </ul>
 *
 * <p>
 * Toutes les requêtes sont accessibles via le chemin de base :
 * <code>/api/loans</code>
 * </p>
 *
 * @author
 */

@Tag(name = "Emprunts", description = "Gestion des emprunts des emprunts")
@RestController
@RequestMapping("/api/loans")
public class LoanController {


    public LoanService service;
    /**
     * Constructeur du contempruntur des emprunts.
     *
     * @param service service contenant la logique métier liée aux emprunts
     */
    public LoanController(LoanService service) {
        this.service = service;
    }

    /**
     * Récupère la liste complète des emprunts.
     *
     * @return liste de tous les emprunts enregistrés dans le système
     */
    @Operation(
            summary  = "Lister tous les emprunts",
            description  = "Retourne la liste complète des emprunts enregistrés dans la bibliothèque."
    )
    @ApiResponse(responseCode = "200", description = "Liste des emprunts récupérée avec succès")
    @GetMapping
    public List<Loan> getAll() {
        return service.getAllLoan();
    }
    
    /**
     * Récupère un emprunt à partir de son identifiant.
     *
     * @param id identifiant unique de l'emprunt
     * @return l'emprunt correspondant si trouvé
     */
    @Operation(
            summary = "Rechercher un emprunt par ID",
            description = "Retourne les informations d'un emprunt spécifique."
    )
    @ApiResponse(responseCode = "200", description = "emprunt trouvé")
    @GetMapping("/{id}")
    public Optional<Loan> getById(@PathVariable Long id) {
        return service.getLoanId(id);
    }
    
    /**
     * Crée un nouvel emprunt dans le système.
     *
     * @param emprunt objet emprunt à enregistrer
     * @return emprunt enregistré
     */
    @Operation(
            summary = "Créer un emprunt",
            description = "Permet d'ajouter un nouvel emprunt dans la base de données."
    )
    @ApiResponse(responseCode = "201", description = "emprunt créé avec succès")
    @PostMapping
    public Loan create(@RequestBody Loan loan) {
        return service.saveLoan(loan);
    }
    
    /**
     * Met à jour les informations d'un emprunt existant.
     *
     * @param id identifiant du emprunt à modifier
     * @param loan nouvelles informations de l'emprunt
     * @return emprunt mis à jour
     */
    @Operation(
            summary = "Mettre à jour un emprunt",
            description = "Met à jour les informations d'un emprunt existant."
    )
    @ApiResponse(responseCode = "200", description = "emprunt mis à jour avec succès")
    @PutMapping("/{id}")
    public Loan update(@PathVariable Long id, @RequestBody Loan loan) {
        loan.setId(id);
        return service.saveLoan(loan);
    }
    
    /**
     * Supprime un emprunt à partir de son identifiant.
     *
     * @param id identifiant de l' emprunt à supprimer
     */
    @Operation(
            summary = "Supprimer un emprunt",
            description = "Supprime un emprunt de la base de données."
    )
    @ApiResponse(responseCode  = "204", description = "emprunt supprimé avec succès")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteLoanById(id);
    }
}
