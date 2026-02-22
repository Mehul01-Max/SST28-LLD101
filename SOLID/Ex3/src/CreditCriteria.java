public class CreditCriteria implements EligibilityRule {

    int requiredCredit;
    String Status;

    public CreditCriteria(int requiredCredit) {
        this.requiredCredit = requiredCredit;
    }

    @Override
    public RuleResult isEligible(StudentProfile s) {
        boolean Status = false;
        String reason = "credits below " + requiredCredit;
        if (s.earnedCredits >= requiredCredit) {
            return new RuleResult(true, null);
        }
        return new RuleResult(Status, reason);
    }

}
