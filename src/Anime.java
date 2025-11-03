/**
 * The Anime class represents an anime entity containing key information
 * such as its ID, title, synopsis, score, and URL.
 * 
 * This class serves as a data model for anime objects retrieved from
 * an external API (such as the Jikan API) or stored in a local database.
 * 
 * It includes a parameterized constructor for initializing all attributes,
 * a default constructor for flexibility, getter and setter methods for
 * encapsulated access, and a toString() method for easy display and debugging.
 * 
 * Author: Chrisnel Rivera
 * Date: 10/30/2025
 */




public class Anime {
    private int id;
    private String title;
    private String synopsis;
    private double score;
    private String url;

    // ✅ Constructor matching your DAO
    public Anime(int id, String title, String synopsis, double score, String url) {
        this.id = id;
        this.title = title;
        this.synopsis = synopsis;
        this.score = score;
        this.url = url;
    }

    // ✅ Default constructor (optional but good practice)
    public Anime() {}

    // ✅ Getters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public double getScore() {
        return score;
    }

    public String getUrl() {
        return url;
    }

    // ✅ Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // ✅ toString for easy debugging
    @Override
    public String toString() {
        return "Anime{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", score=" + score +
                ", url='" + url + '\'' +
                '}';
    }
}
