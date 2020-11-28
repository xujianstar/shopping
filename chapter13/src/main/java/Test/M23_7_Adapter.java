package Test;

public class M23_7_Adapter {
    public static void main(String[] args) {
        Target target = new Adapter(new Adaptee());
        target.adapteeMathod();
        target.adapterMathod();
    }

}

interface Target{
    public void adapterMathod();
    public void adapteeMathod();
}

class Adapter implements Target{
    private Adaptee adaptee = null;
    public Adapter(Adaptee adaptee){
        this.adaptee = adaptee;
    }
    public void adapterMathod(){
        System.out.println("Adapter------ adapteeMathod ");
    }
    public void adapteeMathod(){
        adaptee.adapteeMathod();
    }
}
class Adaptee{
    public void adapteeMathod(){
        System.out.println("Adaptee---adapteeMathod");
    }
}