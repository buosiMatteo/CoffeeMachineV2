package User;

import CoffeeMachine.Coffee;
import CoffeeMachine.CoffeeMachine;
import CoffeeMachine.TypeOfCoffee;
import CoffeeMachine.Money;

public interface CoffeeMachineOperationUser {

    Coffee getCoffee(CoffeeMachine coffeeMachine, TypeOfCoffee typeOfCoffee);

    void insertMoney(CoffeeMachine coffeeMachine, Integer cents);

    Money getRemainder(CoffeeMachine coffeeMachine);
}
