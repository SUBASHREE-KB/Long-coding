public class Coupon {
    private int couponId;
    private String code;
    private double discountPercentage;
    public Coupon(int couponId, String code, double discountPercentage) {
        this.couponId = couponId;
        this.code = code;
        this.discountPercentage = discountPercentage;
    }
    public int getCouponId() {
        return couponId;
    }
    public void setCouponId(int couponId) {
        this.couponId = couponId;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public double getDiscountPercentage() {
        return discountPercentage;
    }
    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }
    
}
