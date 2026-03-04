package com.projet.backend.service;

import com.projet.backend.model.Loan;
import com.projet.backend.repository.LoanRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanServiceImpl implements LoanService{
    private final LoanRepository repository;

    public LoanServiceImpl(LoanRepository repository){
        this.repository=repository;
    }

    @Override
    public Loan saveLoan(Loan loan) {
        return repository.save(loan);
    }

    @Override
    public Optional<Loan> getLoanId(Long id) {
        return repository.findById(id);
    }

    @Override
    public void deleteLoanById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Loan updateLoan(Long id, Loan newLoan) {
        return repository.findById(id)
                .map(loan -> {
                    loan.setStatus(newLoan.getStatus());
                    return repository.save(loan);
                }).orElse(null);
    }

    @Override
    public List<Loan> getAllLoan() {
        return repository.findAll();
    }
}
