package cupboard;

import coffee_bin.CoffeeBean;
import coffee_bin.CoffeeGrounds;

public class Grinder {
    public CoffeeGrounds grind(CoffeeBean beanCoffee, int amountCoffee){
        System.out.println("Grinding beans ...");
        return new CoffeeGrounds(beanCoffee.getName());
    }
}
