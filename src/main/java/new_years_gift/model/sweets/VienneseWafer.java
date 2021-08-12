package new_years_gift.model.sweets;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
public class VienneseWafer extends Wafer {
    String typeOfDough;

    public VienneseWafer(String name, double price, int weight, int energyValue, String filling) {
        super(name, price, weight, energyValue, filling);
    }

    @Override
    public String getFilling() {
        return super.getFilling();
    }

    @Override
    public int weigh() {
        return super.weigh();
    }

    @Override
    public String toString() {
        return super.toString() + ", Glaze: " + typeOfDough + "\n";
    }
}