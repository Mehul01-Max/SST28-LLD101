public class Laundary implements IAddOn {

    @Override
    public double getPricing() {
        return 500.0;
    }

    @Override
    public AddOn getAddOn() {
        return AddOn.LAUNDRY;
    }

}