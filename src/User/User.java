package User;

import CoffeeMachine.Coffee;
import CoffeeMachine.CoffeeMachine;
import CoffeeMachine.TypeOfCoffee;
import CoffeeMachine.Money;

import java.util.Scanner;


public class User implements CoffeeMachineOperationUser {


    @Override
    public Coffee getCoffee(CoffeeMachine coffeeMachine, TypeOfCoffee typeOfCoffee) {
        return coffeeMachine.doCoffee(typeOfCoffee);
    }

    public void selectCoffee(CoffeeMachine coffeeMachine, Scanner scanner) {
        System.out.print("Select the coffee you want (ESPRESSO, MACCHIATO; CAPUCCINO): ");
        String typeOfCofee = scanner.next().trim().toUpperCase();
        switch (typeOfCofee) {
            case "ESPRESSO":
                getCoffee(coffeeMachine, TypeOfCoffee.ESPRESSO);
                break;
            case "MACCHIATO":
                getCoffee(coffeeMachine, TypeOfCoffee.MACCHIATO);
                break;
            case "CAPUCCINO":
                getCoffee(coffeeMachine, TypeOfCoffee.CAPPUCCINO);
                break;
            default:
                System.out.println("Your choose is not valid");
        }
    }

    @Override
    public void insertMoney(CoffeeMachine coffeeMachine, Integer cents) {
        coffeeMachine.chargeMoney(cents);

    }

    @Override
    public Money getRemainder(CoffeeMachine coffeeMachine) {
        System.out.printf("The coffeemachine returns to you %d cents\n", coffeeMachine.getMoneyOfUser().getCents());
        return coffeeMachine.getMoneyOfUser();
    }


}
