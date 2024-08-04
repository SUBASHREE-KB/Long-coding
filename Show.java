

public class Show {
    private int showId;
    private String startTime;
    private String endTime;
    private Hall hall;
    private Movie movie;
    public Show(int showId, String startTime, String endTime, Hall hall, Movie movie) {
        this.showId = showId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.hall = hall;
        this.movie = movie;
    }
    public int getShowId() {
        return showId;
    }
    public void setShowId(int showId) {
        this.showId = showId;
    }
    public String getStartTime() {
        return startTime;
    }
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
    public String getEndTime() {
        return endTime;
    }
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
    public Hall getHall() {
        return hall;
    }
    public void setHall(Hall hall) {
        this.hall = hall;
    }
    public Movie getMovie() {
        return movie;
    }
    public void setMovie(Movie movie) {
        this.movie = movie;
    }

}
