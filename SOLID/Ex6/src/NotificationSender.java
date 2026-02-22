public abstract class NotificationSender {
    protected final AuditLog audit;

    protected NotificationSender(AuditLog audit) {
        this.audit = audit;
    }

    public abstract String channel();

    public abstract boolean validate(Notification n);

    public abstract String validationError();

    protected abstract void doSend(Notification n);

    public void send(Notification n) {
        if (!validate(n)) {
            System.out.println(channel() + " ERROR: " + validationError());
            audit.add(channel() + " failed");
            return;
        }
        doSend(n);
    }
}
