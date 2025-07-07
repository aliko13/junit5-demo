package org.example.model;

public class Book {
    private final String title;
    private final String author;
    private final double price;
    private final boolean isAvailable;

    public Book(String title, String author, double price, boolean isAvailable) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.title = title;
        this.author = author;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}
