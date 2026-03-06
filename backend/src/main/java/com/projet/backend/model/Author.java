package com.projet.backend.model;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * <h2>Entité représentant un auteur</h2>
 *
 * <p>
 * Cette classe représente un auteur dans le système de gestion
 * de bibliothèque.
 * </p>
 *
 * <p>
 * Un auteur peut être associé à plusieurs livres dans la base
 * de données.
 * </p>
 */
@Entity
@Table(name="author")
@Schema(description = "Représente un auteur de livres")
public class Author {

    /**
     * Identifiant unique de l'auteur.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    @Schema(description = "Identifiant unique de l'auteur", example = "1")
    private Long id;

    /**
     * Nom de l'auteur.
     */
    @Column(name="name")
    @Schema(description = "Nom de l'auteur", example = "Robert C. Martin")
    private String name;

    /**
     * Liste des livres écrits par cet auteur.
     *
     * <p>
     * Cette relation est ignorée lors de la sérialisation JSON
     * afin d'éviter les boucles infinies lors de la conversion
     * des objets en JSON.
     * </p>
     */
    @OneToMany(mappedBy = "author")
    @JsonIgnore
    @Schema(description = "Liste des livres écrits par l'auteur")
    private List<Book> books;

	/** 
	 * @return Long
	 */
	public Long getId() {
		return id;
	}

	/** 
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/** 
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/** 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/** 
	 * @return List<Book>
	 */
	public List<Book> getBooks() {
		return books;
	}

	/** 
	 * @param books
	 */
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	
}
