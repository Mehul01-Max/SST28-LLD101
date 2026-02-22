import java.util.List;
import java.util.Map;

public class PricingCalculator {
    private final Map<String, MenuItem> menu;

    public PricingCalculator(Map<String, MenuItem> menu) {
        this.menu = menu;
    }

    public double calculateSubtotal(List<OrderLine> lines, List<InvoiceLine> invoiceLines) {
        double subtotal = 0.0;
        for (OrderLine l : lines) {
            MenuItem item = menu.get(l.itemId);
            double lineTotal = item.price * l.qty;
            subtotal += lineTotal;
            invoiceLines.add(new InvoiceLine(item.name, l.qty, lineTotal));
        }
        return subtotal;
    }
}