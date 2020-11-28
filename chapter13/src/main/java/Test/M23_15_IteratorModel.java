package Test;

public class M23_15_IteratorModel {
    public static void main(String[] args) {
        Mylist list = new MylistImpl();
        list.add("a");
        list.add("b");
        list.add("c");
        MyIterator myIterator = list.iterator();

        while(myIterator.hasNext()){
            Object object = myIterator.next();
            System.out.println(object);
        }
    }

}

interface MyIterator{
    public void first();
    public void last();
    public boolean hasNext();
    public Object next();
}

class MyIteratorImpl implements MyIterator{
    private Mylist list ;
    private int index ;
    MyIteratorImpl(Mylist list){
        this.list =  list;
    }
    @Override
    public void first() {
        index = 0;
    }

    @Override
    public void last() {
        index = list.getSize();
    }

    @Override
    public boolean hasNext() {
        return index < list.getSize();
    }

    @Override
    public Object next() {
        Object object =list.get(index);
        index ++;
        return object;
    }
}
interface Mylist{
    MyIterator iterator();
    Object get(int index);
    int getSize();
    void add(Object obj);
}

class MylistImpl implements Mylist{
    private Object[] list ;
    private int index;
    private int size;
    MylistImpl(){
        list = new Object[100];
        index= 0;
        size = 0;
    }


    @Override
    public MyIterator iterator() {
        return new MyIteratorImpl(this);
    }

    @Override
    public Object get(int index) {
        return list[index];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void add(Object obj) {
        list[index++] = obj;
        size = size+1;
    }
}