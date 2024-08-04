public class Hall {
    private int hallId;
    private String name;
    private Cinema cinema;
    private int capacity;
    public Hall(int hallId, String name, Cinema cinema,int capacity) {
        this.hallId = hallId;
        this.name = name;
        this.cinema = cinema;
        this.capacity = capacity;
    }
    public int getHallId() {
        return hallId;
    }
    public void setHallId(int hallId) {
        this.hallId = hallId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Cinema getCinema() {
        return cinema;
    }
    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
}
