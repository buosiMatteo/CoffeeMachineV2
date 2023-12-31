package CoffeeMachine;

import Technician.Technician;
import User.User;

import java.util.Scanner;

public class CoffeeMachine implements CoffeeMachineOperation {

    private static final Integer priceOfCoffee = 60;

    private int numberOfCoffeeDone;

    private int portionOfCoffee;

    private int portionOfMilk;


    private final Money ammountOfMoney = new Money();

    private Money moneyOfUser = new Money();

    public Utenti authenticatedUser;

    public int getNumberOfCoffeeDone() {
        return numberOfCoffeeDone;
    }


    public Money getAmmountOfMoney() {
        return ammountOfMoney;
    }

    public void setAmountOfMoney(Integer cents) {
        this.ammountOfMoney.setCents(cents);
    }

    public Money getMoneyOfUser() {
        return moneyOfUser;
    }


    public Integer getPortionOfCoffee() {
        return portionOfCoffee;
    }

    public void setPortionOfCoffee(Integer portionOfCoffee) {
        this.portionOfCoffee = portionOfCoffee;
    }

    public Integer getPortionOfMilk() {
        return portionOfMilk;
    }

    public void setPortionOfMilk(Integer portionOfMilk) {
        this.portionOfMilk = portionOfMilk;
    }


    @Override
    public Coffee doCoffee(TypeOfCoffee typeOfCoffee) {
        if (moneyOfUser.getCents() >= priceOfCoffee) {
            moneyOfUser = getRemainder(moneyOfUser.getCents() - priceOfCoffee);
            switch (typeOfCoffee) {
                case ESPRESSO:
                    if (portionOfCoffee > 0) {
                        numberOfCoffeeDone++;
                        portionOfCoffee--;
                        System.out.println("Here your Espresso");
                        return new Espresso();
                    } else {
                        System.out.println("Coffee is not enough to make your ESPRESSO");
                        return null;
                    }
                case MACCHIATO:
                    if (portionOfCoffee > 0 && portionOfMilk > 0) {
                        numberOfCoffeeDone++;
                        portionOfCoffee--;
                        portionOfMilk--;
                        System.out.println("Here your Macchiato");
                        return new Macchiato();
                    } else {
                        System.out.println("Coffee or milk is not enough to make your MACCHIATO");
                        return null;
                    }
                case CAPPUCCINO:
                    if (portionOfCoffee > 0 && portionOfMilk > 1) {
                        numberOfCoffeeDone++;
                        portionOfCoffee--;
                        portionOfMilk -= 2;
                        System.out.println("Here your Capuccino");
                        return new Capuccino();
                    } else {
                        System.out.println("Coffee or milk is not enough to make your CAPUCCINO");
                        return null;
                    }
                default:
                    System.out.println("Type of coffee not available");
                    return null;
            }
        } else {
            System.out.println("Money is not enought,sorry");
            return null;
        }
    }

    @Override
    public Money getRemainder(Integer cents) {
        moneyOfUser.setCents(cents);
        ammountOfMoney.setCents(ammountOfMoney.getCents() - cents);
        return moneyOfUser;
    }

    @Override
    public void chargeMoney(Integer cents) {
        Integer totalMoney = cents + ammountOfMoney.getCents();
        ammountOfMoney.setCents(totalMoney);
        this.moneyOfUser.setCents(cents);
    }

    public void login(String username){
        if (Technician.technicians.containsKey(username)){
            System.out.print("Insert password: ");
            Scanner scanner = new Scanner(System.in);
            String password = scanner.nextLine();
            if (Technician.technicians.get(username).getPassword().equals(password)){
                System.out.printf("You're logged like %s\n",username);
                authenticatedUser = Technician.technicians.get(username);
                return;
            } else {
                System.out.println("Your password is not correct");
                return;
            }
        } else if (User.users.containsKey(username)) {
            System.out.printf("You're logged like %s\n",username);
            authenticatedUser= User.users.get(username);
            return;
        } else {
            System.out.println("Your username is not correct");
            return;
        }
    }
}
