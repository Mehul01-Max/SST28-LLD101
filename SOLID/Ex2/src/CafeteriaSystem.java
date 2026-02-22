import java.util.*;

public class CafeteriaSystem {
    private final Map<String, MenuItem> menu = new LinkedHashMap<>();
    private final FileStore store = new FileStore();
    private final TaxCalculator taxCalculator;
    private final DiscountCalculator discountCalculator;
    private final PricingCalculator pricingCalculator;
    private final InvoiceFormatter invoiceFormatter = new InvoiceFormatter();
    private int invoiceSeq = 1000;

    public CafeteriaSystem(TaxCalculator taxCalculator, DiscountCalculator discountCalculator) {
        this.taxCalculator = taxCalculator;
        this.discountCalculator = discountCalculator;
        this.pricingCalculator = new PricingCalculator(menu);
    }

    public void addToMenu(MenuItem i) {
        menu.put(i.id, i);
    }

    public void checkout(String customerType, List<OrderLine> lines) {
        String invId = "INV-" + (++invoiceSeq);
        List<InvoiceLine> invoiceLines = new ArrayList<>();
        double subtotal = pricingCalculator.calculateSubtotal(lines, invoiceLines);

        double taxPct = taxCalculator.calculateTaxPercent(customerType);
        double tax = subtotal * (taxPct / 100.0);

        double discount = discountCalculator.calculateDiscount(customerType, subtotal, lines.size());

        double total = subtotal + tax - discount;

        Invoice invoice = new Invoice(invId, invoiceLines, subtotal, taxPct, tax, discount, total);

        String printable = invoiceFormatter.format(invoice);
        System.out.print(printable);

        store.save(invId, printable);
        System.out.println("Saved invoice: " + invId + " (lines=" + store.countLines(invId) + ")");
    }
}
