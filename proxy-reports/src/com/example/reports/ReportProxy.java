package com.example.reports;

/**
 * Proxy — controls access and lazy-loads the RealReport.
 * - Access check before displaying
 * - Lazy loading: RealReport created only when first needed
 * - Caching: same RealReport reused for repeated views
 */
public class ReportProxy implements Report {

    private final String reportId;
    private final String title;
    private final String classification;
    private final AccessControl accessControl = new AccessControl();
    private RealReport realReport = null;

    public ReportProxy(String reportId, String title, String classification) {
        this.reportId = reportId;
        this.title = title;
        this.classification = classification;
    }

    private RealReport getReal() {
        if (realReport == null) {
            realReport = new RealReport(reportId, title, classification);
        }
        return realReport;
    }

    @Override
    public void display(User user) {
        if (accessControl.canAccess(user, classification)) {
            getReal().display(user);
        } else {
            System.out.println("[access denied] ");
        }
    }
}
