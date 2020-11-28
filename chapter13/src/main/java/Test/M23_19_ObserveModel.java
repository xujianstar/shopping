package Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class M23_19_ObserveModel {
    public static void main(String[] args) {
        Subject_1 subject = new ConcreteSubject();
        subject.add(new ObserverOne("hello"));
        subject.add(new ObserverTwo("world"));
        subject.notice();
        subject.remove(new ObserverOne("hello") );
        subject.notice();

    }

}

abstract class Subject_1{
    protected List<Observer_1> observeList = new ArrayList<Observer_1>();
    public void add(Observer_1 observe ){
        observeList.add(observe);
    }
    public void remove(Observer_1 observe){
        observeList.remove(observe);
    }
    abstract public void notice();
}

class ConcreteSubject extends Subject_1{
    public void notice(){
        for (Observer_1 observe : this.observeList ) {
            observe.update();
        }
    }
}

abstract class Observer_1{
    abstract public void update();
}
class ObserverOne extends Observer_1{
    private String name ;

    public ObserverOne(String name){
        this.name = name;
    }

    @Override
    public boolean equals(Object var1) {
        ObserverOne one = (ObserverOne)var1;
        return this.name.equals(one.getName());
    }

    @Override
    public void update() {
        System.out.println("观察者一号负责更新");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
class ObserverTwo extends Observer_1{
    private String name ;

    public ObserverTwo(String name){
        this.name = name;
    }

    @Override
    public boolean equals(Object var1) {
        ObserverOne one = (ObserverOne)var1;
        return this.name.equals(one.getName());
    }


    @Override
    public void update() {
        System.out.println("观察者二号负责更新");
    }
}