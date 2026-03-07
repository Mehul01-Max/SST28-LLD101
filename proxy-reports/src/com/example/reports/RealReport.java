package com.example.reports;

/**
 * RealSubject — does the actual expensive file loading.
 * Content is loaded lazily on first display() and cached for reuse.
 */
public class RealReport implements Report {

    private final String reportId;
    private final String title;
    private final String classification;
    private String content = null;

    public RealReport(String reportId, String title, String classification) {
        this.reportId = reportId;
        this.title = title;
        this.classification = classification;
    }

    private String loadFromDisk() {
        System.out.println("[disk] loading report " + reportId + " ...");
        try {
            Thread.sleep(120);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "Internal report body for " + title;
    }

    @Override
    public void display(User user) {
        if (content == null) {
            content = loadFromDisk();
        }
        System.out.println("REPORT -> id=" + reportId
                + " title=" + title
                + " classification=" + classification
                + " openedBy=" + user.getName());
        System.out.println("CONTENT: " + content);
    }

    public String getClassification() {
        return classification;
    }
}
