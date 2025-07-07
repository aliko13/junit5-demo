package org.example.service;

import org.example.model.Book;
import java.util.List;
import java.util.stream.Collectors;

public class LibraryService {
    public List<Book> listAvailableBooks(List<Book> books) {
        return books.stream()
                .filter(Book::isAvailable)
                .sorted((a, b) -> a.getTitle().compareToIgnoreCase(b.getTitle()))
                .collect(Collectors.toList());
    }

    public List<Book> findBooksByAuthor(List<Book> books, String author) {
        return books.stream()
                .filter(b -> b.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    public double totalAvailableBooksValue(List<Book> books) {
        return books.stream()
                .filter(Book::isAvailable)
                .mapToDouble(Book::getPrice)
                .sum();
    }
}
