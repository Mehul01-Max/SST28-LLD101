public interface DiscountRule {
    boolean isApplicable(String customerType);
    double calculateDiscount(double subtotal, int distinctLines);
}
