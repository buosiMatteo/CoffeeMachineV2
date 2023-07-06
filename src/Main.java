import CoffeeMachine.CoffeeMachine;
import CoffeeMachine.Utenti;
import Technician.Technician;
import User.User;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        CoffeeMachine coffeeMachine = new CoffeeMachine();

        Technician mike = new Technician("Mike", "password");

        User utente = new User("Matteo");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Insert your username: ");
            String username = scanner.next();
            coffeeMachine.login(username);
            if (coffeeMachine.authenticatedUser instanceof Technician) {
                technicianMenu(coffeeMachine, coffeeMachine.authenticatedUser, scanner);
            } else if (coffeeMachine.authenticatedUser instanceof User) {
                usersMenu(coffeeMachine, coffeeMachine.authenticatedUser, scanner);
            }
            //login(coffeeMachine, mike, user, scanner);
            //login(coffeeMachine, mike, user, scanner);
        }
    }

    private static void usersMenu(CoffeeMachine coffeeMachine, Utenti utente, Scanner scanner) {
        User user=(User)utente;
        boolean hasNextLine = true;
        while (hasNextLine) {
            System.out.println("Users menu:");
            System.out.println("\t - A : Select Coffee");
            System.out.println("\t - B : Insert money");
            System.out.println("\t - C : Reclaim change");
            System.out.println("\t - X : Exit from menu");
            System.out.print("Select a character for do that action:");
            char optionChoose = scanner.next().toUpperCase().trim().charAt(0);
            switch (optionChoose) {
                case 'A':
                    user.selectCoffee(coffeeMachine, scanner);
                    break;
                case 'B':
                    System.out.print("Insert money in a coffee machine: ");
                    Integer centsToInsert = scanner.nextInt();
                    user.insertMoney(coffeeMachine, centsToInsert);
                    break;
                case 'C':
                    user.getRemainder(coffeeMachine);
                    break;
                case 'X':
                    hasNextLine = false;
                    break;
                default:
                    System.out.println("Letter didn't recognized");
            }
        }
    }

    private static void technicianMenu(CoffeeMachine coffeeMachine, Utenti user, Scanner scanner) {
        Technician mike=(Technician)user;
        boolean hasNextLine = true;
        while (hasNextLine) {
            System.out.println("Menu del tecnico:");
            System.out.println("\t - A : recharge coffee");
            System.out.println("\t - B : recharge milk");
            System.out.println("\t - C : verify quantity of coffee");
            System.out.println("\t - D : verify quantity of milk");
            System.out.println("\t - E : print quantity of money in the machine");
            System.out.println("\t - F : print quantity of coffee that the machine already done");
            System.out.println("\t - X : Exit from menu");

            System.out.print("Select a character for do that action:");
            char optionChoose = scanner.next().toUpperCase().trim().charAt(0);
            switch (optionChoose) {
                case 'A':
                    System.out.println("How much coffee do you want refill?");
                    int coffeeToRefill = scanner.nextInt();
                    mike.rechargeCoffee(coffeeMachine, coffeeToRefill);
                    break;
                case 'B':
                    System.out.println("How much milk do you want refill?");
                    int milkToRefill = scanner.nextInt();
                    mike.rechargeMilk(coffeeMachine, milkToRefill);
                    break;
                case 'C':
                    mike.printCoffeeRemain(coffeeMachine);
                    break;
                case 'D':
                    mike.printMilkRemain(coffeeMachine);
                    break;
                case 'E':
                    mike.printMoneyInside(coffeeMachine);
                    break;
                case 'F':
                    mike.printCoffeeMade(coffeeMachine);
                    break;
                case 'X':
                    hasNextLine = false;
            }
        }
    }

    /*
    private static void login(CoffeeMachine coffeeMachine, Technician mike, User user, Scanner scanner) {
        String utente;
        System.out.print("Insert the username: ");
        utente = scanner.next();
        if (validateUsername(utente, Technician.technicians)) {
            System.out.print("Insert the password: ");
            String password = scanner.next();
            if (validatePassword(password, Technician.technicians)) {
                technicianMenu(coffeeMachine, mike, scanner);
            }
        } else {
            usersMenu(coffeeMachine, user, scanner);
        }
    }

    public static boolean validateUsername(String user, Map<String, Technician> technicians) {
        for (Technician technician : technicians) {
            if (technician.getUsername().equalsIgnoreCase(user)) {
                return true;
            }
        }
        return false;
    }

    public static boolean validatePassword(String password, Map<String, Technician> technicians) {
        for (Technician technician : technicians) {
            if (technician.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

     */
}

