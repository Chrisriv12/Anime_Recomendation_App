/*
 * MaliApiHandler.java
 * Handles interactions with the MyAnimeList API using Jikan.
 * Name: Chrisnel Rivera
 * Date: 10/30/2025
 */






import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class MaliApiHandler {
    private static final String BASE_URL = "https://api.jikan.moe/v4/";

    // Fetch anime by title
    public Anime fetchAnimeByTitle(String title) {
        try {
            String encodedTitle = URLEncoder.encode(title, "UTF-8");
            String apiUrl = BASE_URL + "anime?q=" + encodedTitle + "&limit=1"; // limit to first result
            String jsonResponse = makeHttpRequest(apiUrl);

            JSONObject jsonObject = new JSONObject(jsonResponse);
            JSONArray dataArray = jsonObject.getJSONArray("data");

            if (dataArray.length() > 0) {
                JSONObject animeObj = dataArray.getJSONObject(0);

                // Create and return Anime object
                Anime anime = new Anime(
                        animeObj.getInt("mal_id"),
                        animeObj.getString("title"),
                        animeObj.getString("synopsis"),
                        animeObj.getDouble("score"),
                        animeObj.getString("url")
                );
                return anime;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Fetch anime by genre name
    public List<Anime> fetchAnimeByGenre(String genreName) {
        List<Anime> animeList = new ArrayList<>();
        try {
            // Convert genre name to ID (simplified example)
            int genreId = getGenreId(genreName);
            if (genreId == -1) {
                System.out.println("Genre not recognized: " + genreName);
                return animeList;
            }

            String apiUrl = BASE_URL + "anime?genres=" + genreId + "&limit=5";
            String jsonResponse = makeHttpRequest(apiUrl);

            JSONObject jsonObject = new JSONObject(jsonResponse);
            JSONArray dataArray = jsonObject.getJSONArray("data");

            for (int i = 0; i < dataArray.length(); i++) {
                JSONObject animeObj = dataArray.getJSONObject(i);
                Anime anime = new Anime(
                        animeObj.getInt("mal_id"),
                        animeObj.getString("title"),
                        animeObj.optString("synopsis", "No synopsis available."),
                        animeObj.optDouble("score", 0.0),
                        animeObj.getString("url")
                );
                animeList.add(anime);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return animeList;
    }

    // Helper: Make HTTP GET request and return response as String
    private String makeHttpRequest(String apiUrl) throws IOException {
        StringBuilder response = new StringBuilder();
        URL url = new URL(apiUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");

        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();
        conn.disconnect();

        return response.toString();
    }

    // Map common genre names to IDs (Jikan IDs)
    private int getGenreId(String genreName) {
        genreName = genreName.toLowerCase();
        switch (genreName) {
            case "action": return 1;
            case "adventure": return 2;
            case "comedy": return 4;
            case "drama": return 8;
            case "fantasy": return 10;
            case "horror": return 14;
            case "sci-fi": return 24;
            case "romance": return 22;
            default: return -1;
        }
    }
}
