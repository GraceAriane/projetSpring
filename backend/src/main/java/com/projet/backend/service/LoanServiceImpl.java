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

    /** 
     * @param loan
     * @return Loan
     */
    @Override
    public Loan saveLoan(Loan loan) {
        return repository.save(loan);
    }

    /** 
     * @param id
     * @return Optional<Loan>
     */
    @Override
    public Optional<Loan> getLoanId(Long id) {
        return repository.findById(id);
    }

    /** 
     * @param id
     */
    @Override
    public void deleteLoanById(Long id) {
        repository.deleteById(id);
    }

    /** 
     * @param id
     * @param newLoan
     * @return Loan
     */
    @Override
    public Loan updateLoan(Long id, Loan newLoan) {
        return repository.findById(id)
                .map(loan -> {
                    loan.setStatus(newLoan.getStatus());
                    return repository.save(loan);
                }).orElse(null);
    }

    /** 
     * @return List<Loan>
     */
    @Override
    public List<Loan> getAllLoan() {
        return repository.findAll();
    }
}
