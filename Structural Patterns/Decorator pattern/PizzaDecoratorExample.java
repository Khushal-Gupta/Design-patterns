interface Pizza {
    String getDescription();
    double getCost();
}

class SimplePizza implements Pizza {

    @Override
    public String getDescription() {
        return "Simple Pizza";
    }

    @Override
    public double getCost() {
        return 5.0;
    }
}

abstract class PizzaDecorator implements Pizza {
    protected Pizza pizza;

    PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }
}

class CheeseDecorator extends PizzaDecorator {

    CheeseDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " with cheese";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 10.0;
    }
}

class PepperoniDecorator extends PizzaDecorator {

    PepperoniDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " with pepperoni";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 7.0;
    }
}

public class PizzaDecoratorExample {

    public static void main(String args[]) {
        Pizza pizza = new SimplePizza();
        System.out.println(pizza.getDescription());

        pizza = new CheeseDecorator(pizza);
        System.out.println(pizza);

        pizza = new PepperoniDecorator(pizza);
        System.out.println(pizza);
    }
}