/*
 * MaliApiHandler.java
 * Handles interactions with the MyAnimeList API using Jikan.
 * Name: Chrisnel Rivera
 * Date: 10/30/2025
 */



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.*;
import org.json.JSONArray;
import org.json.JSONObject;

public class MaliApiHandler {
    private static final String BASE_URL = "https://api.jikan.moe/v4/";

    // Map of common genre names to their Jikan IDs
    private static final Map<String, Integer> GENRE_MAP = Map.ofEntries(
        Map.entry("action", 1),
        Map.entry("adventure", 2),
        Map.entry("comedy", 4),
        Map.entry("drama", 8),
        Map.entry("fantasy", 10),
        Map.entry("horror", 14),
        Map.entry("mystery", 7),
        Map.entry("romance", 22),
        Map.entry("sci-fi", 24),
        Map.entry("slice of life", 36)
    );

    // Fetch anime by title
    public Anime fetchAnimeByTitle(String title) {
        try {
            String encodedTitle = URLEncoder.encode(title, "UTF-8");
            URL url = new URL(BASE_URL + "anime?q=" + encodedTitle + "&limit=1");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            JSONObject json = new JSONObject(response.toString());
            JSONArray data = json.getJSONArray("data");
            if (data.length() > 0) {
                JSONObject animeObj = data.getJSONObject(0);
                return new Anime(
                    animeObj.getInt("mal_id"),
                    animeObj.getString("title"),
                    animeObj.optString("synopsis", "No synopsis available"),
                    animeObj.optDouble("score", 0.0),
                    animeObj.optString("url", "No URL available")
                );
            }
        } catch (Exception e) {
            System.out.println("Error fetching anime by title: " + e.getMessage());
        }
        return null;
    }

    // Fetch anime by genre name (using ID lookup)
    public List<Anime> fetchAnimeByGenre(String genre) {
        List<Anime> animeList = new ArrayList<>();
        try {
            Integer genreId = GENRE_MAP.get(genre.toLowerCase());
            if (genreId == null) {
                System.out.println("Genre not recognized: " + genre);
                return animeList;
            }

            URL url = new URL(BASE_URL + "anime?genres=" + genreId + "&limit=5");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            JSONObject json = new JSONObject(response.toString());
            JSONArray data = json.getJSONArray("data");

            for (int i = 0; i < data.length(); i++) {
                JSONObject animeObj = data.getJSONObject(i);
                animeList.add(new Anime(
                    animeObj.getInt("mal_id"),
                    animeObj.getString("title"),
                    animeObj.optString("synopsis", "No synopsis available"),
                    animeObj.optDouble("score", 0.0),
                    animeObj.optString("url", "No URL available")
                ));
            }

        } catch (Exception e) {
            System.out.println("Error fetching anime by genre: " + e.getMessage());
        }
        return animeList;
    }
}



