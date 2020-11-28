package Test;

public class M23_10_Proxy {
    public static void main(String[] args) {
        Subject subject = new WantToBeProxy();
        subject.action();
    }
}


interface Subject{
    public void action();
}
class WantToBeProxy implements Subject {
    Subject subject = null;
    public WantToBeProxy(){
        subject = new Proxy();
    }
    public void action(){
        System.out.println("代理开始");
        subject.action();
        System.out.println("代理结束");
    }
}


class Proxy implements Subject{
    public void action(){
        System.out.println("========");
        System.out.println("========");
        System.out.println("这是被代理的类");
        System.out.println("========");
        System.out.println("========");

    }
}
