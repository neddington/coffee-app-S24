import coffee_bin.Coffee;
import coffee_bin.CoffeeGrounds;
import cupboard.*;

import java.util.Map;

public class RegularCoffeeMachine {

    private final Configuration config;
    private final Map<CoffeeSelection, CoffeeGrounds> groundCoffee;
    private final BrewingUnit brewingUnit;

    public RegularCoffeeMachine(Map<CoffeeSelection, CoffeeGrounds> grounds){
        this.groundCoffee = grounds;
        this.brewingUnit = new BrewingUnit();
        this.config = new Configuration(30, 480);
    }


    public Coffee brewCoffee(CoffeeSelection selection) throws CoffeeException {
        // get the coffee
        CoffeeGrounds groundCoffee = this.groundCoffee.get(CoffeeSelection.FILTER_COFFEE);
        // brew a filter coffee  
       return this.brewingUnit.brew(CoffeeSelection.FILTER_COFFEE, groundCoffee, this.config.getQuantityWater());
    }

    public void addCoffeeGrounds(CoffeeSelection sel, CoffeeGrounds newCoffee) throws CoffeeException {
        CoffeeGrounds existingCoffee = this.groundCoffee.get(sel);
        if (existingCoffee != null) {
            if (existingCoffee.getName().equals(newCoffee.getName())) {
                existingCoffee.setQuantity(existingCoffee.getQuantity() + newCoffee.getQuantity());
            } else {
                throw new CoffeeException("Only one kind of coffee supported for each CoffeeSelection.");
            }
        } else {
            this.groundCoffee.put(sel, newCoffee);
        }
    }
}
