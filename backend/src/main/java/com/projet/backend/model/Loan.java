package com.projet.backend.model;

import java.time.LocalDate;

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

@Entity
@Table(name="loan")
public class Loan {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;
	
	@Column(name="loan_date", nullable = false)
	private LocalDate loanDate;
	
    @Column(name = "expected_return_date", nullable = false)
    private LocalDate expectedReturnDate;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private LoanStatus status;

    @Column(name = "penalty", nullable = false)
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
