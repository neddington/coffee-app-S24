// CoffeeMachine.java

import coffee_bin.Coffee;
import coffee_bin.CoffeeBean;
import coffee_bin.CoffeeGrounds;
import cupboard.*;

public interface CoffeeMachine {
    Coffee brewCoffee(CoffeeSelection selection) throws CoffeeException;
}