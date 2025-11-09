/*
 * Anime Data Access Object (DAO)
 * This class provides an interface for interacting with the anime database.
 * It includes methods for inserting new anime records and retrieving all anime records.
 * Author: Chrisnel Rivera
 * Date: 10/30/2025
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;


public class AnimeDAO {
    private final DatabaseHandler db = DatabaseHandler.getInstance();

    public void insertAnime(Anime anime) {
        String sql = "INSERT OR IGNORE INTO anime(anime_id, title, synopsis, score, url) VALUES(?, ?, ?, ?, ?)";
        try (Connection conn = db.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, anime.getId());
            pstmt.setString(2, anime.getTitle());
            pstmt.setString(3, anime.getSynopsis());
            pstmt.setDouble(4, anime.getScore());
            pstmt.setString(5, anime.getUrl());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error inserting anime: " + e.getMessage());
        }
    }

    public List<Anime> getAllAnime() {
        List<Anime> list = new ArrayList<>();
        String sql = "SELECT * FROM anime";
        try (Connection conn = db.connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Anime(
                        rs.getInt("anime_id"),
                        rs.getString("title"),
                        rs.getString("synopsis"),
                        rs.getDouble("score"),
                        rs.getString("url")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving anime: " + e.getMessage());
        }
        return list;
    }
}
