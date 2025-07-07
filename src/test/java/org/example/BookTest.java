package org.example;

import org.example.model.Book;
import org.example.service.LibraryService;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("📚 Library Service Tests")
class BookTest {

    private LibraryService service;

    @BeforeEach
    void init() {
        service = new LibraryService();
    }

    @Test
    @DisplayName("Should calculate total value of available books")
    void testTotalValueOfAvailableBooks() {
        var books = List.of(
                new Book("Java", "Ali", 30, true),
                new Book("C++", "Sara", 40, false),
                new Book("Kotlin", "Ali", 20, true)
        );

        double total = service.totalAvailableBooksValue(books);

        assertEquals(50.0, total, 0.001);
    }

    @Test
    @DisplayName("Should throw exception for negative book price")
    void testNegativePrice() {
        assertThrows(IllegalArgumentException.class, () ->
                new Book("Invalid", "Someone", -5.0, true)
        );
    }

    @Nested
    @DisplayName("📖 Book Author Tests")
    class BookAuthorTests {

        @Test
        @DisplayName("Should find books by given author")
        void testFindBooksByAuthor() {
            var books = List.of(
                    new Book("A", "Ali", 10, true),
                    new Book("B", "Sara", 15, true),
                    new Book("C", "Ali", 20, false)
            );

            var results = service.findBooksByAuthor(books, "Ali");

            assertIterableEquals(
                    List.of(books.get(0), books.get(2)),
                    results
            );
        }
    }
}
