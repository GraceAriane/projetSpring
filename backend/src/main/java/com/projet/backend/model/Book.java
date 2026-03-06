package com.projet.backend.model;

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

@Entity
@Table(name="book")
@Getter
@Setter
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(nullable = false)
	private String title;
	
	@Column(unique = true)
	private String isbn;
	
	@Column(columnDefinition = "TEXT")
	private String description;
	
	@Column(name="total_quantity", nullable = false)
	private int totalQuantity;
	
	@Column(name="available_quantity", nullable = false)
	private int availableQuantity;
	
	@ManyToOne
	@JoinColumn(name="author_id")
	private Author author;
	
	@ManyToOne
	@JoinColumn(name="category_id")
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
