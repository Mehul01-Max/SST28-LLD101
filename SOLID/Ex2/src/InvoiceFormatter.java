public class InvoiceFormatter {
    public String format(Invoice invoice) {
        StringBuilder out = new StringBuilder();
        out.append("Invoice# ").append(invoice.id).append("\n");

        for (InvoiceLine l : invoice.lines) {
            out.append(String.format("- %s x%d = %.2f\n", l.itemName, l.qty, l.lineTotal));
        }

        out.append(String.format("Subtotal: %.2f\n", invoice.subtotal));
        out.append(String.format("Tax(%.0f%%): %.2f\n", invoice.taxPercent, invoice.taxAmount));
        out.append(String.format("Discount: -%.2f\n", invoice.discount));
        out.append(String.format("TOTAL: %.2f\n", invoice.total));

        return out.toString();
    }
}
