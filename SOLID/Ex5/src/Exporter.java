public abstract class Exporter {
    // implied "contract" but not enforced (smell)
    public String export(ExportRequest req) {
        if (req == null) {
            return "ERROR: req cannot be null";
        }
        if (req.title == null) {
            return "ERROR: req.title cannot be null";

        }
        if (req.body == null) {
            return "ERROR: req.body cannot be null";
        }
        String val = validation(req);
        if (val != null) {
            return "ERROR: " + val;
        }
        ExportResult data = encode(req);

        return "OK bytes=" + data.bytes.length;
    }

    protected abstract String validation(ExportRequest req);

    protected abstract ExportResult encode(ExportRequest req);

}
