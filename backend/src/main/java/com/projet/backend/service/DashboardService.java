package com.projet.backend.service;

import com.projet.backend.dto.DashboardDTO;
import com.projet.backend.repository.LoanRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class DashboardService {

    @Autowired
    private LoanRepository loanRepository;

    public DashboardDTO getDashboardStats() {
        DashboardDTO dto = new DashboardDTO();

        // Top livres
        List<DashboardDTO.BookStats> topBooks = loanRepository.findTopBooks().stream()
                .map(obj -> {
                    DashboardDTO.BookStats bs = new DashboardDTO.BookStats();
                    bs.setTitle((String) obj[0]);
                    bs.setCount((Long) obj[1]);
                    return bs;
                }).toList();
        dto.setTopBooks(topBooks);

        // Retardataires
        List<DashboardDTO.OverdueStats> overdue = loanRepository.findOverdueLoans().stream()
                .map(obj -> {
                    DashboardDTO.OverdueStats os = new DashboardDTO.OverdueStats();
                    os.setUserName((String) obj[0]);
                    os.setExpectedReturnDate((java.time.LocalDate) obj[1]);
                    return os;
                }).toList();
        dto.setOverdueUsers(overdue);

        // Emprunts actifs
        dto.setActiveLoans(loanRepository.countActiveLoans());

        return dto;
    }
}