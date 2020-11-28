package Test;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        String[] str = new String[] { "a", "b" };
        List<String> list = Arrays.asList(str);
        for (String element : list) {
            System.out.println(element);
        }

        Map map = new HashMap();
        map.put("a", "1");
        map.put("b","2");
        map.put("c","3");
        Set<Map.Entry<String, String>>  entrySet = map.entrySet();
        for (Map.Entry entry : entrySet) {
            System.out.println(entry.getKey()+"="+entry.getValue());
        }
        int i=1;
        switch (i){
            case 1:
                System.out.println(1);
            case 2:
                System.out.println(2);
            default:
                System.out.println(3);
        }



    }
}
