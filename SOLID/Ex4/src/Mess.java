public class Mess implements IAddOn {

    @Override
    public double getPricing() {
        return 1000.0;
    }

    @Override
    public AddOn getAddOn() {
        return AddOn.MESS;
    }
}
