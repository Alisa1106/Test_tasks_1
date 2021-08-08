package new_years_gift.sweets;

import lombok.*;

@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@Data
public abstract class Sweet {

    private String name;
    private double price;
    private int weight;
    private int energyValue;

    @Override
    public String toString() {
        return "Name: " + getName() +", Price: " + getPrice() + ", Weight: " + getWeight() + ", EnergyValue: " + getEnergyValue();
    }
}