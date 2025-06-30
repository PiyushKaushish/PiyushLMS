package LMS;

import java.util.*;

public class LendingProcess {
    private Set<Integer> borrowedBookIds = new HashSet<>();
    private List<Books> allBooks = new ArrayList<>();

    // Optional: Register books (if not already managed centrally)
    public void registerBooks(List<Books> books) {
        allBooks.addAll(books);
    }

    public void checkoutBook(Patron patron, Books book) {
        if (borrowedBookIds.contains(book.getID())) {
            System.out.println("Book already borrowed: " + book.getTitle());
            return;
        }
        patron.borrowBook(book);
        borrowedBookIds.add(book.getID());
        System.out.println("Book '" + book.getTitle() + "' issued to " + patron.getName());
    }

    public void returnBook(Patron patron, Books book) {
        if (!borrowedBookIds.contains(book.getID())) {
            System.out.println("Book not currently borrowed: " + book.getTitle());
            return;
        }

        if (patron.getBorrowedBooks().removeIf(b -> b.getID() == book.getID())) {
            borrowedBookIds.remove(book.getID());
            System.out.println("✅ Book '" + book.getTitle() + "' returned by " + patron.getName());
        } else {
            System.out.println("Book not found in " + patron.getName() + "'s borrowed list.");
        }
    }


    public void displayInventory() {
        System.out.println("\n--- Inventory Status ---");
        for (Books book : allBooks) {
            String status = borrowedBookIds.contains(book.getID()) ? "Borrowed" : "Available";
            System.out.println("[" + status + "] " + book.getTitle() + " by " + book.getAuthor());
        }
    }

    public List<Books> getAvailableBooks() {
        List<Books> available = new ArrayList<>();
        for (Books book : allBooks) {
            if (!borrowedBookIds.contains(book.getID())) {
                available.add(book);
            }
        }
        return available;
    }

    public List<Books> getBorrowedBooks() {
        List<Books> borrowed = new ArrayList<>();
        for (Books book : allBooks) {
            if (borrowedBookIds.contains(book.getID())) {
                borrowed.add(book);
            }
        }
        return borrowed;
    }
}
