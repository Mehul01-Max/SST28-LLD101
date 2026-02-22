import java.nio.charset.StandardCharsets;

public class JsonExporter extends Exporter {
    @Override
    public byte[] encode(ExportRequest req) {
        // inconsistent handling (surprise)
        String json = "{\"title\":\"" + escape(req.title) + "\",\"body\":\"" + escape(req.body) + "\"}";
        return json.getBytes(StandardCharsets.UTF_8);
    }

    private String escape(String s) {
        if (s == null)
            return "";
        return s.replace("\"", "\\\"");
    }

    @Override
    ExportResult postProcess(ExportRequest req, byte[] data) {
        return new ExportResult("text/json", data);
    }
}
