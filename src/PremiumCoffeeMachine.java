import java.util.HashMap;
import java.util.Map;

import coffee_bin.Coffee;
import coffee_bin.CoffeeBean;
import coffee_bin.CoffeeGrounds;
import cupboard.*;
public class PremiumCoffeeMachine implements CoffeeMachine {
    final private Map<CoffeeSelection, Configuration> configMap;
    final private Map<CoffeeSelection, CoffeeBean> beans;
    final private Grinder grinder;
    final private BrewingUnit brewingUnit;
    public PremiumCoffeeMachine(Map<CoffeeSelection, CoffeeBean> beans) {
        this.beans = beans;
        this.grinder = new Grinder();
        this.brewingUnit = new BrewingUnit();
        this.configMap = new HashMap<>();
        this.configMap.put(CoffeeSelection.FILTER_COFFEE, new Configuration(30, 480));
        this.configMap.put(CoffeeSelection.ESPRESSO, new Configuration(8, 28));
    }

    public Coffee brewCoffee(CoffeeSelection selection) throws CoffeeException {
        return switch (selection) {
            case ESPRESSO -> brewEspresso();
            case FILTER_COFFEE -> brewFilterCoffee();
            default -> throw new CoffeeException("CoffeeSelection [" + selection + "] not supported!");
        };
    }
    public Coffee brewEspresso() {
        Configuration config = configMap.get(CoffeeSelection.ESPRESSO);
        // grind the coffee beans
        CoffeeGrounds coffeeGrounds = this.grinder.grind(
                this.beans.get(CoffeeSelection.ESPRESSO),
                config.getQuantityCoffee());
        // brew an espresso
        return this.brewingUnit.brew(CoffeeSelection.ESPRESSO, coffeeGrounds,
                config.getQuantityWater());
    }
    public Coffee brewFilterCoffee() {
        Configuration config = configMap.get(CoffeeSelection.FILTER_COFFEE);
        // grind the coffee beans
        CoffeeGrounds coffeeGrounds = this.grinder.grind(
                this.beans.get(CoffeeSelection.FILTER_COFFEE),
                config.getQuantityCoffee());
        // brew a filter coffee
        return this.brewingUnit.brew(CoffeeSelection.FILTER_COFFEE, coffeeGrounds,
                config.getQuantityWater());
    }
    public void addCoffeeBeans(CoffeeSelection sel, CoffeeBean newBeans) throws CoffeeException {
        CoffeeBean existingBeans = this.beans.get(sel);
        if (existingBeans != null) {
            if (existingBeans.getName().equals(newBeans.getName())) {
                existingBeans.setQuantity(existingBeans.getQuantity() + newBeans.getQuantity());
            } else {
                throw new CoffeeException("Only one kind of coffee supported for each CoffeeSelection.");
            }
        } else {
            this.beans.put(sel, newBeans);
        }
    }
}