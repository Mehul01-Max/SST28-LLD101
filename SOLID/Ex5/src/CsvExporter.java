import java.nio.charset.StandardCharsets;

public class CsvExporter extends Exporter {
    @Override
    public byte[] encode(ExportRequest req) {
        // LSP issue: changes meaning by lossy conversion
        String body = req.body == null ? "" : req.body.replace("\n", " ").replace(",", " ");
        String csv = "title,body\n" + req.title + "," + body + "\n";
        return csv.getBytes(StandardCharsets.UTF_8);
    }

    @Override
    ExportResult postProcess(ExportRequest req, byte[] data) {
        return new ExportResult("text/csv", data);
    }

}
