/*
 * Recommendation.java
 * Interface for generating anime recommendations based on a given anime.
 * Name: Chrisnel Rivera
 * Date: 10/30/2025
 */

// Recommendation.java (Interface)
import java.util.List;

public interface Recommendation {
    List<Anime> getRecommendations(Anime baseAnime);
}
