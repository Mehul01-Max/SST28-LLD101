import java.util.List;

public class Invoice {
    public final String id;
    public final List<InvoiceLine> lines;
    public final double subtotal;
    public final double taxPercent;
    public final double taxAmount;
    public final double discount;
    public final double total;

    public Invoice(String id, List<InvoiceLine> lines, double subtotal, double taxPercent, double taxAmount,
            double discount, double total) {
        this.id = id;
        this.lines = lines;
        this.subtotal = subtotal;
        this.taxPercent = taxPercent;
        this.taxAmount = taxAmount;
        this.discount = discount;
        this.total = total;
    }
}
