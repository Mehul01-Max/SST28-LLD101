public class DefaultRoom implements RoomPricing {

    @Override
    public boolean isApplicable(int LegacyFlagCriteria) {
        return true;
    }

    @Override
    public double getPricing() {
        return 16000.0;
    }
}
