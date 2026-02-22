public class WhatsAppSender extends NotificationSender {
    public WhatsAppSender(AuditLog audit) {
        super(audit);
    }

    @Override
    public String channel() {
        return "WA";
    }

    @Override
    public boolean validate(Notification n) {
        return n != null && n.phone != null && n.phone.startsWith("+");
    }

    @Override
    public String validationError(Notification n) {
        return "phone must start with + and country code";
    }

    @Override
    protected void doSend(Notification n) {
        System.out.println("WA -> to=" + n.phone + " body=" + n.body);
        audit.add("wa sent");
    }
}
