import java.util.*;

public class AddOnTotalPricing {
    List<IAddOn> addons;

    public AddOnTotalPricing(List<IAddOn> addons) {
        this.addons = addons;
    }

    public double getTotalPrice(List<AddOn> a) {
        double price = 0.0;
        for (IAddOn e : addons) {
            if (a.contains(e.getAddOn())) {
                price += e.getPricing();
            }
        }
        return price;
    }
}
