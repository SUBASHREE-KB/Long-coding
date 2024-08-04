import java.util.Date;

public class Movie {
    private int movieId;
    private String title;
    private String language;
    private String genre;
    private Date releaseDate;
    public Movie(int movieId, String title, String language, String genre, Date releaseDate) {
        this.movieId = movieId;
        this.title = title;
        this.language = language;
        this.genre = genre;
        this.releaseDate = releaseDate;
    }
    public int getMovieId() {
        return movieId;
    }
    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public Date getReleaseDate() {
        return releaseDate;
    }
    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
    @Override
    public String toString() {
        return "Movie [movieId=" + movieId + ", title=" + title + ", language=" + language + ", genre=" + genre
                + ", releaseDate=" + releaseDate + "]";
    }
    
}
