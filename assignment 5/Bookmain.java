import java.util.ArrayList;

public class Bookmain {

    public static void main(String[] args) {

        ArrayList<Book> Books = new ArrayList<>();

        double totalPrice = 0.0;

        try {

            Book b1 = new Book();

            Book b2 = new Book(
                "Harry Potter PS",
                292.00,
                "232322922",
                "fantasy",
                400,
                45,
                100000
            );

            Book b3 = new Book(b2);

            Books.add(b1);
            Books.add(b2);
            Books.add(b3);

            // Try creating invalid book separately
            try {
                Book b4 = new Book(
                    "Ikigai",
                    300.00,
                    "212122121",
                    "fiction",
                    200,
                    20,
                    50000
                );
                Books.add(b4);
            } catch (InvalidBookException ib) {
                System.out.println("Exception: " + ib.getMessage());
            }

            // Print all books
            for (Book b : Books) {
                System.out.println("Title: " + b.title);
                System.out.println("Price: " + b.price);
                System.out.println("ISBN: " + b.ISBN);
                System.out.println("Genre: " + b.genre);
                System.out.println("Pages: " + b.pages);
                System.out.println("Chapters: " + b.chapters);
                System.out.println("Wordcount: " + b.wordcount);
                System.out.println("----------------------");

                totalPrice += b.price;
            }

            double averagePrice = totalPrice / Books.size();

            System.out.println("Total Price: " + totalPrice);
            System.out.println("Average Price: " + averagePrice);

            // 🔥 NEW PART: Print Fiction books using forEach()
            System.out.println("\nFiction Books:");

            Books.forEach(b -> {
                if (b.genre.equalsIgnoreCase("fiction")) {
                    System.out.println(b.title + " - " + b.price);
                }
            });

        } catch (InvalidBookException ib) {
            System.out.println("Exception: " + ib.getMessage());
        }
    }
}
