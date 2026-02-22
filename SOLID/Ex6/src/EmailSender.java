public class EmailSender extends NotificationSender {
    public EmailSender(AuditLog audit) {
        super(audit);
    }

    @Override
    public String channel() {
        return "EMAIL";
    }

    @Override
    public boolean validate(Notification n) {
        return n != null && n.email != null;
    }

    @Override
    public String validationError() {
        return "email is null";
    }

    @Override
    protected void doSend(Notification n) {
        System.out.println("EMAIL -> to=" + n.email + " subject=" + n.subject + " body=" + n.body);
        audit.add("email sent");
    }
}
