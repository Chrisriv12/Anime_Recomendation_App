/*
 * SurveyDAO.java
 * Data Access Object for handling survey-related database operations.
 * Name: Chrisnel Rivera
 * Date: 10/30/2025
 */



import java.sql.*;

public class SurveyDAO {
    private final DatabaseHandler db = DatabaseHandler.getInstance();

    public void insertSurvey(int userId, String preferredGenre, boolean preferPopular, boolean preferNew) {
        String sql = "INSERT INTO survey(user_id, preferred_genre, prefer_popular, prefer_new) VALUES (?, ?, ?, ?)";
        try (Connection conn = db.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            pstmt.setString(2, preferredGenre);
            pstmt.setBoolean(3, preferPopular);
            pstmt.setBoolean(4, preferNew);
            pstmt.executeUpdate();
            System.out.println("Survey saved successfully!");
        } catch (SQLException e) {
            System.out.println("Error saving survey: " + e.getMessage());
        }
    }
}
