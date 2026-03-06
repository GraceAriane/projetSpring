package com.projet.backend.model;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
/**
 * <h2>Entité représentant un emprunt de livre</h2>
 *
 * <p>
 * Cette classe représente un emprunt effectué par un utilisateur
 * dans le système de gestion de bibliothèque.
 * </p>
 *
 * <p>
 * Un emprunt associe :
 * </p>
 *
 * <ul>
 *     <li>un utilisateur</li>
 *     <li>un livre</li>
 *     <li>une date d'emprunt</li>
 *     <li>une date de retour prévue</li>
 *     <li>un statut d'emprunt</li>
 *     <li>une éventuelle pénalité</li>
 * </ul>
 */
@Entity
@Table(name="loan")
@Schema(description = "Représente un emprunt de livre")
public class Loan {
	
    /**
     * Identifiant unique de l'emprunt.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identifiant de l'emprunt", example = "1")
    private Long id;

    /**
     * Utilisateur ayant effectué l'emprunt.
     */
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @Schema(description = "Utilisateur ayant emprunté le livre")
    private User user;

    /**
     * Livre emprunté.
     */
    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    @Schema(description = "Livre emprunté")
    private Book book;

    /**
     * Date à laquelle le livre a été emprunté.
     */
    @Column(name="loan_date", nullable = false)
    @Schema(description = "Date d'emprunt", example = "2026-03-06")
    private LocalDate loanDate;

    /**
     * Date prévue pour le retour du livre.
     */
    @Column(name = "expected_return_date", nullable = false)
    @Schema(description = "Date de retour prévue", example = "2026-03-20")
    private LocalDate expectedReturnDate;

    /**
     * Statut de l'emprunt.
     */
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    @Schema(description = "Statut de l'emprunt", example = "ACTIVE")
    private LoanStatus status;

    /**
     * Montant de la pénalité en cas de retard.
     */
    @Column(name = "penalty", nullable = false)
    @Schema(description = "Pénalité appliquée en cas de retard", example = "0.0")
    private Double penalty = 0.0;
    
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
	 * @return User
	 */
	public User getUser() {
		return user;
	}

	/** 
	 * @param user
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/** 
	 * @return Book
	 */
	public Book getBook() {
		return book;
	}

	/** 
	 * @param book
	 */
	public void setBook(Book book) {
		this.book = book;
	}

	/** 
	 * @return LocalDate
	 */
	public LocalDate getLoanDate() {
		return loanDate;
	}

	/** 
	 * @param loanDate
	 */
	public void setLoanDate(LocalDate loanDate) {
		this.loanDate = loanDate;
	}

	/** 
	 * @return LocalDate
	 */
	public LocalDate getExpectedReturnDate() {
		return expectedReturnDate;
	}

	/** 
	 * @param expectedReturnDate
	 */
	public void setExpectedReturnDate(LocalDate expectedReturnDate) {
		this.expectedReturnDate = expectedReturnDate;
	}

	/** 
	 * @return LoanStatus
	 */
	public LoanStatus getStatus() {
		return status;
	}

	/** 
	 * @param status
	 */
	public void setStatus(LoanStatus status) {
		this.status = status;
	}

	/** 
	 * @return Double
	 */
	public Double getPenalty() {
		return penalty;
	}

	/** 
	 * @param penalty
	 */
	public void setPenalty(Double penalty) {
		this.penalty = penalty;
	}
}
