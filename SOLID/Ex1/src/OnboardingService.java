import java.util.*;

public class OnboardingService {
    private final InputParser ip;
    private final InputValidator iv;
    private final StudentSaver saver;
    private final Printer printer;

    public OnboardingService(InputParser ip, InputValidator iv, StudentSaver saver, Printer printer) {
        this.ip = ip;
        this.iv = iv;
        this.saver = saver;
        this.printer = printer;
    }

    public void registerFromRawInput(String raw) {
        System.out.println("INPUT: " + raw);

        Map<String, String> kv = ip.parse(raw);

        String name = kv.getOrDefault("name", "");
        String email = kv.getOrDefault("email", "");
        String phone = kv.getOrDefault("phone", "");
        String program = kv.getOrDefault("program", "");

        List<String> errors = iv.validate(name, email, phone, program);

        if (!errors.isEmpty()) {
            System.out.println("ERROR: cannot register");
            for (String e : errors)
                System.out.println("- " + e);
            return;
        }

        StudentRecord rec = saver.save(name, email, phone, program);

        printer.print(rec);
    }
}
