public class Main {
    public static void main(String[] args) {
        System.out.println("=== Student Onboarding ===");
        FakeDb db = new FakeDb();
        Printer printer = new Printer(db);
        StudentSaver saver = new Saver(db);
        InputParser ip = new InputParser();
        InputValidator iv = new InputValidator();
        OnboardingService svc = new OnboardingService(ip, iv, saver, printer);
        String raw = "name=Riya;email=riya@sst.edu;phone=9876543210;program=CSE";
        svc.registerFromRawInput(raw);

        System.out.println();
        System.out.println("-- DB DUMP --");
        System.out.print(TextTable.render3(db));
    }
}
