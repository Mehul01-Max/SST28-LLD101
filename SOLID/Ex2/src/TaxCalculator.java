import java.util.List;

public class TaxCalculator {
    private final List<TaxRule> rules;

    public TaxCalculator(List<TaxRule> rules) {
        this.rules = rules;
    }

    public double calculateTaxPercent(String customerType) {
        for (TaxRule rule : rules) {
            if (rule.isApplicable(customerType)) {
                return rule.getTaxPercent();
            }
        }
        return 0.0;
    }
}
