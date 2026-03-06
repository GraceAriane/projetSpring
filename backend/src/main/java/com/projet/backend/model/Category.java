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
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "category")
@Schema(description = "Représente un emprunt de livre")
@Getter
@Setter
public class Category {

	/**
     * Identifiant unique de la catégorie
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identifiant de la catégorie", example = "1")
    private Long id;

    /**
     * Nom de la catégorie
     */
    @Column(name="name", nullable = false)
    @Schema(description = "Nom de la catégorie", example = "romance")
    private String name;
	
	@OneToMany(mappedBy = "category")
	@JsonIgnore
	private List<Book> books;

	// /** 
	//  * @return Long
	//  */
	// public Long getId() {
	// 	return id;
	// }

	// /** 
	//  * @param id
	//  */
	// public void setId(Long id) {
	// 	this.id = id;
	// }

	// /** 
	//  * @return String
	//  */
	// public String getName() {
	// 	return name;
	// }

	// /** 
	//  * @param name
	//  */
	// public void setName(String name) {
	// 	this.name = name;
	// }

	// /** 
	//  * @return List<Book>
	//  */
	// public List<Book> getBooks() {
	// 	return books;
	// }

	// /** 
	//  * @param books
	//  */
	// public void setBooks(List<Book> books) {
	// 	this.books = books;
	// }
	
	
	
}
