package Technician;

import CoffeeMachine.CoffeeMachine;
import CoffeeMachine.Money;

public interface CoffeeMachineOperationTechnician {

    void rechargeCoffee(CoffeeMachine coffeeMachine, Integer portionOfCoffee);

    void rechargeMilk(CoffeeMachine coffeeMachine, Integer portionOfMilk);

    void printCoffeeRemain(CoffeeMachine coffeeMachine);

    void printMilkRemain(CoffeeMachine coffeeMachine);

    void printCoffeeMade(CoffeeMachine coffeeMachine);

    void printMoneyInside(CoffeeMachine coffeeMachine);

    Money extractMoney(CoffeeMachine coffeeMachine);

}
