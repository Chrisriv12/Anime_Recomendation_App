/*
 * DatabaseHandler.java
 * This class handles the connection to the SQLite database and manages the creation of tables.
 * Author: Chrisnel Rivera
 * Date: 10/30/2025
 */






import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseHandler {
    private static final String DB_URL = "jdbc:sqlite:anime_app.db";
    private static DatabaseHandler instance = null;

    private DatabaseHandler() {
        createTables();
    }

    public static DatabaseHandler getInstance() {
        if (instance == null) {
            instance = new DatabaseHandler();
        }
        return instance;
    }

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    private void createTables() {
        String createUsers = """
                CREATE TABLE IF NOT EXISTS users (
                    user_id INTEGER PRIMARY KEY AUTOINCREMENT,
                    username TEXT NOT NULL,
                    email TEXT
                );
                """;

        String createAnime = """
                CREATE TABLE IF NOT EXISTS anime (
                    anime_id INTEGER PRIMARY KEY,
                    title TEXT,
                    synopsis TEXT,
                    score REAL,
                    url TEXT
                );
                """;

        String createSurvey = """
                CREATE TABLE IF NOT EXISTS survey (
                    survey_id INTEGER PRIMARY KEY AUTOINCREMENT,
                    user_id INTEGER,
                    preferred_genre TEXT,
                    prefer_popular BOOLEAN,
                    prefer_new BOOLEAN,
                    FOREIGN KEY(user_id) REFERENCES users(user_id)
                );
                """;

        try (Connection conn = connect(); Statement stmt = conn.createStatement()) {
            stmt.execute(createUsers);
            stmt.execute(createAnime);
            stmt.execute(createSurvey);
            System.out.println("Tables created or already exist.");
        } catch (SQLException e) {
            System.out.println("Error creating tables: " + e.getMessage());
        }
    }
}
