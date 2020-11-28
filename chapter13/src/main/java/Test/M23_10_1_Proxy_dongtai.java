package Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class M23_10_1_Proxy_dongtai {
    public static void main(String[] args) {
        Student student = new Student();
        ProxyUser user = new ProxyUser(student);

        User user1 = (User)Proxy.newProxyInstance(Student.class.getClassLoader(),new Class[]{User.class},user);

        user1.giveTask();
    }
}

interface User{
    void giveTask();
}
class Student implements User{
    @Override
    public void giveTask() {
        System.out.println("学生交作业");
    }
}
class ProxyUser implements InvocationHandler{
    private User user ;
    public ProxyUser(User user){
        this.user = user;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("动态代理开始");
        Object result = method.invoke(user,args);
        System.out.println("动态代理结束");
        return result;
    }
}
