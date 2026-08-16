package com.mycompany.biblioteca;

import java.time.LocalDate;

public class Loan {
    private String loanId;
    private Customer customer;
    private Book book;
    private LocalDate date;
    private String status;

    public Loan(String loanId, Customer customer, Book book, LocalDate date, String status) {
        this.loanId = loanId;
        this.customer = customer;
        this.book = book;
        this.date = date;
        this.status = status;
    }

    // Getters
    public String getLoanId() {
        return loanId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Book getBook() {
        return book;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    // Setters
    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Loan ID: " + loanId
                + " | Customer: " + customer.getName()
                + " | Book: " + book.getTitle()
                + " | Date: " + date
                + " | Status: " + status;
    }
}