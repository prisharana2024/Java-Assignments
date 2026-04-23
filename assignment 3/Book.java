public class Book {

    public String title;
    public double price;
    public String genre;
    public String author;
    public String ISBN;
    public int pages;
    public int chapters;
    public int wordcount;

    // Default Constructor
    public Book() {
        title = "Default";
        price = 230;
        genre = "fiction";
        author = "Unknown";
        ISBN = "0000000000000";
        pages = 0;
        chapters = 0;
        wordcount = 0;
    }

    // Parameterized Constructor
    public Book(String t, double p, String i, String g,
                int pg, int ch, int wc)
            throws InvalidBookException {

        // 🔹 Title validation
        if (t == null || t.trim().isEmpty()) {
            throw new InvalidBookException("Title cannot be null or empty.");
        }

        // 🔹 Price validation
        if (p < 0) {
            throw new InvalidBookException("Price can't be negative.");
        }

        // 🔹 Genre null validation
        if (g == null || g.trim().isEmpty()) {
            throw new InvalidBookException("Genre cannot be null or empty.");
        }

        // 🔹 Allowed genre validation
        if (!g.equalsIgnoreCase("fiction") &&
            !g.equalsIgnoreCase("autobiography") &&
            !g.equalsIgnoreCase("fantasy")) {

            throw new InvalidBookException(
                "Genre must be fiction, autobiography or fantasy.");
        }

        title = t;
        price = p;
        ISBN = i;
        genre = g;
        pages = pg;
        chapters = ch;
        wordcount = wc;
    }

    // Copy Constructor
    public Book(Book b) {
        title = b.title;
        price = b.price;
        genre = b.genre;
        author = b.author;
        ISBN = b.ISBN;
        pages = b.pages;
        chapters = b.chapters;
        wordcount = b.wordcount;
    }
}
