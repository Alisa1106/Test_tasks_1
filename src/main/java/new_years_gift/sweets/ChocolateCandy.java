package new_years_gift.sweets;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
public class ChocolateCandy extends Sweet {
    private String additive;

    public ChocolateCandy(String name, double price, int weight, int energyValue, String additive) {
        super(name, price, weight, energyValue);
        this.additive = additive;
    }

    @Override
    public int weigh() {
        return getWeight();
    }

    @Override
    public String toString() {
        return super.toString() + ", Additive: " + getAdditive() + "\n";
    }
}