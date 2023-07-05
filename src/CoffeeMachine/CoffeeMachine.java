package CoffeeMachine;

public class CoffeeMachine implements CoffeeMachineOperation {

    private static final Integer priceOfCoffee = 60;

    private int numberOfCoffeeDone;

    private Integer portionOfCoffee;

    private Integer portionOfMilk;


    private final Money ammountOfMoney = new Money();

    private Money moneyOfUser = new Money();

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
                        System.out.println("Coffee is not enough");
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
                        System.out.println("Coffee or milk is not enough");
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
                        System.out.println("CoffeeMachine.Coffee or milk is not enough");
                        return null;
                    }
                default:
                    System.out.println("Type of coffee not available");
                    return null;
            }
        } else {
            System.out.println("CoffeeMachine.Money is not enought,sorry");
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
}
