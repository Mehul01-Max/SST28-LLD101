public class StudentTaxRule implements TaxRule {
    @Override
    public boolean isApplicable(String customerType) {
        return "student".equalsIgnoreCase(customerType);
    }
    @Override
    public double getTaxPercent() {
        return 5.0;
    }
}
