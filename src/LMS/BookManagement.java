package LMS;

import java.util.List;
import java.util.Set;

public class BookManagement {
    private List<Shelves> ShelvesList;

    public BookManagement(List<Shelves> ShelvesList) {
        this.ShelvesList = ShelvesList;
    }

    public List<Shelves> getShelvesList() {
        return ShelvesList;
    }
    public void setShelvesList(List<Shelves> shelvesList) {
        ShelvesList = shelvesList;
    }
    public void addShelf(Shelves shelf) {
        ShelvesList.add(shelf);
    }
    public void removeShelf(Shelves shelf) {
        ShelvesList.remove(shelf);
    }
    public Shelves findShelfById(int id) {
        for (Shelves shelf : ShelvesList) {
            if (shelf.getID() == id) {
                return shelf;
            }
        }
        return null;
    }
    public void displayAllShelves() {
        for (Shelves shelf : ShelvesList) {
            System.out.println("Shelf ID: " + shelf.getID() + ", Location: " + shelf.getLocation());
            System.out.println("Available Spots: " + shelf.getAvailableSpots() + ", Total Spots: " + shelf.getTotalSpots());
        }
    }

    public void addBook(Books book, Shelves shelf) {
        if (shelf.getAvailableSpots() <= 0) {
            System.out.println("No available spots in the specified shelf.");
            return;
        }

        SpotType requiredSpotType = book.getSpotType();

        Set<BookSpot> matchingSpots = shelf.getBookMap().get(requiredSpotType);
        if (matchingSpots == null) {
            System.out.println("No spots of type " + requiredSpotType + " in the shelf.");
            return;
        }

        for (BookSpot spot : matchingSpots) {
            if (!spot.isOccupied()) {
                spot.addBook(book);
                System.out.println("Book added to shelf ID: " + shelf.getID() + ", Spot ID: " + spot.getID());
                return;
            }
        }

        System.out.println("No available unoccupied spots of required type in the shelf.");
    }

    public void removeBook(Books book, Shelves shelf) {
        SpotType requiredSpotType = book.getSpotType();

        Set<BookSpot> matchingSpots = shelf.getBookMap().get(requiredSpotType);
        if (matchingSpots == null) {
            System.out.println("No spots of type " + requiredSpotType + " in the shelf.");
            return;
        }

        for (BookSpot spot : matchingSpots) {
            if (spot.isOccupied() && spot.getBook().getID() == book.getID()) {
                spot.removeBook();
                System.out.println("Book removed from shelf ID: " + shelf.getID() + ", Spot ID: " + spot.getID());
                return;
            }
        }

        System.out.println("Book not found on the shelf.");
    }

    public void updateBook(Books updatedBook, Shelves shelf) {
        int bookID = updatedBook.getID();


        for (Set<BookSpot> spotSet : shelf.getBookMap().values()) {
            for (BookSpot spot : spotSet) {
                if (spot.isOccupied() && spot.getBook().getID() == bookID) {
                    Books oldBook = spot.getBook();
                    SpotType oldSpotType = oldBook.getSpotType();
                    SpotType newSpotType = updatedBook.getSpotType();


                    if (oldSpotType == newSpotType) {
                        spot.setBook(updatedBook);
                        System.out.println("Book updated in-place at Spot ID: " + spot.getID());
                        return;
                    }


                    spot.removeBook();
                    System.out.println("Book type changed, removed from Spot ID: " + spot.getID());


                    Set<BookSpot> newSpots = shelf.getBookMap().get(newSpotType);
                    if (newSpots != null) {
                        for (BookSpot newSpot : newSpots) {
                            if (!newSpot.isOccupied()) {
                                newSpot.addBook(updatedBook);
                                System.out.println("Book re-added to new Spot ID: " + newSpot.getID());
                                return;
                            }
                        }
                    }

                    System.out.println("No available spot found for updated book type.");
                    return;
                }
            }
        }

        System.out.println("Book not found on the shelf.");
    }

    public void searchBooks(Shelves shelf, String keyword) {
        boolean found = false;
        String lowerKeyword = keyword.toLowerCase();

        for (Set<BookSpot> spotSet : shelf.getBookMap().values()) {
            for (BookSpot spot : spotSet) {
                if (spot.isOccupied()) {
                    Books book = spot.getBook();

                    String title = book.getTitle().toLowerCase();
                    String author = book.getAuthor().toLowerCase();
                    String isbnStr = String.valueOf(book.getISBN());

                    if (title.contains(lowerKeyword) || author.contains(lowerKeyword) || isbnStr.contains(lowerKeyword)) {
                        System.out.println("Book found at Spot ID: " + spot.getID() + ", Shelf ID: " + shelf.getID());
                        book.display();
                        found = true;
                    }
                }
            }
        }

        if (!found) {
            System.out.println("No books found matching: " + keyword);
        }
    }

}
