package Test;


import java.util.Arrays;
import java.util.List;

public class TestStream {
    public static void main(String[] args) {
        UserStream u1 = new UserStream(11, "a", 23);
        UserStream u2 = new UserStream(12, "b", 24);
        UserStream u3 = new UserStream(13, "c", 22);
        UserStream u4 = new UserStream(14, "d", 28);
        UserStream u5 = new UserStream(16, "e", 26);

        List<UserStream> userList = Arrays.asList(u1, u2, u3, u4, u5);
        userList.forEach(user->{
            System.out.println();
        });

        userList.stream().filter(user->{
            return user.getId() %2 == 0;
        }).filter(user->{
            return user.getAge()>24;
        }).map(user->{
            return user.getName().toUpperCase();
        }).sorted((o1,o2)->{
            return o1.compareTo(o2);
        }).limit(1).forEach(System.out::print);
    }
}

class UserStream{
    private int id ;
    private int age;
    private String name;
    public UserStream(int id,String name,int age){
        this.id = id;
        this.name = name ;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
