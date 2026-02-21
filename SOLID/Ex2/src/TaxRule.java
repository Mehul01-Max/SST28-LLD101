public interface TaxRule {
    boolean isApplicable(String customerType);
    double getTaxPercent();
}
