package pizza_shoping;

abstract class Pizza {
	    protected String name;
	    protected double basePrice;
	    protected boolean extraCheese = false;
	    protected boolean extraToppings = false;
	    protected boolean takeAway = false;
	    protected static final double CHEESE_PRICE = 100;
	    protected static final double TOPPING_PRICE = 150;
	    protected static final double TAKEAWAY_PRICE = 20;

	    public Pizza(String name, double basePrice) {
	        this.name = name;
	        this.basePrice = basePrice;
	    }

	    public void addExtraCheese() {
	        this.extraCheese = true;
	    }

	    public void addExtraToppings() {
	        this.extraToppings = true;
	    }

	    public void optTakeAway() {
	        this.takeAway = true;
	    }

	    public double calculatePrice() {
	        double totalPrice = basePrice;
	        if (extraCheese) {
	            totalPrice += CHEESE_PRICE;
	        }
	        if (extraToppings) {
	            totalPrice += TOPPING_PRICE;
	        }
	        if (takeAway) {
	            totalPrice += TAKEAWAY_PRICE;
	        }
	        return totalPrice;
	    }

	    public String getName() {
	        return name;
	    }

	    public abstract void printDetails();
}

class VegPizza extends Pizza {
    public VegPizza() {
        super("Veg Pizza", 300);
    }

    @Override
    public void printDetails() {
        System.out.println(name + " - Rs. " + basePrice);
    }
}

class NonVegPizza extends Pizza {
    public NonVegPizza() {
        super("Non-Veg Pizza", 400);
    }

    @Override
    public void printDetails() {
        System.out.println(name + " - Rs. " + basePrice);
    }
}

class DeluxeVegPizza extends Pizza {
    public DeluxeVegPizza() {
        super("Deluxe Veg Pizza", 550);
    }

    @Override
    public void printDetails() {
        System.out.println(name + " (Loaded with extra cheese and toppings) - Rs. " + basePrice);
    }
}

class DeluxeNonVegPizza extends Pizza {
    public DeluxeNonVegPizza() {
        super("Deluxe Non-Veg Pizza", 650);
    }

    @Override
    public void printDetails() {
        System.out.println(name + " (Loaded with extra cheese and toppings) - Rs. " + basePrice);
    }
}




