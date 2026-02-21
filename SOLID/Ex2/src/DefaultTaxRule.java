public class DefaultTaxRule implements TaxRule {
    @Override
    public boolean isApplicable(String customerType) {
        return true;
    }
    @Override
    public double getTaxPercent() {
        return 8.0;
    }
}
