package com.mycompany.biblioteca;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Customer> customers = new ArrayList<>();
    static ArrayList<Book> books = new ArrayList<>();
    static ArrayList<Loan> loans = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Menu will go here (Phase 8)
    }

    // ===== CUSTOMER =====

    // CREATE
    public static void createCustomer() {
        System.out.println("--- Create Customer ---");
        System.out.print("ID: ");
        String id = sc.nextLine();
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Phone: ");
        String phone = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();

        Customer customer = new Customer(id, name, phone, email);
        customers.add(customer);
        System.out.println("Customer created successfully.");
    }

    // READ - list all
    public static void listCustomers() {
        System.out.println("--- Customer List ---");
        if (customers.isEmpty()) {
            System.out.println("No customers registered.");
            return;
        }
        for (Customer c : customers) {
            System.out.println(c);
        }
    }

    // READ - search by id
    public static Customer searchCustomer(String id) {
        for (Customer c : customers) {
            if (c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    }

    // UPDATE
    public static void updateCustomer() {
        System.out.println("--- Update Customer ---");
        System.out.print("Enter the ID of the customer to update: ");
        String id = sc.nextLine();

        Customer customer = searchCustomer(id);
        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }

        System.out.print("New name (current: " + customer.getName() + "): ");
        String name = sc.nextLine();
        System.out.print("New phone (current: " + customer.getPhone() + "): ");
        String phone = sc.nextLine();
        System.out.print("New email (current: " + customer.getEmail() + "): ");
        String email = sc.nextLine();

        customer.setName(name);
        customer.setPhone(phone);
        customer.setEmail(email);
        System.out.println("Customer updated successfully.");
    }

    // DELETE
    public static void deleteCustomer() {
        System.out.println("--- Delete Customer ---");
        System.out.print("Enter the ID of the customer to delete: ");
        String id = sc.nextLine();

        Customer customer = searchCustomer(id);
        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }

        customers.remove(customer);
        System.out.println("Customer deleted successfully.");
    }

    // ===== BOOK =====

    // CREATE
    public static void createBook() {
        System.out.println("--- Create Book ---");
        System.out.print("Code: ");
        String code = sc.nextLine();
        System.out.print("Title: ");
        String title = sc.nextLine();
        System.out.print("Publication Year: ");
        String publicationYear = sc.nextLine();
        System.out.print("Author: ");
        String author = sc.nextLine();

        Book book = new Book(code, title, publicationYear, author);
        books.add(book);
        System.out.println("Book created successfully.");
    }

    // READ - list all
    public static void listBooks() {
        System.out.println("--- Book List ---");
        if (books.isEmpty()) {
            System.out.println("No books registered.");
            return;
        }
        for (Book b : books) {
            System.out.println(b);
        }
    }

    // READ - search by code
    public static Book searchBook(String code) {
        for (Book b : books) {
            if (b.getCode().equals(code)) {
                return b;
            }
        }
        return null;
    }

    // UPDATE
    public static void updateBook() {
        System.out.println("--- Update Book ---");
        System.out.print("Enter the code of the book to update: ");
        String code = sc.nextLine();

        Book book = searchBook(code);
        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        System.out.print("New title (current: " + book.getTitle() + "): ");
        String title = sc.nextLine();
        System.out.print("New publication year (current: " + book.getPublicationYear() + "): ");
        String publicationYear = sc.nextLine();
        System.out.print("New author (current: " + book.getAuthor() + "): ");
        String author = sc.nextLine();

        book.setTitle(title);
        book.setPublicationYear(publicationYear);
        book.setAuthor(author);
        System.out.println("Book updated successfully.");
    }

    // DELETE
    public static void deleteBook() {
        System.out.println("--- Delete Book ---");
        System.out.print("Enter the code of the book to delete: ");
        String code = sc.nextLine();

        Book book = searchBook(code);
        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        books.remove(book);
        System.out.println("Book deleted successfully.");
    }

    // ===== LOAN =====

    // Register a new loan
    public static void createLoan() {
        System.out.println("--- Register Loan ---");
        System.out.print("Loan ID: ");
        String loanId = sc.nextLine();
        System.out.print("Customer ID: ");
        String customerId = sc.nextLine();
        System.out.print("Book code: ");
        String bookCode = sc.nextLine();

        Customer customer = searchCustomer(customerId);
        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }

        Book book = searchBook(bookCode);
        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        if (!book.isAvailable()) {
            System.out.println("This book is not available for loan.");
            return;
        }

        Loan loan = new Loan(loanId, customer, book, LocalDate.now(), "ACTIVE");
        loans.add(loan);
        book.setAvailable(false);
        System.out.println("Loan registered successfully.");
    }

    // Return a loan
    public static void returnLoan() {
        System.out.println("--- Return Loan ---");
        System.out.print("Loan ID: ");
        String loanId = sc.nextLine();

        Loan loan = null;
        for (Loan l : loans) {
            if (l.getLoanId().equals(loanId)) {
                loan = l;
                break;
            }
        }

        if (loan == null) {
            System.out.println("Loan not found.");
            return;
        }

        if (loan.getStatus().equals("RETURNED")) {
            System.out.println("This loan was already returned.");
            return;
        }

        loan.setStatus("RETURNED");
        loan.getBook().setAvailable(true);
        System.out.println("Book returned successfully.");
    }

    // List active loans
    public static void listActiveLoans() {
        System.out.println("--- Active Loans ---");
        boolean found = false;
        for (Loan l : loans) {
            if (l.getStatus().equals("ACTIVE")) {
                System.out.println(l);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No active loans.");
        }
    }
}