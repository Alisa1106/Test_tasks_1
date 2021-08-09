package new_years_gift.sweets;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
public class Lollipop extends Sweet {
    private String taste;

    public Lollipop(String name, double price, int weight, int energyValue, String taste) {
        super(name, price, weight, energyValue);
        this.taste = taste;
    }

    @Override
    public int weigh() {
        return getWeight();
    }

    @Override
    public String toString() {
        return super.toString() + ", Taste: " + getTaste() + "\n";
    }
}