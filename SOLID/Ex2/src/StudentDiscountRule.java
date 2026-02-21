public class StudentDiscountRule implements DiscountRule {
    @Override
    public boolean isApplicable(String customerType) {
        return "student".equalsIgnoreCase(customerType);
    }
    @Override
    public double calculateDiscount(double subtotal, int distinctLines) {
        if (subtotal >= 180.0) return 10.0;
        return 0.0;
    }
}
