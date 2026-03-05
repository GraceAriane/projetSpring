//package com.projet.backend.service;
//
//import com.projet.backend.dto.LoanRequestDTO;
//import com.projet.backend.dto.LoanResponseDTO;
//import com.projet.backend.model.Loan;
//
//import java.util.List;
//import java.util.Optional;
//
//public interface LoanService {
////    public Loan saveLoan(Loan loan);
////    public Optional<Loan> getLoanId(Long id);
////    public void deleteLoanById(Long id);
////    public Loan updateLoan(Long id, Loan newLoan);
////    public List<Loan> getAllLoan();
////
//    LoanResponseDTO borrowBook(LoanRequestDTO request);
//    LoanResponseDTO returnBook(Long loanId);
//    LoanResponseDTO extendLoan(Long loanId);
//    LoanResponseDTO getLoanById(Long id);
//    void deleteLoan(Long id);
//    List<LoanResponseDTO> getAllLoans();
//}


package com.projet.backend.service;

import java.util.List;

import com.projet.backend.dto.LoanResponseDTO;

public interface LoanService {
    LoanResponseDTO borrowBook(Long userId, Long bookId);
    LoanResponseDTO returnBook(Long loanId);
    LoanResponseDTO extendLoan(Long loanId, int additionalDays);
    List<LoanResponseDTO> getUserLoans(Long userId);
}