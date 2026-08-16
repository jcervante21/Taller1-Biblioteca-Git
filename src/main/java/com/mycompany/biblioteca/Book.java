package com.mycompany.biblioteca;

public class Book extends Item {
    private String author;
    private boolean available;

    public Book(String code, String title, String publicationYear, String author) {
        super(code, title, publicationYear);
        this.author = author;
        this.available = true; // A new book starts as available
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return super.toString() + " | Author: " + author + " | Available: " + available;
    }
}