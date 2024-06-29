package com.library;

import java.util.List;
import java.util.Scanner;

public class LibraryMenu {
    private Library library;

    public LibraryMenu(Library library) {
        this.library = library;
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Library Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Find Book by Title");
            System.out.println("4. Find Book by Author");
            System.out.println("5. List All Books");
            System.out.println("6. List Available Books");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    addBookMenu(scanner);
                    break;
                case 2:
                    removeBookMenu(scanner);
                    break;
                case 3:
                    findBookByTitleMenu(scanner);
                    break;
                case 4:
                    findBookByAuthorMenu(scanner);
                    break;
                case 5:
                    listAllBooksMenu();
                    break;
                case 6:
                    listAvailableBooksMenu();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addBookMenu(Scanner scanner) {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter ISBN: ");
        String ISBN = scanner.nextLine();
        System.out.print("Enter genre: ");
        String genre = scanner.nextLine();
        System.out.print("Enter publication year: ");
        int publicationYear = scanner.nextInt();
        scanner.nextLine();  // consume newline
        System.out.print("Enter department: ");
        String department = scanner.nextLine();
        System.out.print("Is the book available (true/false)? ");
        boolean isAvailable = scanner.nextBoolean();

        Book book = new Book(title, author, ISBN, genre, publicationYear, department, isAvailable);
        library.addBook(book);
    }

    private void removeBookMenu(Scanner scanner) {
        System.out.print("Enter ISBN of the book to remove: ");
        String ISBN = scanner.nextLine();
        library.removeBook(ISBN);
    }

    private void findBookByTitleMenu(Scanner scanner) {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        List<Book> books = library.findBookByTitle(title);
        if (books.isEmpty()) {
            System.out.println("No books found with the title \"" + title + "\".");
        } else {
            books.forEach(book -> System.out.println(book.getTitle() + " by " + book.getAuthor()));
        }
    }

    private void findBookByAuthorMenu(Scanner scanner) {
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        List<Book> books = library.findBookByAuthor(author);
        if (books.isEmpty()) {
            System.out.println("No books found by the author \"" + author + "\".");
        } else {
            books.forEach(book -> System.out.println(book.getTitle() + " by " + book.getAuthor()));
        }
    }

    private void listAllBooksMenu() {
        List<Book> books = library.listAllBooks();
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            books.forEach(book -> System.out.println(book.getTitle() + " by " + book.getAuthor()));
        }
    }

    private void listAvailableBooksMenu() {
        List<Book> books = library.listAvailableBooks();
        if (books.isEmpty()) {
            System.out.println("No available books in the library.");
        } else {
            books.forEach(book -> System.out.println(book.getTitle() + " by " + book.getAuthor()));
        }
    }

    public static void main(String[] args) {
        Library library = new Library();
        LibraryMenu libraryMenu = new LibraryMenu(library);
        libraryMenu.displayMenu();
    }
}
