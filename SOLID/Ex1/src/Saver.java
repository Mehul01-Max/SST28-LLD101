public class Saver implements StudentSaver {
    private final FakeDb db;

    public Saver(FakeDb db) {
        this.db = db;
    }

    public StudentRecord save(String name, String email, String phone, String program) {
        String id = IdUtil.nextStudentId(db.count());
        StudentRecord rec = new StudentRecord(id, name, email, phone, program);
        db.save(rec);
        return rec;
    }
}