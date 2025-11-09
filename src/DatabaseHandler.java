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

/**
 * DatabaseHandler
 * ----------------
 * This class is responsible for managing the database connection and table creation
 * for the Anime Recommendation App. It ensures that all necessary tables are created
 * when the application first starts and provides a connection method for other DAO classes.
 *
 * Tables Created:
 *  - anime: Stores information about anime titles fetched from the Jikan API.
 *  - survey: (Optional) Stores user survey preferences to improve recommendations.
 *
 * Note:
 *  The 'users' table was removed since this app is designed for a single-user experience.
 *  If future updates include multi-user support, it can easily be re-added.
 *
 * Author: Chrisnel Rivera
 * Date: October 2025
 */
public class DatabaseHandler {

    // SQLite database file name and connection URL
    private static final String DB_URL = "jdbc:sqlite:anime_app.db";

    // Singleton instance (ensures only one database handler exists)
    private static DatabaseHandler instance = null;

    /**
     * Private constructor to initialize the database and create required tables.
     */
    private DatabaseHandler() {
        createTables();
    }

    /**
     * Returns the singleton instance of DatabaseHandler.
     * If it doesn’t exist yet, it creates one.
     *
     * @return DatabaseHandler instance
     */
    public static DatabaseHandler getInstance() {
        if (instance == null) {
            instance = new DatabaseHandler();
        }
        return instance;
    }

    /**
     * Establishes a connection to the SQLite database.
     *
     * @return Connection object
     * @throws SQLException if database connection fails
     */
    public Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    /**
     * Creates the necessary database tables if they do not already exist.
     * Tables include:
     *   - anime: stores anime details such as title, synopsis, score, and URL.
     *   - survey: stores user preference data for recommendation tuning.
     */
    private void createTables() {
        // Anime table to store fetched anime details
        String createAnime = """
                CREATE TABLE IF NOT EXISTS anime (
                    anime_id INTEGER PRIMARY KEY,
                    title TEXT,
                    synopsis TEXT,
                    score REAL,
                    url TEXT
                );
                """;

        // Survey table to store user preferences
        String createSurvey = """
                CREATE TABLE IF NOT EXISTS survey (
                    survey_id INTEGER PRIMARY KEY AUTOINCREMENT,
                    preferred_genre TEXT,
                    prefer_popular BOOLEAN,
                    prefer_new BOOLEAN
                );
                """;

        try (Connection conn = connect(); Statement stmt = conn.createStatement()) {
            stmt.execute(createAnime);
            stmt.execute(createSurvey);
            System.out.println("✅ Tables created or already exist.");
        } catch (SQLException e) {
            System.out.println("❌ Error creating tables: " + e.getMessage());
        }
    }
}
