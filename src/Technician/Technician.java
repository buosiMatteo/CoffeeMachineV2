package Technician;

import CoffeeMachine.CoffeeMachine;
import CoffeeMachine.Money;

public class Technician implements CoffeeMachineOperationTechnician {

    private String user;

    private String password;

    public Technician(String user, String password) {
        this.user = user;
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
        System.out.printf("\t - The portion of milk inside the coffeemachine are: %d", coffeeMachine.getPortionOfMilk());
    }

    @Override
    public void printCoffeeRemain(CoffeeMachine coffeeMachine) {
        System.out.printf("\t - The portion of milk inside the coffeemachine are: %d", coffeeMachine.getPortionOfCoffee());
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
