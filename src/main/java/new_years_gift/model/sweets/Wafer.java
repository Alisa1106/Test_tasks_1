package new_years_gift.model.sweets;

import lombok.*;


@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
public class Wafer extends Sweet {
    private String filling;

    public Wafer(String name, double price, int weight, int energyValue, String filling) {
        super(name, price, weight, energyValue);
        this.filling = filling;
    }

    @Override
    public int weigh() {
        return getWeight();
    }

    @Override
    public String toString() {
        return super.toString() + ", Filling: " + getFilling() + "\n";
    }
}