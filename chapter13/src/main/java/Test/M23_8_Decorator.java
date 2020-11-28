package Test;

public class M23_8_Decorator {
    public static void main(String[] args) {
        Decorator  decorator =new  ConcreteDecoratorA();
        decorator.setPerson(new Man8());
        decorator.eat();

        Decorator  decoratorb =new ConcreteDecoratorB();
        decoratorb.setPerson(new Man8());
        decoratorb.eat();

    }
}

interface Person8{
    public void eat();
}
class Man8 implements  Person8{
    @Override
    public void eat() {
        System.out.println("男人在吃饭");
    }
}

abstract class  Decorator implements Person8{
    Person8 person8 = null;
    @Override
    public void eat(){
        person8.eat();
    }
    public void setPerson(Person8 person8){
        this.person8 = person8;
    }
}

class  ConcreteDecoratorA extends Decorator{
    @Override
    public void eat(){
        super.eat();
        reEat();
        System.out.println("ConcreteDecoratorA");
    }
    public void reEat() {
        System.out.println("再吃一顿饭");
    }
}

class  ConcreteDecoratorB extends Decorator{
    @Override
    public void eat(){
        super.eat();
        reEat();
        System.out.println("ConcreteDecoratorB");
    }
    public void reEat() {
        System.out.println("再吃一顿大餐");
    }
}

