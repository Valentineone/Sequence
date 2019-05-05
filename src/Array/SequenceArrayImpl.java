package Array;


import java.util.Arrays;

public class SequenceArrayImpl implements Sequence {
    private static final int FAULT_CAPACIT = 10;
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    private Object[] element;
    private int size;

    SequenceArrayImpl() {
        this.element = new Object[FAULT_CAPACIT];
    }

    @Override
    public void add(Object data) {
        ensureSize(size + 1);
        element[size++] = data;
    }

    private void ensureSize(int minCap) {
        if (minCap > element.length) {
            grow(minCap);
        }
    }

    private void grow(int minCap) {
        int oldCap = element.length;
        int newCap =  oldCap << 1;
        if (newCap < minCap) {
            newCap = minCap;
        }
        if (newCap > MAX_ARRAY_SIZE) {
            throw new ArrayIndexOutOfBoundsException();
        }
        element = Arrays.copyOf(element,newCap);
    }
    @Override
    public Object remove(int index) {
        range(index);
        Object oldData = element[index];
        int moveSize = size - index - 1;
        if (moveSize > 0) {
            System.arraycopy(element,index + 1,element,index,moveSize);
        }
        element[--size] = null;
        return oldData;
    }

    private void range(int index) {
        if (index > size) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public Object get(int index) {
        range(index);
        return element[index];
    }

    @Override
    public boolean contains(Object data) {
        if (data == null) {
            for (int i = 0; i < size; i++) {
                if (element[i] == null) {
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element[i] == data) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Object set(int index, Object newData) {
        range(index);
        Object oldData = element[index];
        element[index] = newData;
        return oldData;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void clear() {
        for (int i = 0; i > size; i++) {
            element[i] = null;
        }


        this.size = 0;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(element,size);
    }
}
