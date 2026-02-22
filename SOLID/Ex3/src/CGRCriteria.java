public class CGRCriteria implements EligibilityRule {

    double requiredCGR;

    public CGRCriteria(double requiredCGR) {
        this.requiredCGR = requiredCGR;
    }

    @Override
    public RuleResult isEligible(StudentProfile s) {
        String reason = "CGR below " + this.requiredCGR;
        if (s.cgr >= requiredCGR) {
            return new RuleResult(true, null);
        }
        return new RuleResult(false, reason);
    }

}
