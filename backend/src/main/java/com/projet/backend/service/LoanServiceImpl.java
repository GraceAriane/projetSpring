package com.projet.backend.service;

import com.projet.backend.dto.LoanRequestDTO;
import com.projet.backend.dto.LoanResponseDTO;
import com.projet.backend.model.Book;
import com.projet.backend.model.Loan;
import com.projet.backend.model.LoanStatus;
import com.projet.backend.model.User;
import com.projet.backend.repository.BookRepository;
import com.projet.backend.repository.UserRepository;
import com.projet.backend.repository.LoanRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

//@Service
//public class LoanServiceImpl implements LoanService{
////    private final LoanRepository repository;
//    private final LoanRepository loanRepository;
//    public BookRepository bookRepository;
//    public UserRepository userRepository;
//
////    public LoanServiceImpl(LoanRepository repository){
////        this.repository=repository;
////    }
////
////
////    @Override
////    public Loan saveLoan(Loan loan) {
////        if (loan.getBook() == null || loan.getBook().getId() == null) {
////            throw new RuntimeException("Book must not be null");
////        }
////        if (loan.getUser() == null || loan.getUser().getId() == null) {
////            throw new RuntimeException("User must not be null");
////        }
////
////        // Récupérer les entités complètes depuis la base
////        Book book = bookRepository.findById(loan.getBook().getId())
////                .orElseThrow(() -> new RuntimeException("Book not found"));
////
////        User user = userRepository.findById(loan.getUser().getId())
////                .orElseThrow(() -> new RuntimeException("User not found"));
////
////        // Assigner les entités récupérées
////        loan.setBook(book);
////        loan.setUser(user);
////
////        return repository.save(loan);
////    }
////    @Override
////    public Optional<Loan> getLoanId(Long id) {
////        return repository.findById(id);
////    }
////
////    @Override
////    public void deleteLoanById(Long id) {
////        repository.deleteById(id);
////    }
////
////    @Override
////    public Loan updateLoan(Long id, Loan newLoan) {
////        return repository.findById(id)
////                .map(loan -> {
////                    loan.setStatus(newLoan.getStatus());
////                    return repository.save(loan);
////                }).orElse(null);
////    }
////
////    @Override
////    public List<Loan> getAllLoan() {
////        return repository.findAll();
////    }
//public LoanServiceImpl(
//        LoanRepository loanRepository,
//        BookRepository bookRepository,
//        UserRepository userRepository
//) {
//    this.loanRepository = loanRepository;
//    this.bookRepository = bookRepository;
//    this.userRepository = userRepository;
//}
//
//    @Override
//    public LoanResponseDTO borrowBook(LoanRequestDTO request) {
//        User user = userRepository.findById(request.getUserId())
//                .orElseThrow(() -> new RuntimeException("User not found"));
//
//        Book book = bookRepository.findById(request.getBookId())
//                .orElseThrow(() -> new RuntimeException("Book not found"));
//
//        if (book.getAvailableQuantity() <= 0) {
//            throw new RuntimeException("Book not available");
//        }
//
//        book.setAvailableQuantity(book.getAvailableQuantity() - 1);
//        bookRepository.save(book);
//
//        Loan loan = new Loan();
//        loan.setUser(user);
//        loan.setBook(book);
//        loan.setLoanDate(LocalDate.now());
//        loan.setExpectedReturnDate(request.getExpectedReturnDate());
//        loan.setStatus("BORROWED");
//        loan.setPenalty(0.0);
//
//        loanRepository.save(loan);
//
//        return mapToDTO(loan);
//    }
//
//    @Override
//    public LoanResponseDTO returnBook(Long loanId) {
//        return null;
//    }
//
//    @Override
//    public LoanResponseDTO extendLoan(Long loanId) {
//        return null;
//    }
//
//    @Override
//    public LoanResponseDTO getLoanById(Long id) {
//        return null;
//    }
//
//    @Override
//    public void deleteLoan(Long id) {
//
//    }
//
//    @Override
//    public List<LoanResponseDTO> getAllLoans() {
//        return List.of();
//    }
//
////    @Override
////    public Loan saveLoan(Loan loan) {
////
////        Book book = bookRepository.findById(loan.getBook().getId())
////                .orElseThrow(() -> new RuntimeException("Book not found"));
////
////        User user = userRepository.findById(loan.getUser().getId())
////                .orElseThrow(() -> new RuntimeException("User not found"));
////
////        if (book.getAvailableQuantity() <= 0) {
////            throw new RuntimeException("Book not available");
////        }
////
////        book.setAvailableQuantity(book.getAvailableQuantity() - 1);
////        bookRepository.save(book);
////
////        loan.setBook(book);
////        loan.setUser(user);
////        loan.setStatus("BORROWED");
////
////        return repository.save(loan);
////    }
////
////    @Override
////    public List<Loan> getAllLoans() {
////        return repository.findAll();
////    }
////
////    @Override
////    public Optional<Loan> getLoanId(Long id) {
////        return repository.findById(id);
////    }
////
////    @Override
////    public Loan returnBook(Long id) {
////
////        Loan loan = repository.findById(id)
////                .orElseThrow(() -> new RuntimeException("Loan not found"));
////
////        Book book = loan.getBook();
////
////        book.setAvailableQuantity(book.getAvailableQuantity() + 1);
////        bookRepository.save(book);
////
////        loan.setStatus("RETURNED");
////
////        return repository.save(loan);
////    }
////
////    @Override
////    public void deleteLoanById(Long id) {
////        repository.deleteById(id);
////    }
//}


