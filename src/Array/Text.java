package Array;

public class Text {
    public static void main(String[] args) {
        SequenceArrayImpl sequence = new SequenceArrayImpl();
        sequence.add("wang");
        sequence.add("chong");
        sequence.add("shi");
        sequence.add("shuaige");
        System.out.println(sequence.get(1));
        System.out.println(sequence.get(3));
        sequence.set(1,"wo");
        System.out.println(sequence.get(1));
    }
}
