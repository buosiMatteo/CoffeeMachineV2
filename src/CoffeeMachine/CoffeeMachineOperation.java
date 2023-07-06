package CoffeeMachine;

public interface CoffeeMachineOperation {

    public Coffee doCoffee(TypeOfCoffee typeOfCoffee);

    public Money getRemainder(Integer cents);

    public void chargeMoney(Integer cents);

    public void login(String username);
}
