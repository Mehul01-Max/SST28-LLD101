import java.nio.charset.StandardCharsets;

public class PdfExporter extends Exporter {
    @Override
    public byte[] encode(ExportRequest req) {
        String fakePdf = "PDF(" + req.title + "):" + req.body;
        return fakePdf.getBytes(StandardCharsets.UTF_8);
    }

    @Override
    ExportResult postProcess(ExportRequest req, byte[] data) {
        if (req.body != null && req.body.length() > 20) {
            throw new IllegalArgumentException("PDF cannot handle content > 20 chars");
        }
        return new ExportResult("application/pdf", data);
    }

}
