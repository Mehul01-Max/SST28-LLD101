public class RuleResult {
    final boolean eligible;
    final String reason;

    public RuleResult(boolean eligible, String reason) {
        this.eligible = eligible;
        this.reason = reason;
    }
}