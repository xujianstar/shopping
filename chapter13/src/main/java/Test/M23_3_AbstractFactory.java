package Test;

public class M23_3_AbstractFactory {
    public static void main(String[] args) {
        AbstractFactory huaWeiFactory = new HuaWeiFactory();
        IComputer huaweiComputer=  huaWeiFactory.createComputer();
        IPhone huaweiPhone = huaWeiFactory.createPhone();
        huaweiComputer.display();
        huaweiPhone.display();

        AbstractFactory lianxiangFactory = new LianxiangFactory();
        IPhone lianxiangPhone = lianxiangFactory.createPhone();
        IComputer lianxiangComputer = lianxiangFactory.createComputer();

        lianxiangComputer.display();
        lianxiangPhone.display();
    }

}

interface AbstractFactory{
    public IPhone createPhone();
    public IComputer createComputer();
}

class HuaWeiFactory implements AbstractFactory{
    public IPhone createPhone(){
        return new HuaWeiPhone();
    }
    public IComputer createComputer(){
        return new HuaWeiComputer();
    }
}
class LianxiangFactory implements AbstractFactory{
    public IPhone createPhone(){
        return new LianxiangPhone();
    }
    public IComputer createComputer(){
        return new LianxiangComputer();
    }
}


interface IPhone{
    public void display();
}
class HuaWeiPhone implements IPhone{
    public void display(){
        System.out.println("华为手机");
    }
}
class LianxiangPhone implements IPhone{
    public void display(){
        System.out.println("联想手机");
    }
}

interface IComputer{
    public void display();
}
class HuaWeiComputer implements IComputer{
    public void display(){
        System.out.println("华为电脑");
    }
}
class LianxiangComputer implements IComputer{
    public void display(){
        System.out.println("联想电脑");
    }
}