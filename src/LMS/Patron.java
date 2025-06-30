package LMS;

import java.util.ArrayList;
import java.util.List;

public class Patron {


    private int ID;
    private String name;
    private String email;
    private String phoneNumber;

    private List<Books> borrowedBooks;
    public Patron(int ID, String name, String email, String phoneNumber) {
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.borrowedBooks = new ArrayList<>();
    }
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public List<Books> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(List<Books> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public void displayPatronInfo() {
        System.out.println("Patron ID: " + ID);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone Number: " + phoneNumber);

    }

    public void borrowBook(Books book) {
        borrowedBooks.add(book);
        System.out.println(this.name + " borrowed book: " + book.getTitle());
    }

    public void displayHistory() {
        System.out.println("Borrowing History for " + name + ":");
        if (borrowedBooks.isEmpty()) {
            System.out.println("No books borrowed yet.");
        } else {
            for (Books book : borrowedBooks) {
                System.out.println("- " + book.getTitle());
            }
        }
    }





}
