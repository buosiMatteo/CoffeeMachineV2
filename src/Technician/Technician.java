package Technician;
import CoffeeMachine.Utenti;
import CoffeeMachine.CoffeeMachine;
import CoffeeMachine.Money;

import java.util.HashMap;
import java.util.Map;

public class Technician extends Utenti implements CoffeeMachineOperationTechnician {

    public static Map<String, Technician> technicians = new HashMap<String, Technician>();
    private String username;

    private String password;

    public Technician(String username, String password) {
        this.username = username;
        this.password = password;
        technicians.put(username,this);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void rechargeCoffee(CoffeeMachine coffeeMachine, Integer portionOfCoffee) {
        coffeeMachine.setPortionOfCoffee(portionOfCoffee);
    }

    @Override
    public void rechargeMilk(CoffeeMachine coffeeMachine, Integer portionOfMilk) {
        coffeeMachine.setPortionOfMilk(portionOfMilk);
    }

    @Override
    public void printMilkRemain(CoffeeMachine coffeeMachine) {
        System.out.printf("\t - The portion of milk inside the coffee machine are: %d\n", coffeeMachine.getPortionOfMilk());
    }

    @Override
    public void printCoffeeRemain(CoffeeMachine coffeeMachine) {
        System.out.printf("\t - The portion of coffee inside the coffee machine are: %d\n", coffeeMachine.getPortionOfCoffee());
    }

    @Override
    public void printCoffeeMade(CoffeeMachine coffeeMachine) {
        System.out.printf("\t - The number of coffee made is: %d\n", coffeeMachine.getNumberOfCoffeeDone());
    }

    @Override
    public void printMoneyInside(CoffeeMachine coffeeMachine) {
        System.out.printf("\t - The cents inside the coffee machine are: %d\n", coffeeMachine.getAmmountOfMoney().getCents());
    }

    @Override
    public Money extractMoney(CoffeeMachine coffeeMachine) {
        Money money = coffeeMachine.getAmmountOfMoney();
        coffeeMachine.setAmountOfMoney(0);
        return money;

    }

}
