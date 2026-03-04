package com.projet.backend.controller;



import com.projet.backend.model.Loan;
import com.projet.backend.service.LoanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/loans")
public class LoanController {


    public LoanService service;

    public LoanController(LoanService service) {
        this.service = service;
    }

    @GetMapping
    public List<Loan> getAll() {
        return service.getAllLoan();
    }

    @GetMapping("/{id}")
    public Optional<Loan> getById(@PathVariable Long id) {
        return service.getLoanId(id);
    }

    @PostMapping
    public Loan create(@RequestBody Loan loan) {
        return service.saveLoan(loan);
    }

    @PutMapping("/{id}")
    public Loan update(@PathVariable Long id, @RequestBody Loan loan) {
        loan.setId(id);
        return service.saveLoan(loan);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteLoanById(id);
    }
}
