public class AttendanceCriteria implements EligibilityRule {

    int requiredPercentage;

    public AttendanceCriteria(int requiredPercentage) {
        this.requiredPercentage = requiredPercentage;
    }

    @Override
    public RuleResult isEligible(StudentProfile s) {
        String reason = "attendance below " + this.requiredPercentage;
        if (s.attendancePct >= requiredPercentage) {
            return new RuleResult(true, null);
        }
        return new RuleResult(false, reason);
    }

}
