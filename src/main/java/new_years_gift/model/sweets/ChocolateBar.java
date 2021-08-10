package new_years_gift.model.sweets;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
public class ChocolateBar extends ChocolateCandy {
    String glaze;

    public ChocolateBar(String name, double price, int weight, int energyValue, String additive, String glaze) {
        super(name, price, weight, energyValue, additive);
        this.glaze = glaze;
    }

    @Override
    public int weigh() {
        return super.weigh();
    }

    @Override
    public String toString() {
        return super.toString() + ", Glaze: " + getGlaze() + "\n";
    }
}