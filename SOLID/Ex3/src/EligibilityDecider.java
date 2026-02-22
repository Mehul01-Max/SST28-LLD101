import java.util.*;

public class EligibilityDecider {

    List<EligibilityRule> eligibilityCriterias;

    public EligibilityDecider(List<EligibilityRule> eligibilityCriterias) {
        this.eligibilityCriterias = eligibilityCriterias;
    }

    EligibilityEngineResult decide(StudentProfile s) {
        List<String> reasons = new ArrayList<>();
        String status = "ELIGIBLE";
        for (EligibilityRule e : eligibilityCriterias) {
            RuleResult res = e.isEligible(s);
            if (!res.eligible) {
                reasons.add(res.reason);
                return new EligibilityEngineResult("NOT_ELIGIBLE", reasons);
            }
        }
        return new EligibilityEngineResult(status, reasons);
    }
}