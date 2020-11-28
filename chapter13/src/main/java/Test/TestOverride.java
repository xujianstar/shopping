package Test;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class TestOverride {
    public static void main(String[] args) {
/*        int number = 0;
        System.out.println(number);

        ParentClass parentClass = new ParentClass();
        System.out.println(parentClass);
        SubClass subClass = new SubClass("OK");
        System.out.println(subClass);
        System.out.println(subClass.getMessage());
        List list = null;
        Set set = null;*/

        HashMap<String, String> map = new HashMap<String, String>();
        map.put("ok", "ok1");
//        map.put("ok","ok2");
        System.out.println(map.get("ok"));
        HashSet<ParentClass> set = new HashSet<ParentClass>();
        set.add(new ParentClass());
        set.add(new ParentClass());
        System.out.println(set.size()+"0000000000000000000000000");

        String[] list1= {"1","2","3","4"};
        String[] list2= new String[]{"a","b","c","d"};
        String[] list3= new String[9];
        System.out.println(list1.length);
        System.out.println(list2.length);
        System.out.println(list3.length);

        ParentClass p = new ParentClass();
    }
}


class ParentClass{
    public String name = "parent";
    private String age = "P_age";
    public ParentClass(){
        System.out.println("ParentClass");
        System.out.println("name="+name+";age="+age);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        ParentClass object = (ParentClass) obj;
        return this.name.equals(object.name)&&this.age.equals(object.age);
    }
}

class SubClass extends ParentClass{
    private String age = "s_age";
    public String name = "sub";

    public SubClass(String ok ){
        System.out.println("SubClass");
        System.out.println("name="+super.name+";age="+age);
    }

    public String getMessage(){
        try {

        InputStreamReader read  = new InputStreamReader(System.in);
        BufferedReader bufferread = new BufferedReader(read);
        System.out.println(bufferread.readLine());

            Scanner scanner = new Scanner(System.in);
            System.out.println(scanner.nextLine());

            return "try";
        }catch (Exception e){
            System.out.println("++Exception++");
            return "exception";
        }finally {
            System.out.println("++finally++");
            return "finally";
        }
    }
}
