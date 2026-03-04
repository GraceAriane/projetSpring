package com.projet.backend.service;

import com.projet.backend.model.Loan;

import java.util.List;
import java.util.Optional;

public interface LoanService {
    public Loan saveLoan(Loan loan);
    public Optional<Loan> getLoanId(Long id);
    public void deleteLoanById(Long id);
    public Loan updateLoan(Long id, Loan newLoan);
    public List<Loan> getAllLoan();

}
