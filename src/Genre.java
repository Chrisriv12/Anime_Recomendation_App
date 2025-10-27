




import java.util.List;
import java.util.ArrayList;

public class Genre {
    private String genreName;
    private List<Anime> animeList;

    public Genre(String name) {
        this.genreName = name;
        this.animeList = new ArrayList<>();
    }

    public String getGenreName() {
        return genreName;
    }

    public List<Anime> getAnimeList() {
        return animeList;
    }

    public void addAnime(Anime anime) {
        animeList.add(anime);
    }

    public void removeAnime(Anime anime) {
        animeList.remove(anime);
    }

    @Override
    public String toString() {
        return "Genre{" +
                "genreName='" + genreName + '\'' +
                ", animeList=" + animeList +
                '}';
    }
}
