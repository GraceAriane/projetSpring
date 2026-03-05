package com.projet.backend.repository;

import com.projet.backend.model.Book;
import com.projet.backend.model.Loan;
import com.projet.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
//
    List<Loan> findByUser(User user);

//    top des livres les plus empruntés.
    @Query("SELECT l.book.title, COUNT(l) as total " +
            "FROM Loan l " +
            "GROUP BY l.book.id " +
            "ORDER BY total DESC")
    List<Object[]> findTopBooks();

//    liste des retardataires.
    @Query("SELECT l.user.name, l.expectedReturnDate " +
            "FROM Loan l " +
            "WHERE l.status = 'ACTIVE' AND l.expectedReturnDate < CURRENT_DATE")
    List<Object[]> findOverdueLoans();

//    nombre d’emprunts actifs.
    @Query("SELECT COUNT(l) FROM Loan l WHERE l.status = 'ACTIVE'")
    Long countActiveLoans();
}
