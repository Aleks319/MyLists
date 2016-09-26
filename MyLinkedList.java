package lesson8.hw.MyLists;

public class MyLinkedList <E>  {
    private Node<E> head;
    private int size;

    public MyLinkedList(){
        head = null;
        size = 0;
    }

    class Node<E> {
        private E node;
        private Node<E> next;
        private Node<E> prev;

        public Node(E e) {
            node = e;
            next = null;
            prev = null;
        }

        public E getNode() {
            return node;
        }
    }

    public void add(E e) {
        if(head == null) {
            head = new Node<>(e);
            size++;
        } else {
            Node temp;
            Node tprev;
            temp = tprev = head;
            while (temp.next != null) {
                temp = tprev = temp.next;
            }
            temp.next = new Node<>(e);
            temp.next.prev = tprev;
            size++;
        }
    }

    public void add(int index, E e) {
        if (index > size) {
            throw new IndexOutOfBoundsException("Index more then size of list!");
        } else if (index < 0) {
            throw new ArrayIndexOutOfBoundsException("Negative index!");
        } else if (index == size) {
            this.add(e);
        } else {
            Node newNode = new Node(e);
            Node temp;
            temp = head;
            if(index > 0) {
                for (int i = 1; i<=index; i++) {
                    temp = temp.next;
                }
            }
            if(index == 0) {
                newNode.next = temp;
                temp.prev = newNode;
                head = newNode;
                size++;
            } else {
                newNode.prev = temp.prev;
                newNode.next = temp;
                temp.prev.next = newNode;
                temp.prev = newNode;
                size++;
            }
        }
    }


    public Object get(int index) {
        if(index >= size) {
            throw new IndexOutOfBoundsException("Index more then amount of elements in list!");
        } else if (index < 0 ) {
            throw new ArrayIndexOutOfBoundsException("Negative index!");
        } else {
            Node temp;
            temp = head;
            if(index > 0) {
                for (int i = 1; i<=index; i++) {
                    temp = temp.next;
                }
            }
            return temp.getNode();
        }
    }

    public void remove(int index) {
        if(index >= size) {
            throw new IndexOutOfBoundsException("Index more then amount of elements in list!");
        } else if (index < 0 ) {
            throw new ArrayIndexOutOfBoundsException("Negative index!");
        } else {
            Node temp;
            temp = head;
            if(index > 0) {
                for (int i = 1; i<=index; i++) {
                    temp = temp.next;
                }
            }
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
            size--;
        }
    }

    public void clear() {
        head = null;
        size = 0;
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