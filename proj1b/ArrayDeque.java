/**
Invariants:
1. First element is at array[nextFirst + 1]
2. Last element is at array[nextLast -1]
3. Size is equal to
    i) nextLast - nextFirst -1 if (nextLast > nextFirst)
    ii) array.length - (nextFirst - nextLast -1)
4. for empty array
    i) size == 0
    ii) "nextFirst + 1" == nextLast
5. for full aDeque
    i) size == aDeque.length
    ii) "nextFirst -1" == nextLast
 */

public class ArrayDeque<T> implements Deque<T> {

    private T[] array;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        array = (T[]) new Object[8];
        nextFirst = 5;
        nextLast = 6;
        size = 0;
    }

    private void resize(int capacity) {
        T[] newArray = (T[]) new Object[capacity];
        int oldIndex = plusOne(nextFirst); // the index of the first item in original array
        for (int i = 0; i < size; i++) {
            newArray[i] = array[oldIndex];
            oldIndex = plusOne(oldIndex); // for circular property
        }
        array = newArray;
        nextFirst = capacity - 1; // since the new array is starting from true 0 index
        nextLast = size;
    }

    private boolean isFull() {
        return size == array.length;
    }

    private boolean isSparse() {
        return size < array.length / 2 && array.length > 8;
    }

    private int minusOne(int index) {
        return (index - 1 + array.length) % array.length;
    }

    private int plusOne(int index) {
        return (index + 1) % array.length;
    }

    /*Deque Api*/

    @Override
    public void addFirst(T item) {
        if (isFull()) {
            resize(array.length * 2);
        }

        array[nextFirst] = item;
        nextFirst = minusOne(nextFirst);
        size += 1;
    }
    
    @Override
    public void addLast(T item) {
        if (isFull()) {
            resize(array.length * 2);
        }

        array[nextLast] = item;
        nextLast = plusOne(nextLast);
        size += 1;
    }
    
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    
    @Override
    public int size() {
        return size;
    }
    
    @Override
    public void printDeque() {
        for (int i = plusOne(nextFirst); i != nextLast; i = plusOne(i)) {
            System.out.print(array[i].toString());
        }
        System.out.println();
    }
    
    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }

        /** resize if usage rate < 0.5 */
        if (isSparse()) {
            resize(array.length / 2);
        }

        nextFirst = plusOne(nextFirst);
        T returnitem = array[nextFirst];
        array[nextFirst] = null;
        size -= 1;

        return returnitem;
    }
    
    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }

        /** resize if usage rate < 0.5 */
        if (isSparse()) {
            resize(array.length / 2);
        }

        nextLast = minusOne(nextLast);
        T returnitem = array[nextLast];
        array[nextLast] = null;
        size -= 1;

        return returnitem;
    }
    
    @Override
    public T get(int index) {
        if (index >= size) {
            return null;
        }

        index = (plusOne(nextFirst) + index) % array.length;
        return array[index];
    }

    public ArrayDeque(ArrayDeque other) {
        array = (T[]) new Object[8];
        size = 0;
        nextFirst = 4;
        nextLast = 6;
        for (int i = 0; i < other.size; i++) {
            addLast((T) other.get(i));
        }
    }
}