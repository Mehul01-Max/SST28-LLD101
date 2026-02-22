import java.util.*;

public class RoomPricingDecider {
    List<RoomPricing> roomPricings;

    public RoomPricingDecider(List<RoomPricing> roomPricings) {
        this.roomPricings = roomPricings;
    }

    public double getRoomPrice(int LegacyFlagCriteria) {
        for (RoomPricing rp : roomPricings) {
            if (rp.isApplicable(LegacyFlagCriteria)) {
                return rp.getPricing();
            }
        }
        return new DefaultRoom().getPricing();
    }
}
