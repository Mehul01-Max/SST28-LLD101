public abstract class Exporter {
    // implied "contract" but not enforced (smell)
    public ExportResult export(ExportRequest req) {
        if (req == null) {
            throw new IllegalArgumentException("req cannot be null");
        }
        if (req.title == null) {
            throw new IllegalArgumentException("req.title cannot be null");
        }
        byte[] data = encode(req);

        return postProcess(req, data);
    }

    abstract byte[] encode(ExportRequest req);

    abstract ExportResult postProcess(ExportRequest req, byte[] data);
}
