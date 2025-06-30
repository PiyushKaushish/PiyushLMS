package LMS;

import static LMS.BookType.SCIENCE;

public class BookSpot {
    private int ID;
    private SpotType spotType;
    private boolean isOccupied;
    public Books Book;

    public BookSpot(int ID, SpotType spotType) {
        this.ID = ID;
        this.spotType = spotType;
        this.isOccupied = false;
    }

    public void addBook(Books book) {
        if (this.Book == null) {
            this.Book = book;
            this.isOccupied = true;
        } else {
            System.out.println("This spot is already occupied by another book.");
        }
    }

    public void removeBook() {
        if (this.Book != null) {
            this.Book = null;
            this.isOccupied = false;
        } else {
            System.out.println("No book to remove from this spot.");
        }
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public SpotType getSpotType() {
        return spotType;
    }

    public void setSpotType(SpotType spotType) {
        this.spotType = spotType;
    }

    public Books getBook() {
        return Book;
    }

    public void setBook(Books book) {
        this.Book = book;
    }
    public boolean isOccupied() {
        return isOccupied;
    }
    public void setOccupied(boolean occupied) {
        this.isOccupied = occupied;
    }

    public void display(SpotType spotType,int ID) {

        if (Book != null) {
            Book.display();
        } else {
            System.out.println("No book assigned to this spot.");
        }
    }





}
