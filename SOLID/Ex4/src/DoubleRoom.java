public class DoubleRoom implements RoomPricing {

    @Override
    public boolean isApplicable(int LegacyFlagCriteria) {
        if (LegacyFlagCriteria == LegacyRoomTypes.DOUBLE) {
            return true;
        }
        return false;
    }

    @Override
    public double getPricing() {
        return 15000.0;
    }
}
