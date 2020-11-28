package Test;

public class M23_9_Facade {
    private ServerA a ;
    private ServerB b ;
    private ServerC c ;

    public static void main(String[] args) {
        M23_9_Facade facade = new M23_9_Facade();
        facade.method1();
        System.out.println("++++++++++++++++++++++++++");
        facade.method2();
        System.out.println("--------------------------");
        facade.method3();
        System.out.println("**************************");

    }

    public M23_9_Facade (){
        a = new ServerA();
        b = new ServerB();
        c = new ServerC();
    }

    public void method1(){
        a.methodA();
        b.methodB();
    }

    public void method2(){
        b.methodB();
        c.methodC();
    }

    public void method3(){
        c.methodC();
        a.methodA();
    }
}

class ServerA{
    public void methodA(){
        System.out.println("methodA");
    }
}

class ServerB{
    public void methodB(){
        System.out.println("methodB");
    }
}

class ServerC{
    public void methodC(){
        System.out.println("methodC");
    }
}

