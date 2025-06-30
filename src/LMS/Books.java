package LMS;

public class Books {
        private int ID;
        private String Author;
        private int ISBN;
        private String Title;
        private int Year;
        private BookType BookType;

        public Books(int ID, String Author, int ISBN, String Title,int Year, BookType BookType) {
            this.ID = ID;
            this.Author = Author;
            this.ISBN = ISBN;
            this.Title = Title;
            this.Year = Year;
            this.BookType = BookType;
        }

        public void display() {
            System.out.println("Book ID: " + ID);
            System.out.println("Author ID: " + Author);
            System.out.println("ISBN: " + ISBN);
            System.out.println("Title ID: " + Title);
            System.out.println("Year: " + Year);
            System.out.println("Book Type: " + BookType);
        }

        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public String getAuthor() {
            return Author;
        }

        public void setAuthor(String author) {
            this.Author = author;
        }

        public int getISBN() {
            return ISBN;
        }

        public void setISBN(int ISBN) {
            this.ISBN = ISBN;
        }

        public String getTitle() {
            return Title;
        }

        public void setTitle(String title) {
            this.Title = title;
        }

        public int getYear() {
            return Year;
        }

        public void setYear(int year) {
            this.Year = year;
        }

        public BookType getBookType() {
            return BookType;
        }

        public void setBookType(BookType bookType) {
            this.BookType = bookType;
        }

        public SpotType getSpotType() {
            return this.BookType.getSpotType();
        }


}


