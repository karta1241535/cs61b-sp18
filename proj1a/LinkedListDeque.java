public class LinkedListDeque<T> {

    private class StuffNode {
        private T item;
        private StuffNode prev;
        private StuffNode next;

        private StuffNode(T x, StuffNode p, StuffNode n) {
            item = x;
            prev = p;
            next = n;
        }
    }

    private StuffNode sentinel; /** Circular sentinel */
    private int size;

    public LinkedListDeque() {
        sentinel = new StuffNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    /** Deque Api */

    /** Add an item of type T in front of the deque */
    public void addFirst(T item) {
        size += 1;
        sentinel.next = new StuffNode(item, sentinel, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
    }

    /** Add an item of type T to the back of the deque */
    public void addLast(T item) {
        size += 1;
        sentinel.prev = new StuffNode(item, sentinel.prev, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        StuffNode toPrint = sentinel;
        while (toPrint.next != sentinel) {
            System.out.print(toPrint.next.item + "");
            toPrint = toPrint.next;
        }
        System.out.println();
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        size += -1;
        T item = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        return item;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        size += -1;
        T item = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        return item;
    }

    public T get(int index) {
        StuffNode toGet = sentinel.next;
        for (int i = 0; i < index; i++) {
            toGet = toGet.next;
        }
        return toGet.item;
    }

    public LinkedListDeque(LinkedListDeque other) {
        sentinel = new StuffNode(null, null, null);
        sentinel.prev = sentinel.next = sentinel;
        size = 0;

        for (int i = 0; i < other.size(); i++) {
            addLast((T) other.get(i));
        }
    }

    public T getRecursive(int index) {
        return getRecursiveHelper(index, sentinel.next);
    }

    private T getRecursiveHelper(int index, StuffNode p) {
        if (index == 0) {
            return p.item;
        }
        return getRecursiveHelper(index - 1, p.next);
    }
}