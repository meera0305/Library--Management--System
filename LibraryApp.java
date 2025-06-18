//Library Management System....
public class LibraryApp {
    public static void main(String[] args) {
        System.out.println("Welcome to Library Management System - by Meera Chavan");
        import java.util.ArrayList;
import java.util.Scanner;

// Book class
class Book {
    String title;
    String author;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String toString() {
        return "📖 Title: " + title + ",  Author: " + author;
    }
}

// Main Library class
public class LibraryApp {
    static ArrayList<Book> books = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        System.out.println("📚 Welcome to Library Management System - by Meera Chavan");

        do {
            System.out.println("\n------ MENU ------");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    viewBooks();
                    break;
                case 3:
                    System.out.println(" Exiting... Thank you!");
                    break;
                default:
                    System.out.println(" Invalid choice! Try again.");
            }
        } while (choice != 3);
    }

    // Method to add a book
    static void addBook() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();

        System.out.print("Enter author name: ");
        String author = scanner.nextLine();

        books.add(new Book(title, author));
        System.out.println("✅ Book added successfully!");
    }

    // Method to view books
    static void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("😞 No books found.");
        } else {
            System.out.println("📚 List of Books:");
            for (Book b : books) {
                System.out.println(b);
            }
        }
    }
}
        
    }
}
