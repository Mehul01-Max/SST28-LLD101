public class StaffTaxRule implements TaxRule {
    @Override
    public boolean isApplicable(String customerType) {
        return "staff".equalsIgnoreCase(customerType);
    }
    @Override
    public double getTaxPercent() {
        return 2.0;
    }
}
