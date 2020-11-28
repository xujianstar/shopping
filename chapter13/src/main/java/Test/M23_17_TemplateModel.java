package Test;

public class M23_17_TemplateModel {
    public static void main(String[] args) {
        AbstractTemplate template = new TemplateImpl();
        template.update();
    }
}
abstract class AbstractTemplate{
    abstract public void print();

    public void update(){
        for (int i = 0; i <11 ; i++) {
            print();
        }
    }
}

class TemplateImpl extends AbstractTemplate{
    @Override
    public void print() {
        System.out.println("这是打印");
    }
}

