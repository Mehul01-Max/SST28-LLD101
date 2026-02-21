public class Printer {
    FakeDb db;

    public Printer(FakeDb db) {
        this.db = db;
    }

    void print(StudentRecord rec) {
        System.out.println("OK: created student " + rec.id);
        System.out.println("Saved. Total students: " + db.count());
        System.out.println("CONFIRMATION:");
        System.out.println(rec);
    }
}
