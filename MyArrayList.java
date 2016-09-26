package lesson8.hw.MyLists;
import java.util.Arrays;

public class MyArrayList <E>  {
    private static final int DEFAULT_SIZE = 8;
    private Object[] arr;
    private int size;

    public MyArrayList () {
        arr = new Object[DEFAULT_SIZE];
        size = 0;
    }

    public MyArrayList (int size) {
        arr = new Object[size];
    }


    public void add(E e) {
        if(arr.length == 0) {
            arr = new Object[DEFAULT_SIZE];
            arr[0] = e;
            size++;
        } else {
            if(arr.length == size) {
                this.resize();
                arr[size] = e;
                size++;
            } else  {
                arr[size] = e;
                size++;
            }
        }
    }


    public void add(int index, E e) {
        if (index > size) {
            throw new IndexOutOfBoundsException("Index more then size of list!");
        } else if (index < 0) {
            throw new ArrayIndexOutOfBoundsException("Negative index!");
        } else if (arr.length == 0 || index == size) {
            this.add(e);
        } else {
            if (arr.length == size) {
                this.resize();
            }
            for(int i = size; i>=index; i--) {
                arr[i] = (i==index) ? e : arr[i-1];
            }
            size++;
        }
    }

    public Object get(int index) {
        if(index >= size) {
            throw new IndexOutOfBoundsException("Index more then amount of elements in list!");
        } else if (index < 0 ) {
            throw new ArrayIndexOutOfBoundsException("Negative index!");
        } else {
            return arr[index];
        }
    }

    public void remove(int index) {
        if(index >= size) {
            throw new IndexOutOfBoundsException("Index more then amount of elements in list!");
        } else if (index < 0 ) {
            throw new ArrayIndexOutOfBoundsException("Negative index!");
        } else {
            for(int i = index; i<size-1; i++) {
                arr[i] = arr[i+1];
            }
            arr[size-1] = null;
            size--;
        }
    }

    public void clear() {
        arr = new Object[DEFAULT_SIZE];
        size = 0;
    }

    private void resize() {
        if(arr.length == size) {
            Object[] temp;
            temp = Arrays.copyOf(arr, arr.length*2);
            arr = temp;
        }
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i<size; i++) {
            sb.append(this.get(i) + ", ");
        }
        sb.deleteCharAt(sb.length()-1).deleteCharAt(sb.length()-1);
        sb.append("]");
        return sb.toString();
    }
}