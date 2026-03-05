package com.projet.backend.dto;

import java.time.LocalDate;
import java.util.List;

public class DashboardDTO {

    private List<BookStats> topBooks;
    private List<OverdueStats> overdueUsers;
    private Long activeLoans;

    // Getters et setters pour DashboardDTO
    public List<BookStats> getTopBooks() {
        return topBooks;
    }

    public void setTopBooks(List<BookStats> topBooks) {
        this.topBooks = topBooks;
    }

    public List<OverdueStats> getOverdueUsers() {
        return overdueUsers;
    }

    public void setOverdueUsers(List<OverdueStats> overdueUsers) {
        this.overdueUsers = overdueUsers;
    }

    public Long getActiveLoans() {
        return activeLoans;
    }

    public void setActiveLoans(Long activeLoans) {
        this.activeLoans = activeLoans;
    }

    // Classe interne pour les stats des livres
    public static class BookStats {
        private String title;
        private Long count;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Long getCount() {
            return count;
        }

        public void setCount(Long count) {
            this.count = count;
        }
    }

    // Classe interne pour les retardataires
    public static class OverdueStats {
        private String userName;
        private LocalDate expectedReturnDate;

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public LocalDate getExpectedReturnDate() {
            return expectedReturnDate;
        }

        public void setExpectedReturnDate(LocalDate expectedReturnDate) {
            this.expectedReturnDate = expectedReturnDate;
        }
    }
}