public class SingleRoom implements RoomPricing {

    @Override
    public boolean isApplicable(int LegacyFlagCriteria) {
        if (LegacyFlagCriteria == LegacyRoomTypes.SINGLE) {
            return true;
        }
        return false;
    }

    @Override
    public double getPricing() {
        return 14000.0;
    }
}
