package com.projet.backend.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


/**
 * <h2>Entité représentant un livre dans la bibliothèque</h2>
 *
 * <p>
 * Cette classe représente un livre disponible dans le système de gestion
 * de bibliothèque. Chaque livre possède des informations bibliographiques
 * ainsi que des informations liées à sa disponibilité.
 * </p>
 *
 * <p>
 * Un livre est associé à :
 * </p>
 *
 * <ul>
 *     <li>un auteur</li>
 *     <li>une catégorie</li>
 * </ul>
 *
 * <p>
 * Le système maintient également le nombre total d'exemplaires et
 * le nombre d'exemplaires actuellement disponibles pour l'emprunt.
 * </p>
 */
@Entity
@Table(name="book")
@Schema(description = "Représente un livre dans la bibliothèque")
public class Book {

    /**
     * Identifiant unique du livre.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    @Schema(description = "Identifiant unique du livre", example = "1")
    private Long id;

    /**
     * Titre du livre.
     */
    @Column(nullable = false)
    @Schema(description = "Titre du livre", example = "Clean Code")
    private String title;

    /**
     * Numéro ISBN du livre.
     */
    @Column(unique = true)
    @Schema(description = "Code ISBN du livre", example = "9780132350884")
    private String isbn;

    /**
     * Description ou résumé du livre.
     */
    @Column(columnDefinition = "TEXT")
    @Schema(description = "Description ou résumé du livre")
    private String description;

    /**
     * Nombre total d'exemplaires du livre dans la bibliothèque.
     */
    @Column(name="total_quantity", nullable = false)
    @Schema(description = "Nombre total d'exemplaires", example = "10")
    private int totalQuantity;

    /**
     * Nombre d'exemplaires actuellement disponibles pour l'emprunt.
     */
    @Column(name="available_quantity", nullable = false)
    @Schema(description = "Nombre d'exemplaires disponibles", example = "7")
    private int availableQuantity;

    /**
     * Auteur du livre.
     */
    @ManyToOne
    @JoinColumn(name="author_id")
    @Schema(description = "Auteur du livre")
    private Author author;

    /**
     * Catégorie à laquelle appartient le livre.
     */
    @ManyToOne
    @JoinColumn(name="category_id")
    @Schema(description = "Catégorie du livre")
    private Category category;


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
	public String getTitle() {
		return title;
	}

	/** 
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/** 
	 * @return String
	 */
	public String getIsbn() {
		return isbn;
	}

	/** 
	 * @param isbn
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/** 
	 * @return String
	 */
	public String getDescription() {
		return description;
	}

	/** 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/** 
	 * @return int
	 */
	public int getTotalQuantity() {
		return totalQuantity;
	}

	/** 
	 * @param totalQuantity
	 */
	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	/** 
	 * @return int
	 */
	public int getAvailableQuantity() {
		return availableQuantity;
	}

	/** 
	 * @param availableQuantity
	 */
	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	/** 
	 * @return Author
	 */
	public Author getAuthor() {
		return author;
	}

	/** 
	 * @param author
	 */
	public void setAuthor(Author author) {
		this.author = author;
	}

	/** 
	 * @return Category
	 */
	public Category getCategory() {
		return category;
	}

	/** 
	 * @param category
	 */
	public void setCategory(Category category) {
		this.category = category;
	}
	
	
	
}
