package com.projet.
backend.dto;



import java.time.LocalDate;

import com.projet.backend.model.Loan;
import com.projet.backend.model.LoanStatus;

public class LoanResponseDTO {

    private Long id;
    private Long userId;
    private String userName;
    private Long bookId;
    private String bookTitle;
    private LocalDate loanDate;
    private LocalDate expectedReturnDate;
    private LoanStatus status;
    private Double penalty;

    public LoanResponseDTO() {}

    public LoanResponseDTO(Loan loan) {
        this.id = loan.getId();
        this.userId = loan.getUser().getId();
        this.userName = loan.getUser().getName();
        this.bookId = loan.getBook().getId();
        this.bookTitle = loan.getBook().getTitle();
        this.loanDate = loan.getLoanDate();
        this.expectedReturnDate = loan.getExpectedReturnDate();
        this.status = loan.getStatus();
        this.penalty = loan.getPenalty();
    }

    // Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public Long getBookId() { return bookId; }
    public void setBookId(Long bookId) { this.bookId = bookId; }

    public String getBookTitle() { return bookTitle; }
    public void setBookTitle(String bookTitle) { this.bookTitle = bookTitle; }

    public LocalDate getLoanDate() { return loanDate; }
    public void setLoanDate(LocalDate loanDate) { this.loanDate = loanDate; }

    public LocalDate getExpectedReturnDate() { return expectedReturnDate; }
    public void setExpectedReturnDate(LocalDate expectedReturnDate) { this.expectedReturnDate = expectedReturnDate; }

    public LoanStatus getStatus() { return status; }
    public void setStatus(LoanStatus status) { this.status = status; }

    public Double getPenalty() { return penalty; }
    public void setPenalty(Double penalty) { this.penalty = penalty; }
}