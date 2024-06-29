package Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.library.Book;
import com.library.Library;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {
    private Library library;
    private Book book1;
    private Book book2;

    @BeforeEach
    public void setUp() {
        library = new Library();
        book1 = new Book("Title1", "Author1", "ISBN1", "Genre1", 2020, "Department1", true);
        book2 = new Book("Title2", "Author2", "ISBN2", "Genre2", 2021, "Department2", false);
        library.addBook(book1);
        library.addBook(book2);
    }

    @Test
    public void testAddBook() {
        Book book3 = new Book("Title3", "Author3", "ISBN3", "Genre3", 2022, "Department3", true);
        library.addBook(book3);
        assertEquals(3, library.listAllBooks().size());
    }

    @Test
    public void testRemoveBook() {
        library.removeBook("ISBN1");
        assertEquals(1, library.listAllBooks().size());
    }

    @Test
    public void testFindBookByTitle() {
        List<Book> books = library.findBookByTitle("Title1");
        assertEquals(1, books.size());
        assertEquals("Author1", books.get(0).getAuthor());
    }

    @Test
    public void testFindBookByAuthor() {
        List<Book> books = library.findBookByAuthor("Author2");
        assertEquals(1, books.size());
        assertEquals("Title2", books.get(0).getTitle());
    }

    @Test
    public void testListAllBooks() {
        List<Book> books = library.listAllBooks();
        assertEquals(2, books.size());
    }

    @Test
    public void testListAvailableBooks() {
        List<Book> books = library.listAvailableBooks();
        assertEquals(1, books.size());
        assertEquals("Title1", books.get(0).getTitle());
    }
}
