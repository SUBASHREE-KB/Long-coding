import java.util.Date;
import java.util.List;

public class Booking {
    private int bookingId;
    private Date bookingDate;
    private double totalAmount;
    private Customer customer;
    private Show show;
    private List<Seat> seats;
    private Coupon coupon;
    public Booking(int bookingId, Date bookingDate, double totalAmount, Customer customer, Show show, List<Seat> seats,
            Coupon coupon) {
        this.bookingId = bookingId;
        this.bookingDate = bookingDate;
        this.totalAmount = totalAmount;
        this.customer = customer;
        this.show = show;
        this.seats = seats;
        this.coupon = coupon;
    }
    public int getBookingId() {
        return bookingId;
    }
    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }
    public Date getBookingDate() {
        return bookingDate;
    }
    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }
    public double getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public Show getShow() {
        return show;
    }
    public void setShow(Show show) {
        this.show = show;
    }
    public List<Seat> getSeats() {
        return seats;
    }
    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
    public Coupon getCoupon() {
        return coupon;
    }
    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }
    @Override
    public String toString() {
        return "Booking [bookingId=" + bookingId + ", bookingDate=" + bookingDate + ", totalAmount=" + totalAmount
                + ", customer=" + customer + ", show=" + show + ", seats=" + seats + ", coupon=" + coupon + "]";
    }
    
}
