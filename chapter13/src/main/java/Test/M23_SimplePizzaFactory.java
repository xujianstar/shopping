package Test;

public class M23_SimplePizzaFactory {

    public static void main(String[] args) {
        M23_SimplePizzaFactory factory = new M23_SimplePizzaFactory();
        Pizza pizza = factory.createPizza("CheesePizza");
        pizza.taste();
        pizza = factory.createPizza("GreekPizza");
        pizza.taste();
        pizza = factory.createPizza("PepperPizza");
        pizza.taste();
    }
    public Pizza createPizza(String pizzaType){
        if("CheesePizza".equals(pizzaType)){
            return new CheesePizza();
        }else if ("GreekPizza".equals(pizzaType)){
            return new GreekPizza();
        }else if ("PepperPizza".equals(pizzaType)){
            return new PepperPizza();
        }else{
            return null;
        }
    }
}




interface Pizza{
    public void taste();
}
class CheesePizza implements Pizza{
    private String name = "CheesePizza";
    @Override
    public void taste() {
        System.out.println(this.name);
    }
}
class GreekPizza implements Pizza{
    private String name = "GreekPizza";
    @Override
    public void taste() {
        System.out.println(this.name);
    }
}
class PepperPizza implements Pizza{
    private String name = "PepperPizza";
    @Override
    public void taste() {
        System.out.println(this.name);
    }
}