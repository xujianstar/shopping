package Test;

public class TestStaticClass extends StaticParentClass{
    static{
        System.out.println("TestStaticClass --- static");
    }

    {
        System.out.println("TestStaticClass --- no static");
    }

    public TestStaticClass(String name){
        System.out.println("TestStaticClass --- init");
    }


    public static void main(String[] args) {
        TestStaticClass testStaticClass = new TestStaticClass("");
    }
}

class StaticParentClass{
    static{
        System.out.println("StaticParentClass --- static");
    }
    {
        System.out.println("StaticParentClass --- no static");
    }
    public StaticParentClass(){
        System.out.println("StaticParentClass --- init");
    }
}
