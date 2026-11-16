
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Book> books = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Display Available Books");
            System.out.println("4. Search Book");
            System.out.println("5. Issue Book");
            System.out.println("6. Return Book");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addBook();
                    break;

                case 2:
                    removeBook();
                    break;

                case 3:
                    displayBooks();
                    break;

                case 4:
                    searchBook();
                    break;

                case 5:
                    issueBook();
                    break;

                case 6:
                    returnBook();
                    break;

                case 7:
                    System.out.println("Thank you for using the Library System!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 7);

        sc.close();
    }

    // Add a new book
    static void addBook() {

        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Book book : books) {
            if (book.id == id) {
                System.out.println("Book ID already exists!");
                return;
            }
        }

        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author Name: ");
        String author = sc.nextLine();

        Book book = new Book(id, title, author);
        books.add(book);

        System.out.println("Book added successfully!");
    }

    // Remove a book
    static void removeBook() {

        System.out.print("Enter Book ID to remove: ");
        int id = sc.nextInt();

        for (Book book : books) {

            if (book.id == id) {

                if (book.isIssued) {
                    System.out.println("Cannot remove an issued book. Return it first!");
                    return;
                }

                books.remove(book);
                System.out.println("Book removed successfully!");
                return;
            }
        }

        System.out.println("Book not found!");
    }

    // Display available books
    static void displayBooks() {

        boolean found = false;

        for (Book book : books) {

            if (!book.isIssued) {
                book.displayDetails();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No available books found!");
        }
    }

    // Search book by ID or title
    static void searchBook() {

        System.out.println("1. Search by ID");
        System.out.println("2. Search by Title");
        System.out.print("Enter your choice: ");

        int choice = sc.nextInt();
        sc.nextLine();

        boolean found = false;

        if (choice == 1) {

            System.out.print("Enter Book ID: ");
            int id = sc.nextInt();

            for (Book book : books) {
                if (book.id == id) {
                    book.displayDetails();
                    found = true;
                    break;
                }
            }

        } else if (choice == 2) {

            System.out.print("Enter Book Title: ");
            String title = sc.nextLine();

            for (Book book : books) {
                if (book.title.equalsIgnoreCase(title)) {
                    book.displayDetails();
                    found = true;
                }
            }

        } else {
            System.out.println("Invalid search option!");
            return;
        }

        if (!found) {
            System.out.println("Book not found!");
        }
    }

    // Issue a book
    static void issueBook() {

        System.out.print("Enter Book ID to issue: ");
        int id = sc.nextInt();

        for (Book book : books) {

            if (book.id == id) {

                if (book.isIssued) {
                    System.out.println("Book is already issued!");
                } else {
                    book.isIssued = true;
                    System.out.println("Book issued successfully!");
                }

                return;
            }
        }

        System.out.println("Book not found!");
    }

    // Return a book
    static void returnBook() {

        System.out.print("Enter Book ID to return: ");
        int id = sc.nextInt();

        for (Book book : books) {

            if (book.id == id) {

                if (!book.isIssued) {
                    System.out.println("This book has not been issued!");
                } else {
                    book.isIssued = false;
                    System.out.println("Book returned successfully!");
                }

                return;
            }
        }

        System.out.println("Book not found!");
    }
}
