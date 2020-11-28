package Test;

public class M23_6_ProtoType {
    public static void main(String[] args) throws CloneNotSupportedException {
        ProtoTypeImpl protoTypeImpl = new ProtoTypeImpl("龍門天下");
        ProtoType protoType = (ProtoType)protoTypeImpl.clone();

        System.out.println(protoType.getName());
        System.out.println(protoTypeImpl.getName());

        if(protoType== protoTypeImpl){
            System.out.println("是同一个对象");
        }else{
            System.out.println("不是同一个对象");
        }
    }
}


class ProtoType implements Cloneable{
    private String name = "" ;
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
class ProtoTypeImpl extends ProtoType{
    public ProtoTypeImpl(String name){
        setName(name);
    }
}