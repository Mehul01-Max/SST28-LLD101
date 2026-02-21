import java.util.List;

public class DiscountCalculator {
    private final List<DiscountRule> rules;

    public DiscountCalculator(List<DiscountRule> rules) {
        this.rules = rules;
    }

    public double calculateDiscount(String customerType, double subtotal, int distinctLines) {
        for (DiscountRule rule : rules) {
            if (rule.isApplicable(customerType)) {
                return rule.calculateDiscount(subtotal, distinctLines);
            }
        }
        return 0.0;
    }
}
