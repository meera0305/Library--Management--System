// File: LibraryOperations.java

import java.sql.*;
import java.util.*;

public class LibraryOperations {

    public static void addBook(Book book) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "INSERT INTO books (id, title, author) VALUES (?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, book.id);
            pst.setString(2, book.title);
            pst.setString(3, book.author);
            int rows = pst.executeUpdate();
            System.out.println(rows + " Book added successfully!");
        } catch (Exception e) {
            System.out.println("Add Error: " + e);
        }
    }

    public static void viewBooks() {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "SELECT * FROM books";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            System.out.println("ID | Title | Author");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " | " + rs.getString(2) + " | " + rs.getString(3));
            }
        } catch (Exception e) {
            System.out.println("View Error: " + e);
        }
    }

    public static void deleteBook(int id) { 
        try (Connection con = DBConnection.getConnection()) {
            String sql = "DELETE FROM books WHERE id = ?"; 
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);  
            int rows = pst.executeUpdate();
            if (rows > 0)
                System.out.println("Book deleted!");
            else
                System.out.println("Book not found!");
        } catch (Exception e) {
            System.out.println("Delete Error: " + e);
        }
    }
}
