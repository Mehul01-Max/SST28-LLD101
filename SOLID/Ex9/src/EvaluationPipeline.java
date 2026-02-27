public class EvaluationPipeline {
    // DIP violation: high-level module constructs concretes directly
    private final IChecker checker;
    private final IGrader grader;
    private final IWriter writer;

    public EvaluationPipeline(IChecker checker, IGrader grader, IWriter writer) {
        this.checker = checker;
        this.grader = grader;
        this.writer = writer;
    }

    public void evaluate(Submission sub) {
        Rubric rubric = new Rubric();
        int plag = checker.check(sub);
        System.out.println("PlagiarismScore=" + plag);

        int code = grader.grade(sub, rubric);
        System.out.println("CodeScore=" + code);

        String reportName = writer.write(sub, plag, code);
        System.out.println("Report written: " + reportName);

        int total = plag + code;
        String result = (total >= 90) ? "PASS" : "FAIL";
        System.out.println("FINAL: " + result + " (total=" + total + ")");
    }
}
