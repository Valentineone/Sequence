package DoubleList;

import Array.Sequence;

public class DoubleLinkedListImpl implements Sequence {
    private Node head;
    private Node tail;
    private int size;

    private class Node {
        Node prev;
        Object data;
        Node next;

        public Node(Object data) {
            this.data = data;
        }

        Node(Node prev, Object data, Node next) {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }
    }

    /**
     * 尾插法
     * @param data 要存储的元素
     */
    @Override
    public void add(Object data) {
        Node newNode = new Node(tail,data,null);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    @Override
    public Object remove(int index) {
        rangeCheck(index);
        Node cur = node(index);
        Node prev = cur.prev;
        Node next = cur.next;
        if (prev == null) {
            head = head.next;
        }
        if (next == null) {
            tail = cur.prev;
        }
        Object oldData = cur.data;
        cur.next = cur.prev = null;
        cur.data = null;
        size--;
        return oldData;
      /*  if (prev == null) {
            head = head.next;
        } else {
            prev.next = cur.next;
            //cur.prev = null;
        }
        if (next == null) {
            tail = null;
        } else {
            next.prev = null;
           // cur.prev = null;
        }
        Object oldData = cur.data;
        cur.next = cur.prev = null;
        cur.data = null;
        size--;
        return oldData;*/
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Illegal Index!");
        }
    }
    @Override
    public Object get(int index) {
        rangeCheck(index);
        return node(index).data;
    }

    private Node node(int index) {
        if (index < (size >> 1)) {
            Node temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp;
        } else {
            Node temp = tail;
            for (int i = size - 1; i > index; i--) {
                temp = temp.prev;
            }
            return temp;
        }
    }

    @Override
    public boolean contains(Object data) {
        for (Node temp = head; temp.next != null; temp = temp.next) {
            if (temp.data == data) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object set(int index, Object newData) {
        rangeCheck(index);
        Object oldData = node(index).data;
        node(index).data = newData;
        return oldData;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        Node next;
        for (Node temp = head; temp != null; temp = temp.next) {
            next = temp.next;
            temp.prev = null;
            temp.next = next;
            temp.data = null;
            size--;
        }
    }

    @Override
    public Object[] toArray() {
        Object[] data = new Object[size];
        int i = 0;
        for (Node temp = head; temp != null; temp = temp.next) {
            data[i++] = temp.data;
        }
        return data;
    }


}
