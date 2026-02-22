import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Hostel Fee Calculator ===");
        BookingRequest req = new BookingRequest(LegacyRoomTypes.DOUBLE, List.of(AddOn.LAUNDRY, AddOn.MESS));
        List<RoomPricing> rp = List.of(new SingleRoom(), new DoubleRoom(), new TripleRoom(), new DefaultRoom());
        List<IAddOn> atp = List.of(new GYM(), new Laundary(), new Mess());
        HostelFeeCalculator calc = new HostelFeeCalculator(new FakeBookingRepo(), new RoomPricingDecider(rp),
                new AddOnTotalPricing(atp));
        calc.process(req);
    }
}
