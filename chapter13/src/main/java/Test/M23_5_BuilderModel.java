package Test;

public class M23_5_BuilderModel {
    public static void main(String[] args) {
        PersonDirector personDirector = new PersonDirector();
        Person person = personDirector.createPerson(new ManBuilder());
        System.out.println(person.toString());
    }

}




interface PersonBuilder{
    public void createHead();
    public void createBody();
    public void createFoot();

    Person buildPerson();
}

class ManBuilder implements PersonBuilder{
    Person person = null;
    @Override
    public void createBody() {
        System.out.println("创建男人的身体");
        person.setBody("创建身体");
    }

    @Override
    public void createHead() {
        System.out.println("创建男人的头部");
        person.setHead("构建头部");
    }

    @Override
    public void createFoot() {
        System.out.println("创建男人的脚跟");
        person.setFoot("创造脚跟");
    }

    public ManBuilder(){
        person = new Man();
    }

    public Person buildPerson(){
        return person;
    }
}

class Person {
    private String head ;
    private String body ;
    private String foot ;

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getFoot() {
        return foot;
    }

    public void setFoot(String foot) {
        this.foot = foot;
    }
}

class Man extends Person{
    @Override
    public String toString() {
        return this.getHead()+":"+ this.getBody()+":"+this.getFoot();
    }
}

class PersonDirector{
    public Person createPerson(PersonBuilder builder ){
        builder.createBody();
        builder.createFoot();
        builder.createHead();
        return builder.buildPerson();
    }
}