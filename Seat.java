public class Seat {
    private int seatId;
    private int seatNumber;
    private Hall hall;
    public Seat(int seatId, int seatNumber, Hall hall) {
        this.seatId = seatId;
        this.seatNumber = seatNumber;
        this.hall = hall;
    }
    public int getSeatId() {
        return seatId;
    }
    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }
    public  int getSeatNumber() {
        return seatNumber;
    }
    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }
    public Hall getHall() {
        return hall;
    }
    public void setHall(Hall hall) {
        this.hall = hall;
    }
    
}
