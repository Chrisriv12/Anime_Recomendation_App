



import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String email;
    private int age;
    private String dateOfBirth;
    private String favoriteGenre;
    private List<Anime> favorites;
    private List<Anime> watchedList;

    // Constructor
    public User(String username, String email, int age, String dateOfBirth, String favoriteGenre) {
        this.username = username;
        this.email = email;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
        this.favoriteGenre = favoriteGenre;
        this.favorites = new ArrayList<>();
        this.watchedList = new ArrayList<>();
    }

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getFavoriteGenre() {
        return favoriteGenre;
    }

    public void setFavoriteGenre(String favoriteGenre) {
        this.favoriteGenre = favoriteGenre;
    }

    public List<Anime> getFavorites() {
        return favorites;
    }

    public List<Anime> getWatchedList() {
        return watchedList;
    }

    // Add or remove anime
    public void addToWatchedList(Anime anime) {
        watchedList.add(anime);
    }

    public void removeFromWatchedList(Anime anime) {
        watchedList.remove(anime);
    }

    public void addToFavorites(Anime anime) {
        favorites.add(anime);
    }

    public void removeFromFavorites(Anime anime) {
        favorites.remove(anime);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", favoriteGenre='" + favoriteGenre + '\'' +
                ", watchedList=" + watchedList +
                ", favorites=" + favorites +
                '}';
    }
}
