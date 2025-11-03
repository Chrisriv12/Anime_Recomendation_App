/*
 * Survey.java
 * Represents a user survey for anime preferences.  
 * Name: Chrisnel Rivera
 * Date: 10/30/2025
 */





import java.util.ArrayList;
import java.util.List;

public class Survey {
    private String surveyId;
    private String userId;
    private String preferredGenre;
    private boolean preferPopularAnime;
    private boolean preferNewReleases;
    private List<String> responses;

    // Constructor
    public Survey(String surveyId, String userId) {
        this.surveyId = surveyId;
        this.userId = userId;
        this.responses = new ArrayList<>();
    }

    // Getters and Setters
    public String getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(String surveyId) {
        this.surveyId = surveyId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPreferredGenre() {
        return preferredGenre;
    }

    public void setPreferredGenre(String preferredGenre) {
        this.preferredGenre = preferredGenre;
    }

    public boolean isPreferPopularAnime() {
        return preferPopularAnime;
    }

    public void setPreferPopularAnime(boolean preferPopularAnime) {
        this.preferPopularAnime = preferPopularAnime;
    }

    public boolean isPreferNewReleases() {
        return preferNewReleases;
    }

    public void setPreferNewReleases(boolean preferNewReleases) {
        this.preferNewReleases = preferNewReleases;
    }

    public List<String> getResponses() {
        return responses;
    }

    // Add a custom response (e.g., "Prefers action anime" or "Watches seasonal shows")
    public void addResponse(String response) {
        responses.add(response);
    }

    // Optional method to summarize survey results
    public String getSurveySummary() {
        return "Preferred Genre: " + preferredGenre + "\n" +
               "Prefers Popular Anime: " + preferPopularAnime + "\n" +
               "Prefers New Releases: " + preferNewReleases + "\n" +
               "Additional Responses: " + responses;
    }

    @Override
    public String toString() {
        return "Survey{" +
                "surveyId='" + surveyId + '\'' +
                ", userId='" + userId + '\'' +
                ", preferredGenre='" + preferredGenre + '\'' +
                ", preferPopularAnime=" + preferPopularAnime +
                ", preferNewReleases=" + preferNewReleases +
                ", responses=" + responses +
                '}';
    }
}
