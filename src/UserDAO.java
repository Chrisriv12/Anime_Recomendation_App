/*
 * UserDAO.java
 * Data Access Object for user-related database operations.
 * Name: Chrisnel Rivera
 * Date: 10/30/2025
 */



import java.sql.*;

public class UserDAO {
    private final DatabaseHandler db = DatabaseHandler.getInstance();

    public int insertUser(String username, String email) {
        String sql = "INSERT INTO users(username, email) VALUES (?, ?)";
        try (Connection conn = db.connect(); PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, username);
            pstmt.setString(2, email);
            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) return rs.getInt(1);
        } catch (SQLException e) {
            System.out.println("Error inserting user: " + e.getMessage());
        }
        return -1;
    }
}