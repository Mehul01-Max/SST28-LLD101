public class DefaultDiscountRule implements DiscountRule {
    @Override
    public boolean isApplicable(String customerType) {
        return true;
    }
    @Override
    public double calculateDiscount(double subtotal, int distinctLines) {
        return 0.0;
    }
}
