public interface RoomPricing {
    boolean isApplicable(int LegacyFlagCriteria);

    double getPricing();
}
