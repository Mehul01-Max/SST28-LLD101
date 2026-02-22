public class LegacyFlagCriteria implements EligibilityRule {
    int requiredLegacyFlag;

    public LegacyFlagCriteria(int requiredLegacyFlag) {
        this.requiredLegacyFlag = requiredLegacyFlag;
    }

    @Override
    public RuleResult isEligible(StudentProfile s) {
        boolean Status = false;
        String reason = "disciplinary flag present";
        if (s.disciplinaryFlag == requiredLegacyFlag) {
            return new RuleResult(true, null);
        }
        return new RuleResult(Status, reason);
    }
}
