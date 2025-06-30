package LMS;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Step 1: Create the BookManagement system
        BookManagement bookManager = new BookManagement(new ArrayList<>());

        // Step 2: Create some BookSpots
        BookSpot spot1 = new BookSpot(101, SpotType.UPPER_LEVEL);
        BookSpot spot2 = new BookSpot(102, SpotType.LOWER_LEVEL);
        BookSpot spot3 = new BookSpot(103, SpotType.MIDDLE_LEVEL);
        BookSpot spot4 = new BookSpot(104, SpotType.UPPER_LEVEL);

        // Step 3: Group BookSpots by SpotType
        Map<SpotType, Set<BookSpot>> bookMap = new HashMap<>();
        bookMap.put(SpotType.UPPER_LEVEL, new HashSet<>(Arrays.asList(spot1, spot4)));
        bookMap.put(SpotType.LOWER_LEVEL, new HashSet<>(Collections.singletonList(spot2)));
        bookMap.put(SpotType.MIDDLE_LEVEL, new HashSet<>(Collections.singletonList(spot3)));

        // Step 4: Create a Shelf and register it with BookManagement
        Shelves shelf = new Shelves(1, Location.FIRST_ROW, bookMap);
        shelf.setBookMap(bookMap);
        bookManager.addShelf(shelf);

        // Step 5: Create Books
        Books book1 = new Books(1, "Isaac Asimov", 9780, "Foundation", 1951, BookType.SCIENCE);
        Books book2 = new Books(2, "Agatha Christie", 9781, "Murder on the Orient Express", 1934, BookType.MYSTERY);
        Books book3 = new Books(3, "J.K. Rowling", 9782, "Harry Potter", 1997, BookType.FANTASY);
        Books book4 = new Books(4, "Yuval Noah Harari", 9783, "Sapiens", 2011, BookType.NON_FICTION);

        List<Books> allBooks = List.of(book1, book2, book3, book4);

        // Step 6: Add Books to Shelf
        System.out.println("\n--- Adding Books ---");
        bookManager.addBook(book1, shelf);
        bookManager.addBook(book2, shelf);
        bookManager.addBook(book3, shelf);
        bookManager.addBook(book4, shelf);

        // Step 7: Search Books
        System.out.println("\n--- Searching for 'Harry' ---");
        bookManager.searchBooks(shelf, "Harry");

        System.out.println("\n--- Searching for 'Christie' ---");
        bookManager.searchBooks(shelf, "Christie");

        System.out.println("\n--- Searching by ISBN '978045' ---");
        bookManager.searchBooks(shelf, "978045");

        // Step 8: Update Book
        System.out.println("\n--- Updating Book (Harry Potter -> SCIENCE) ---");
        Books updatedBook3 = new Books(3, "J.K. Rowling", 9784, "Harry Potter - Updated", 1998, BookType.SCIENCE);
        bookManager.updateBook(updatedBook3, shelf);

        System.out.println("\n--- Removing Book: Foundation ---");
        bookManager.removeBook(book1, shelf);

        System.out.println("\n--- Final Shelf Status ---");
        bookManager.displayAllShelves();

        // Step 9: Lending & Patron Management Setup
        LendingProcess lendingService = new LendingProcess();
        lendingService.registerBooks(allBooks);  // Register books in inventory

        PatronManagement patronManager = new PatronManagement(new ArrayList<>(), lendingService);

        Patron patron1 = new Patron(1, "Alice", "alice@example.com", "1234567890");
        Patron patron2 = new Patron(2, "Bob", "bob@example.com", "9876543210");

        patronManager.addPatron(patron1);
        patronManager.addPatron(patron2);

        // Step 10: Patrons borrow books using LendingService
        System.out.println("\n--- Patrons Borrowing ---");
        patronManager.checkoutBook(patron1, book2);
        patronManager.checkoutBook(patron1, updatedBook3);
        patronManager.checkoutBook(patron2, book4);

        // Step 11: View Borrowing History
        System.out.println("\n--- Borrowing History for Alice ---");
        patronManager.TrackBorrowedBooks(patron1);

        System.out.println("\n--- Borrowing History for Bob ---");
        patronManager.TrackBorrowedBooks(patron2);

        // Step 12: View Available and Borrowed Books from PatronManagement
        System.out.println("\n--- Available Books ---");
        patronManager.viewAvailableBooks();

        System.out.println("\n--- Borrowed Books ---");
        patronManager.viewBorrowedBooks();

        // Step 13: Return a Book
        System.out.println("\n--- Returning Book: Harry Potter - Updated ---");
        patronManager.returnBook(patron1, updatedBook3);

        // Step 14: Final Borrowing Status
        System.out.println("\n--- Updated Borrowing History for Alice ---");
        patronManager.TrackBorrowedBooks(patron1);

        System.out.println("\n--- Final Available Books ---");
        patronManager.viewAvailableBooks();
    }
}
