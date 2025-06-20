// File: LibraryMain.java

import java.util.Scanner;

public class LibraryMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Delete Book");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    LibraryOperations.addBook(new Book(id, title, author));
                    break;
                case 2:
                    LibraryOperations.viewBooks();
                    break;
                case 3:
                    System.out.print("Enter Book ID to Delete: ");
                    int delId = sc.nextInt();
                    LibraryOperations.deleteBook(delId);
                    break;
                case 4:
                    System.out.println("Thank you for using the Library System!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);
    }
}
