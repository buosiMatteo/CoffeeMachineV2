package Technician;

import CoffeeMachine.CoffeeMachine;
import CoffeeMachine.Money;

import java.util.HashSet;
import java.util.Set;

public class Technician implements CoffeeMachineOperationTechnician {

    public static Set<Technician> technicians = new HashSet<Technician>();

    private String user;

    private String password;

    public Technician(String user, String password) {
        this.user = user;
        this.password = password;
        technicians.add(this);
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
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
        System.out.printf("\t - The portion of milk inside the coffeemachine are: %d\n", coffeeMachine.getPortionOfMilk());
    }

    @Override
    public void printCoffeeRemain(CoffeeMachine coffeeMachine) {
        System.out.printf("\t - The portion of coffee inside the coffeemachine are: %d\n", coffeeMachine.getPortionOfCoffee());
    }

    @Override
    public void printCoffeeMade(CoffeeMachine coffeeMachine) {
        System.out.printf("\t - The number of coffee made is: %d\n", coffeeMachine.getNumberOfCoffeeDone());
    }

    @Override
    public void printMoneyInside(CoffeeMachine coffeeMachine) {
        System.out.printf("\t - The cents inside the Coffemachine are: %d\n", coffeeMachine.getAmmountOfMoney().getCents());
    }

    @Override
    public Money extractMoney(CoffeeMachine coffeeMachine) {
        Money money = coffeeMachine.getAmmountOfMoney();
        coffeeMachine.setAmountOfMoney(0);
        return money;

    }

}
