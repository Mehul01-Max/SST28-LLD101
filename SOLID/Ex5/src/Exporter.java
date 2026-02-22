public abstract class Exporter {
    // implied "contract" but not enforced (smell)
    public ExportResult export(ExportRequest req) {
        if (req == null) {
            throw new IllegalArgumentException("req cannot be null");
        }
        if (req.title == null) {
            throw new IllegalArgumentException("req.title cannot be null");
        }
        validation(req);
        ExportResult data = encode(req);

        return data;
    }

    abstract void validation(ExportRequest req);

    abstract ExportResult encode(ExportRequest req);

}
