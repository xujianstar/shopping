package Test;

public class M23_16_MediatorModel {
    public static void main(String[] args) {
        Mediator mediator = new  ConcreteMediator();
        mediator.notice("a");
        mediator.notice("b");
    }
}


abstract class Mediator{
    public abstract void notice(String event);
}

class ConcreteMediator extends Mediator{
    private ColleagueA colleagueA = new ColleagueA() ;
    private ColleagueB colleagueB = new ColleagueB();
    @Override
    public void notice(String event) {
        if("a".equals(event)){
            colleagueA.action();
        }
        if("b".equals(event)){
            colleagueB.action();
        }


    }
}

abstract class Colleague{
    public abstract void action();
}

class ColleagueA extends Colleague{
    @Override
    public void action() {
        System.out.println("同事ColleagueA负责处理");
    }
}
class ColleagueB extends Colleague{
    @Override
    public void action() {
        System.out.println("同事ColleagueB负责处理");
    }
}