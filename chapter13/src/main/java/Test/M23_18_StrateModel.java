package Test;

public class M23_18_StrateModel {
    public static void main(String[] args) {
        ContextMsg contextMsg = new ContextMsg(new StrategyA());
        contextMsg.method();
    }
}
class ContextMsg {
    Strategy strategy ;
    public ContextMsg(Strategy strategy){
        this.strategy = strategy;
    }
    public void method(){
        this.strategy.method();
    }
}


abstract class Strategy{
    public abstract void method();
}
class StrategyA extends Strategy{
    @Override
    public void method() {
        System.out.println("这是策略一");
    }
}
class StrategyB extends Strategy{
    @Override
    public void method() {
        System.out.println("这是策略二");
    }
}

class StrategyC extends Strategy{
    @Override
    public void method() {
        System.out.println("这是策略三");
    }
}

