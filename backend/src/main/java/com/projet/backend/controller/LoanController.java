package com.projet.backend.controller;



import com.projet.backend.dto.LoanActionRequest;
import com.projet.backend.dto.LoanRequestDTO;
import com.projet.backend.dto.LoanResponseDTO;
import com.projet.backend.model.Loan;
import com.projet.backend.service.LoanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@RestController
//@RequestMapping("/api/loans")
//public class LoanController {

//
////    public LoanService service;
////
////    public LoanController(LoanService service) {
////        this.service = service;
////    }
////
////    @GetMapping
////    public List<Loan> getAll() {
////        return service.getAllLoan();
////    }
////
////    @GetMapping("/{id}")
////    public Optional<Loan> getById(@PathVariable Long id) {
////        return service.getLoanId(id);
////    }
////
////    @PostMapping
////    public Loan create(@RequestBody Loan loan) {
////        return service.saveLoan(loan);
////    }
////
////    @PutMapping("/{id}")
////    public Loan update(@PathVariable Long id, @RequestBody Loan loan) {
////        loan.setId(id);
////        return service.saveLoan(loan);
////    }
////
////    @DeleteMapping("/{id}")
////    public void delete(@PathVariable Long id) {
////        service.deleteLoanById(id);
////    }
//    private final LoanService service;
//    public LoanController(LoanService service) {
//        this.service = service;
//    }
//
//    @GetMapping
//    public List<Loan> getAll() {
//        return service.getAllLoan();
//    }
//
//    @GetMapping("/{id}")
//    public Optional<Loan> getById(@PathVariable Long id) {
//        return service.getLoanId(id);
//    }
//
//    @PostMapping("/borrow")
//    public Loan create(@RequestBody Loan loan) {
//        return service.saveLoan(loan);
//    }
//
//    @PutMapping("/{id}")
//    public Loan update(@PathVariable Long id, @RequestBody Loan loan) {
//        loan.setId(id);
//        return service.saveLoan(loan);
//    }
//
//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable Long id) {
//        service.deleteLoanById(id);
//    }
//}




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.projet.backend.dto.LoanResponseDTO;
import com.projet.backend.service.LoanService;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @PostMapping("/borrow")
    public LoanResponseDTO borrowBook(@RequestBody LoanRequestDTO request) {
        return loanService.borrowBook(request.getUserId(), request.getBookId());
    }

    @PostMapping("/return")
    public LoanResponseDTO returnBook(@RequestBody LoanActionRequest request) {
        return loanService.returnBook(request.getLoanId());
    }

    @PostMapping("/extend")
    public LoanResponseDTO extendLoan(@RequestBody LoanActionRequest request) {
        return loanService.extendLoan(request.getLoanId(), request.getExtendDays());
    }

    @GetMapping("/user/{userId}")
    public List<LoanResponseDTO> getUserLoans(@PathVariable Long userId) {
        return loanService.getUserLoans(userId);
    }
}