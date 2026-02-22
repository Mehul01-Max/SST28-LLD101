import java.util.List;

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

    void printErrors(List<String> errors) {
        if (!errors.isEmpty()) {
            System.out.println("ERROR: cannot register");
            for (String e : errors)
                System.out.println("- " + e);
            return;
        }
    }
}
