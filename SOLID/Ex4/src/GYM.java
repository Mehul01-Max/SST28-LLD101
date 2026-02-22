public class GYM implements IAddOn {

    @Override
    public double getPricing() {
        return 300.0;
    }

    @Override
    public AddOn getAddOn() {
        return AddOn.GYM;
    }

}
