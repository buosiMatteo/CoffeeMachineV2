import CoffeeMachine.CoffeeMachine;
import Technician.Technician;
import User.User;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        CoffeeMachine coffeeMachine = new CoffeeMachine();

        Technician mike = new Technician("Mike", "password");

        mike.rechargeCoffee(coffeeMachine, 10);
        mike.rechargeMilk(coffeeMachine, 10);

        User user = new User();

        System.out.print("Insert money in a coffeemachine: ");
        Scanner scanner = new Scanner(System.in);
        Integer centsToInsert = scanner.nextInt();
        user.insertMoney(coffeeMachine, centsToInsert);

        user.selectCoffee(coffeeMachine, scanner);

        mike.printCoffeeMade(coffeeMachine);
        mike.printMoneyInside(coffeeMachine);

        user.getRemainder(coffeeMachine);

        mike.printMoneyInside(coffeeMachine);


    }


}