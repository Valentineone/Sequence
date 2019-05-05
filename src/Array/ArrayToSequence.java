package Array;


import java.util.Arrays;

public class ArrayToSequence implements Sequence {
    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private Object[] elementData;
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    public ArrayToSequence() {
        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public void add(Object data) {
        ensureCapacity(size + 1);
        elementData[size++] = data;
    }

    private void ensureCapacity(int minCap) {
        if (minCap > elementData.length) {
            grow(minCap);
        }
    }

    private void grow(int minCap) {
        int oldCap = elementData.length;
        int newCap = oldCap << 1;
        //会出现这个中情况吗？
        if (newCap < minCap) {
            newCap = minCap;
        }
        if (newCap > MAX_ARRAY_SIZE) {
            throw new ArrayIndexOutOfBoundsException("数组超过最大值");
        }
        elementData = Arrays.copyOf(elementData,newCap);
    }

    @Override
    public Object remove(int index) {
        rangeCheck(index);
        Object oldData = elementData[index];
        int moveSize = size  - index - 1;
        if (moveSize > 0) {
            System.arraycopy(elementData,index + 1,elementData,index,moveSize);
        }
        elementData[--size] = null;
        return oldData;
    }

    private void rangeCheck(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("下标不存在");
        }
    }

    @Override
    public Object get(int index) {
        rangeCheck(index);
        return elementData[index];
    }

    @Override
    public boolean contains(Object data) {
        if (data == null) {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null) {
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (elementData.equals(data)){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Object set(int index, Object newData) {
        rangeCheck(index);
        Object oldData = elementData[index];
        elementData[index] = newData;
        return oldData;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elementData[i] = null;
        }
        this.size = 0;
    }

    @Override
    public Object[] toArray() {//本来就是数组为什么还要转换为数组
        return Arrays.copyOf(elementData,size);
    }
}
