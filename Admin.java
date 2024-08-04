import java.util.Date;

class Admin {

    public static void addMovie(Movie movie) {
        Database.movies.add(movie);
        System.out.println("Movie added successfully.");
    }

    public static void updateMovie(int movieId, String title, String language, String genre, Date releaseDate) {
        for (Movie movie : Database.movies) {
            if (movie.getMovieId() == movieId) {
                movie.setTitle(title);
                movie.setLanguage(language);
                movie.setGenre(genre);
                movie.setReleaseDate(releaseDate);
                System.out.println("Movie updated successfully.");
                return;
            }
        }
        System.out.println("Movie not found.");
    }

    public static void deleteMovie(int movieId) {
        Database.movies.removeIf(movie -> movie.getMovieId() == movieId);
        System.out.println("Movie deleted successfully.");
    }

}