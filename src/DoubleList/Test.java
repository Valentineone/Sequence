package DoubleList;

public class Test {
    public static void main(String[] args) {
        DoubleLinkedListImpl list = new DoubleLinkedListImpl();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println("size:" + list.size());
        System.out.println(list.get(0));
        System.out.println(list.get(3));
        list.set(1,10);
        System.out.println(list.get(1));
        list.remove(2);
        System.out.println(list.get(2));
        System.out.println("size:" + list.size());
        list.clear();
        System.out.println("size:" + list.size());
    }
}
