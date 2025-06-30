package LMS;

import java.util.List;

public class PatronManagement {


    private List<Patron> patrons;
    private LendingProcess lendingProcess;


    public PatronManagement(List<Patron> patrons , LendingProcess lendingProcess) {
        this.patrons = patrons;
        this.lendingProcess = lendingProcess;
    }

    public List<Patron> getPatrons() {
        return patrons;
    }

    public void setPatrons(List<Patron> patrons) {
        this.patrons = patrons;
    }

    public void addPatron(Patron patron) {
        patrons.add(patron);
    }

    public void removePatron(Patron patron) {
        patrons.remove(patron);
    }
    public void updatePatron(Patron patron) {
        for (int i = 0; i < patrons.size(); i++) {
            if (patrons.get(i).getID() == patron.getID()) {
                patrons.set(i, patron);
                return;
            }
        }
        System.out.println("Patron not found.");
    }

    public void TrackBorrowedBooks(Patron patron){
        if (patron.getBorrowedBooks().isEmpty()) {
            System.out.println("No books borrowed by patron ID: " + patron.getID());
        } else {
            System.out.println("Books borrowed by patron ID: " + patron.getID());
            patron.displayHistory();

        }
    }

    public void checkoutBook(Patron patron, Books book) {
        lendingProcess.checkoutBook(patron, book);
    }

    public void returnBook(Patron patron, Books book) {
        lendingProcess.returnBook(patron, book);
    }

    public void viewAvailableBooks() {
        //System.out.println("\n--- Available Books ---");
        List<Books> available = lendingProcess.getAvailableBooks();
        if (available.isEmpty()) {
            System.out.println("No books currently available.");
        } else {
            for (Books book : available) {
                book.display();
            }
        }
    }

    public void viewBorrowedBooks() {
        //System.out.println("\n--- Borrowed Books ---");
        List<Books> borrowed = lendingProcess.getBorrowedBooks();
        if (borrowed.isEmpty()) {
            System.out.println("No books are currently borrowed.");
        } else {
            for (Books book : borrowed) {
                book.display();
            }
        }
    }






}
