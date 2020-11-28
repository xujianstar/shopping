package Test;


import java.util.ArrayList;
import java.util.List;

public class M23_11_Componite {
    public static void main(String[] args) {
        Employer programmer = new Programmer("程序员1");
        Employer assist = new ProjectAssistant("项目助理");
        Employer manage = new ProjectManager("项目经理");
        manage.add(programmer);
        manage.add(assist);
        List<Employer> ems = manage.getEmployers();
        for (Employer em : ems) {
            System.out.println(em.getName());
        }
    }
}

abstract class Employer{
    private String name ;
    public List<Employer> list ;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printInfo() {
        System.out.println(name);
    }
    abstract void add(Employer employer);
    abstract void remove(Employer employer);
    public List<Employer> getEmployers() {
        return this.list;
    }
}


class ProjectAssistant extends Employer{
    public ProjectAssistant(String name){
        this.setName(name);
    }
    @Override
    void add(Employer employer) {
    }
    @Override
    void remove(Employer employer) {
    }
}
class Programmer extends Employer{
    public Programmer(String name){
        this.setName(name);
    }
    @Override
    void add(Employer employer) {
    }
    @Override
    void remove(Employer employer) {
    }
}
class ProjectManager extends Employer{
    public ProjectManager(String name){
        this.setName(name);
        list = new ArrayList<Employer>();
    }
    @Override
    void add(Employer employer) {
        list.add(employer);
    }
    @Override
    void remove(Employer employer) {
        list.remove(employer);
    }
}