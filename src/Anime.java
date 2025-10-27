




public class Anime {
    private String title;
    private String genre;
    private int releaseYear;
    private boolean watched;
    private String synopsis;
    private int episodes;
    private int rating; 

    public Anime(String title, String genre, int releaseYear, boolean watched, String synopsis, int episodes, int rating) {
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.watched = watched;
        this.synopsis = synopsis;
        this.episodes = episodes;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }
    

    public String getGenre() {
        return genre;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public boolean Watched() {
        return watched;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public int getEpisodes() {
        return episodes;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Anime{" +
                "title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", releaseYear=" + releaseYear +
                ", watched=" + watched +
                ", synopsis='" + synopsis + '\'' +
                ", episodes=" + episodes +
                ", rating=" + rating +
                '}';

}
}
