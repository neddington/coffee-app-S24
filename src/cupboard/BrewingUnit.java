package cupboard;

import coffee_bin.Coffee;
import coffee_bin.CoffeeDrink;

public class BrewingUnit {
    public Coffee brew(CoffeeSelection selection, Coffee coffee, int amountWater){
        System.out.println("Brewing...");
        return new CoffeeDrink(coffee.getName());
    }
}
