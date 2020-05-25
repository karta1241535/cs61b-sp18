package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        BoundedQueue<Integer> arb = new ArrayRingBuffer<>(5);
        arb.enqueue(1);
        arb.enqueue(2);
        Integer get = arb.dequeue();
        assertEquals(Integer.valueOf(1), get);
        get = arb.dequeue();
        assertEquals(Integer.valueOf(2), get);

        arb.enqueue(1);
        arb.enqueue(2);
        arb.enqueue(3);
        arb.enqueue(4);
        arb.enqueue(5);
        get = arb.dequeue();
        assertEquals(Integer.valueOf(1), get);
    }

    @Test
    public void equalsTest() {
        BoundedQueue<Integer> arb = new ArrayRingBuffer<>(5);
        arb.enqueue(1);
        arb.enqueue(2);
        arb.enqueue(3);
        arb.enqueue(4);
        arb.enqueue(5);

        BoundedQueue<Integer> b = new ArrayRingBuffer<>(6);
        b.enqueue(1);
        b.enqueue(2);
        b.enqueue(3);
        b.enqueue(4);
        b.enqueue(5);

        BoundedQueue<Integer> c = new ArrayRingBuffer<>(6);
        c.enqueue(1);
        c.enqueue(1);
        c.enqueue(3);
        c.enqueue(4);
        c.enqueue(5);

        BoundedQueue<Integer> d = new ArrayRingBuffer<>(4);
        BoundedQueue<Integer> e = new ArrayRingBuffer<>(6);

        int f = 5;

        assertTrue(arb.equals(b));
        assertTrue(d.equals(e));
        assertFalse(arb.equals(c));
        assertFalse(arb.equals(f));

    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
