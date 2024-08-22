package pizza_shoping;

import java.util.Scanner;

class BillGenerator {
    private Pizza pizza;

    public void takeOrder() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Pizzamania!");
        System.out.println("Select your Pizza:");
        System.out.println("1. Veg Pizza");
        System.out.println("2. Non-Veg Pizza");
        System.out.println("3. Deluxe Veg Pizza");
        System.out.println("4. Deluxe Non-Veg Pizza");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                pizza = new VegPizza();
                break;
            case 2:
                pizza = new NonVegPizza();
                break;
            case 3:
                pizza = new DeluxeVegPizza();
                break;
            case 4:
                pizza = new DeluxeNonVegPizza();
                break;
            default:
                System.out.println("Invalid selection. Exiting...");
                return;
        }

        if (!(pizza instanceof DeluxeVegPizza || pizza instanceof DeluxeNonVegPizza)) {
            System.out.println("Would you like to add extra cheese? (yes/no)");
            if (scanner.next().equalsIgnoreCase("yes")) {
                pizza.addExtraCheese();
            }

            System.out.println("Would you like to add extra toppings? (yes/no)");
            if (scanner.next().equalsIgnoreCase("yes")) {
                pizza.addExtraToppings();
            }
        }

        System.out.println("Would you like to opt for takeaway? (yes/no)");
        if (scanner.next().equalsIgnoreCase("yes")) {
            pizza.optTakeAway();
        }

        generateBill();
    }

    public void generateBill() {
        System.out.println("----- Pizzamania Bill -----");
        pizza.printDetails();

        if (pizza.extraCheese) {
            System.out.println("Extra Cheese - Rs. " + Pizza.CHEESE_PRICE);
        }

        if (pizza.extraToppings) {
            System.out.println("Extra Toppings - Rs. " + Pizza.TOPPING_PRICE);
        }

        if (pizza.takeAway) {
            System.out.println("Takeaway Charges - Rs. " + Pizza.TAKEAWAY_PRICE);
        }

        System.out.println("---------------------------");
        System.out.println("Total: Rs. " + pizza.calculatePrice());
    }
}

