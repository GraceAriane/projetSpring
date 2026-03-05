package com.projet.backend.dto;

import jakarta.validation.constraints.NotNull;

public class LoanActionRequest {

    @NotNull(message = "Loan ID cannot be null")
    private Long loanId;

    // Pour prolongation, nombre de jours à ajouter
    private Integer extendDays;

    public LoanActionRequest() {}

    public LoanActionRequest(Long loanId, Integer extendDays) {
        this.loanId = loanId;
        this.extendDays = extendDays;
    }

    public Long getLoanId() {
        return loanId;
    }

    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    public Integer getExtendDays() {
        return extendDays;
    }

    public void setExtendDays(Integer extendDays) {
        this.extendDays = extendDays;
    }
}