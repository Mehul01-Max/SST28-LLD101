import java.util.*;

public class HostelFeeCalculator {
    private final FakeBookingRepo repo;
    private final RoomPricingDecider rpd;
    private final AddOnTotalPricing atp;

    public HostelFeeCalculator(FakeBookingRepo repo, RoomPricingDecider rpd, AddOnTotalPricing atp) {
        this.repo = repo;
        this.rpd = rpd;
        this.atp = atp;
    }

    // OCP violation: switch + add-on branching + printing + persistence.
    public void process(BookingRequest req) {
        Money monthly = calculateMonthly(req);
        Money deposit = new Money(5000.00);

        ReceiptPrinter.print(req, monthly, deposit);

        String bookingId = "H-" + (7000 + new Random(1).nextInt(1000)); // deterministic-ish
        repo.save(bookingId, req, monthly, deposit);
    }

    private Money calculateMonthly(BookingRequest req) {
        double base = this.rpd.getRoomPrice(req.roomType);

        double add = this.atp.getTotalPrice(req.addOns);

        return new Money(base + add);
    }
}
