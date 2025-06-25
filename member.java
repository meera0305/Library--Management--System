import java.sql.*;
import java.util.Scanner;

public class Member {
    Scanner sc = new Scanner(System.in);

    public void addMember() {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "INSERT INTO members(name, email) VALUES (?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            System.out.print("Enter name: ");
            pst.setString(1, sc.nextLine());
            System.out.print("Enter email: ");
            pst.setString(2, sc.nextLine());
            pst.executeUpdate();
            System.out.println("Member added.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewMembers() {
        try (Connection con = DBConnection.getConnection()) {
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM members");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                                   ", Name: " + rs.getString("name") +
                                   ", Email: " + rs.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
