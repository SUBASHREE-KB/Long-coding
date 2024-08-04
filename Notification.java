public class Notification {
    private int notificationId;
    private String message;
    private Customer customer;
    public Notification(int notificationId, String message, Customer customer) {
        this.notificationId = notificationId;
        this.message = message;
        this.customer = customer;
    }
    public int getNotificationId() {
        return notificationId;
    }
    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
}
