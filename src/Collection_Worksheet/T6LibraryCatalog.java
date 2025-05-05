package Collection_Worksheet;

import java.util.*;
// Book class is outside LibraryCatalog, and not public
class Book {
    private String title;
    private String author;
    private int publicationYear;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.publicationYear = year;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getPublicationYear() { return publicationYear; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return publicationYear == book.publicationYear &&
                Objects.equals(title, book.title) &&
                Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, publicationYear);
    }

    @Override
    public String toString() {
        return String.format("Book{title='%s', author='%s', year=%d}",
                title, author, publicationYear);
    }
}


public class T6LibraryCatalog {
    public static void main(String[] args) {
        Map<String, Set<Book>> genreMap = new HashMap<>();

        // Add books
        addBook(genreMap, "Science Fiction", new Book("Dune", "Frank Herbert", 1965));
        addBook(genreMap, "Science Fiction", new Book("Neuromancer", "William Gibson", 1984));
        addBook(genreMap, "Science Fiction", new Book("Dune", "Frank Herbert", 1965)); // Duplicate
        addBook(genreMap, "Fantasy", new Book("The Hobbit", "J.R.R. Tolkien", 1937));
        addBook(genreMap, "Fantasy", new Book("Harry Potter", "J.K. Rowling", 1997));
        addBook(genreMap, "Fantasy", new Book("The Silmarillion", "J.R.R. Tolkien", 1977));

        // Print books in genres
        printBooksByGenreSorted("Fantasy", genreMap);
        printBooksByGenreSorted("Science Fiction", genreMap);
    }

    // Add a book to a genre
    private static void addBook(Map<String, Set<Book>> genreMap, String genre, Book book) {
        genreMap.computeIfAbsent(genre, k -> new HashSet<>()).add(book);
    }

    // Print all books in a genre, sorted by year
    private static void printBooksByGenreSorted(String genre, Map<String, Set<Book>> genreMap) {
        System.out.println("\nBooks in genre: " + genre);
        Set<Book> books = genreMap.getOrDefault(genre, new HashSet<>());

        books.stream()
                .sorted(Comparator.comparingInt(Book::getPublicationYear))
                .forEach(System.out::println);
    }
}

