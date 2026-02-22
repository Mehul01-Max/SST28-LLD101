public class SmsSender extends NotificationSender {
    public SmsSender(AuditLog audit) {
        super(audit);
    }

    @Override
    public String channel() {
        return "SMS";
    }

    @Override
    public boolean validate(Notification n) {
        return n != null && n.phone != null;
    }

    @Override
    public String validationError(Notification n) {
        return "phone is null";
    }

    @Override
    protected void doSend(Notification n) {
        System.out.println("SMS -> to=" + n.phone + " body=" + n.body);
        audit.add("sms sent");
    }
}
