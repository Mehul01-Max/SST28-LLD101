public class TripleRoom implements RoomPricing {

    @Override
    public boolean isApplicable(int LegacyFlagCriteria) {
        if (LegacyFlagCriteria == LegacyRoomTypes.TRIPLE) {
            return true;
        }
        return false;
    }

    @Override
    public double getPricing() {
        return 12000.0;
    }
}
