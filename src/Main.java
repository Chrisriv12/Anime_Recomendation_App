/*
 * Main.java
 * Entry point for the Anime Recommendation Application.
 * Name: Chrisnel Rivera
 * Date: 10/30/2025
 */





public class Main {
    public static void main(String[] args) {
        MaliApiHandler api = new MaliApiHandler();

        // Fetch anime by title
        Anime anime = api.fetchAnimeByTitle("Attack on Titan");
        if (anime != null) {
            System.out.println(anime);
        }

        // Fetch anime by genre
        System.out.println("Top Action Anime:");
        for (Anime a : api.fetchAnimeByGenre("Action")) {
            System.out.println(a);
        }
    }
}
