public class Cinema {
    private int cinemaId;
    private String name;
    private String address;
    private City city;
    public Cinema(int cinemaId, String name, String address, City city) {
        this.cinemaId = cinemaId;
        this.name = name;
        this.address = address;
        this.city = city;
    }
    public int getCinemaId() {
        return cinemaId;
    }
    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public City getCity() {
        return city;
    }
    public void setCity(City city) {
        this.city = city;
    }
    
    
}
