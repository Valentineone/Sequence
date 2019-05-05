package LinkedList;

public class LinkedList {
     public class Node {
        Object data;
        Node next;
        private Node() {
        }
        Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

     private Node header;
     private Node tail;
     private int size;

     public LinkedList() {
         this.header = null;
         this.tail = null;
         this.size = 0;
     }
     public LinkedList(Object element) {
         this.header = new Node(element, null);
         this.tail = this.header;
         this.size++;
     }

    /**
     * 返回链表长度
     * @return
     */
     public int length() {
         return this.size;
     }




}
