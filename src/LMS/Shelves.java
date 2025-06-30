package LMS;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Shelves {
    private int ID;
    private Location location;
    private Map<SpotType , Set<BookSpot>> bookMap;


    public Shelves(int ID, Location location, Map<SpotType, Set<BookSpot>> bookMap) {
        this.ID = ID;
        this.location = location;
        this.bookMap = new HashMap<>();
    }


    public Map<SpotType, Set<BookSpot>> getBookMap() {
        return bookMap;
    }

    public void setBookMap(Map<SpotType, Set<BookSpot>> bookMap) {
        this.bookMap = bookMap;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getAvailableSpots() {
        int availableSpots = 0;
        for (Set<BookSpot> spots : bookMap.values()) {
            for (BookSpot spot : spots) {
                if (!spot.isOccupied()) {
                    availableSpots++;
                }
            }
        }
        return availableSpots;
    }

    public int getTotalSpots() {
        int totalSpots = 0;
        for (Set<BookSpot> spots : bookMap.values()) {
            totalSpots += spots.size();
        }
        return totalSpots;
    }






}
