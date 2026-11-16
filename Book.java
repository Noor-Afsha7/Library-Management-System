
public class Book {

    int id;
    String title;
    String author;
    boolean isIssued;

    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    void displayDetails() {
        System.out.println("Book ID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);

        if (isIssued) {
            System.out.println("Status: Issued");
        } else {
            System.out.println("Status: Available");
        }

        System.out.println("-----------------------------");
    }
}
