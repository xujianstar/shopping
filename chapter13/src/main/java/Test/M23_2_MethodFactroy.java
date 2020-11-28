package Test;

public class M23_2_MethodFactroy {
    public static void main(String[] args) {
        PizzaFactory factory = new LD_PizzaFactory();
        Pizzaa pizzaa =  factory.createPizza("LD_CheesePizza");
        pizzaa.taste();

    }
}

interface PizzaFactory{
    public Pizzaa createPizza(String pizzaType);
}
class LD_PizzaFactory implements PizzaFactory{
    @Override
    public Pizzaa createPizza(String pizzaType){
        if("LD_CheesePizza".equals(pizzaType)){
            return new LD_CheesePizza();
        }else if("LD_GreekPizza".equals(pizzaType)){
            return new LD_GreekPizza();
        }else if("LD_PepperPizza".equals(pizzaType)){
            return new LD_GreekPizza();
        }else {
            return new LD_PepperPizza();
        }
    }
}


interface Pizzaa{
    public void taste();
}
class LD_CheesePizza implements Pizzaa{
    private String name = "LD_CheesePizza";
    @Override
    public void taste() {
        System.out.println(this.name);
    }
}
class LD_GreekPizza implements Pizzaa{
    private String name = "LD_GreekPizza";
    @Override
    public void taste() {
        System.out.println(this.name);
    }
}
class LD_PepperPizza implements Pizzaa{
    private String name = "LD_PepperPizza";
    @Override
    public void taste() {
        System.out.println(this.name);
    }
}