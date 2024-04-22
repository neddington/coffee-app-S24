import java.util.HashMap;
import java.util.Map;

import coffee_bin.Coffee;
import coffee_bin.CoffeeBean;
import coffee_bin.CoffeeGrounds;
import cupboard.*;



public class CoffeeApp {
    final private CoffeeMachine coffeeMachine;
    public CoffeeApp(CoffeeMachine coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
    }
    public Coffee prepareCoffee(CoffeeSelection selection) throws CoffeeException {
        return this.coffeeMachine.brewCoffee(selection);
    }
    public static void main(String[] args) {
        // Prepare coffee grounds
        Map<CoffeeSelection, CoffeeGrounds> grounds = new HashMap<>();
        grounds.put(CoffeeSelection.FILTER_COFFEE, new CoffeeGrounds("French Roast"));
        //Prepare coffee beans
        Map<CoffeeSelection, CoffeeBean> beans = new HashMap<>();
        beans.put(CoffeeSelection.ESPRESSO, new CoffeeBean("Dolce Espresso", 1000));
        beans.put(CoffeeSelection.FILTER_COFFEE, new CoffeeBean("Light Roast", 1000));
        beans.put(CoffeeSelection.LATTE, new CoffeeBean("Dark Roast", 1000));

        //TODO: Test your Software Design against the assignment OUTPUT by uncommenting EACH of the two lines below, ONE at a time
        //RegularCoffeeMachine machine = new RegularCoffeeMachine(grounds);
        PremiumCoffeeMachine machine = new PremiumCoffeeMachine(beans);
        //TODO: END

        // Instantiate CoffeeApp with ANY CoffeeMachine
        CoffeeApp app = new CoffeeApp(machine);
        // Brew some coffee
        try {
            //First Cup
            Coffee c = app.prepareCoffee(CoffeeSelection.FILTER_COFFEE);
            System.out.printf("Your coffee is ready. Smells like %s\n\n", c.getName());

            //Second Cup
            c = app.prepareCoffee(CoffeeSelection.ESPRESSO);
            System.out.printf("Your second cup of coffee is ready. Smells like %s\n\n", c.getName());

            //Third Cup
            c = app.prepareCoffee(CoffeeSelection.LATTE);
            System.out.printf("Your third cup of coffee is ready. Smells like %s", c.getName());

        } catch (CoffeeException e) {
            System.out.print("THIS cup didn't brew:" + e.toString());
        }
    } // end main
} // end CoffeeApp