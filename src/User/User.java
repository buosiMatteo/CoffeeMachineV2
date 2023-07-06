package User;

import CoffeeMachine.Coffee;
import CoffeeMachine.CoffeeMachine;
import CoffeeMachine.TypeOfCoffee;
import CoffeeMachine.Money;
import CoffeeMachine.Utenti;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;


public class User extends Utenti implements CoffeeMachineOperationUser {

    public static Map<String, User>users = new HashMap<String, User>();
    private final String username;

    public User(String username) {
        this.username = username;
        users.put(username, this);
    }

    @Override
    public Coffee getCoffee(CoffeeMachine coffeeMachine, TypeOfCoffee typeOfCoffee) {
        System.out.printf("\nHere your %s coffee\n" , typeOfCoffee);
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