//
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDate;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class LoanServiceImpl implements LoanService {
//
//    private final LoanRepository loanRepository;
//    private final BookRepository bookRepository;
//    private final UserRepository userRepository;
//
//    public LoanServiceImpl(LoanRepository loanRepository,
//                           BookRepository bookRepository,
//                           UserRepository userRepository) {
//        this.loanRepository = loanRepository;
//        this.bookRepository = bookRepository;
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public LoanResponseDTO borrowBook(LoanRequestDTO request) {
//
//        User user = userRepository.findById(request.getUserId())
//                .orElseThrow(() -> new RuntimeException("User not found"));
//
//        Book book = bookRepository.findById(request.getBookId())
//                .orElseThrow(() -> new RuntimeException("Book not found"));
//
//        if (book.getAvailableQuantity() <= 0) {
//            throw new RuntimeException("Book not available");
//        }
//
//        book.setAvailableQuantity(book.getAvailableQuantity() - 1);
//        bookRepository.save(book);
//
//        Loan loan = new Loan();
//        loan.setUser(user);
//        loan.setBook(book);
//        loan.setLoanDate(LocalDate.now());
//        loan.setExpectedReturnDate(request.getExpectedReturnDate());
//        loan.setStatus(LoanStatus.valueOf("BORROWED"));
//        loan.setPenalty(0.0);
//
//        loanRepository.save(loan);
//
//        return mapToDTO(loan);
//    }
//
//    @Override
//    public LoanResponseDTO returnBook(Long loanId) {
//
//        Loan loan = loanRepository.findById(loanId)
//                .orElseThrow(() -> new RuntimeException("Loan not found"));
//
//        Book book = loan.getBook();
//
//        book.setAvailableQuantity(book.getAvailableQuantity() + 1);
//        bookRepository.save(book);
//
//        if (LocalDate.now().isAfter(loan.getExpectedReturnDate())) {
//
//            long daysLate = LocalDate.now()
//                    .toEpochDay() - loan.getExpectedReturnDate().toEpochDay();
//
//            loan.setPenalty(daysLate * 1.0);
//        }
//
//        loan.setStatus(LoanStatus.valueOf("RETURNED"));
//
//        loanRepository.save(loan);
//
//        return mapToDTO(loan);
//    }
//
//    @Override
//    public LoanResponseDTO extendLoan(Long loanId) {
//
//        Loan loan = loanRepository.findById(loanId)
//                .orElseThrow(() -> new RuntimeException("Loan not found"));
//
//        loan.setExpectedReturnDate(
//                loan.getExpectedReturnDate().plusDays(7)
//        );
//
//        loanRepository.save(loan);
//
//        return mapToDTO(loan);
//    }
//
//    @Override
//    public List<LoanResponseDTO> getAllLoans() {
//
//        return loanRepository.findAll()
//                .stream()
//                .map(this::mapToDTO)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public LoanResponseDTO getLoanById(Long id) {
//
//        Loan loan = loanRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Loan not found"));
//
//        return mapToDTO(loan);
//    }
//
//    @Override
//    public void deleteLoan(Long id) {
//
//        loanRepository.deleteById(id);
//    }
//
//    private LoanResponseDTO mapToDTO(Loan loan) {
//
//        LoanResponseDTO dto = new LoanResponseDTO();
//
//        dto.setId(loan.getId());
//        dto.setUserName(loan.getUser().getName());
//        dto.setBookTitle(loan.getBook().getTitle());
//        dto.setLoanDate(loan.getLoanDate());
//        dto.setExpectedReturnDate(loan.getExpectedReturnDate());
//        dto.setStatus(loan.getStatus());
//        dto.setPenalty(loan.getPenalty());
//
//        return dto;
//    }
//}




import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projet.backend.dto.LoanResponseDTO;
import com.projet.backend.exception.BookNotAvailableException;
import com.projet.backend.exception.ResourceNotFoundException;
import com.projet.backend.model.Book;
import com.projet.backend.model.Loan;
import com.projet.backend.model.LoanStatus;
import com.projet.backend.model.User;
import com.projet.backend.repository.BookRepository;
import com.projet.backend.repository.LoanRepository;
import com.projet.backend.repository.UserRepository;
import com.projet.backend.service.LoanService;

@Service
@Transactional
public class LoanServiceImpl implements LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public LoanResponseDTO borrowBook(Long userId, Long bookId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + bookId));

        if (book.getAvailableQuantity() <= 0) {
            throw new BookNotAvailableException("Book '" + book.getTitle() + "' is not available");
        }

        Loan loan = new Loan(user, book, LocalDate.now(), LocalDate.now().plusWeeks(2), LoanStatus.EN_COURS, 0.0);
        book.setAvailableQuantity(book.getAvailableQuantity() - 1);
        bookRepository.save(book);

        Loan savedLoan = loanRepository.save(loan);
        return new LoanResponseDTO(savedLoan);
    }

    @Override
    public LoanResponseDTO returnBook(Long loanId) {
        Loan loan = loanRepository.findById(loanId)
                .orElseThrow(() -> new ResourceNotFoundException("Loan not found with id: " + loanId));

        Book book = loan.getBook();
        book.setAvailableQuantity(book.getAvailableQuantity() + 1);
        loan.setStatus(LoanStatus.RETOURNE);
        loanRepository.save(loan);
        bookRepository.save(book);

        return new LoanResponseDTO(loan);
    }

    @Override
    public LoanResponseDTO extendLoan(Long loanId, int additionalDays) {
        Loan loan = loanRepository.findById(loanId)
                .orElseThrow(() -> new ResourceNotFoundException("Loan not found with id: " + loanId));

        loan.setExpectedReturnDate(loan.getExpectedReturnDate().plusDays(additionalDays));
        loanRepository.save(loan);
        return new LoanResponseDTO(loan);
    }

    @Override
    public List<LoanResponseDTO> getUserLoans(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
        return loanRepository.findByUser(user).stream()
                .map(LoanResponseDTO::new)
                .collect(Collectors.toList());
    }
}