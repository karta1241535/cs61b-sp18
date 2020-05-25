import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {

    /**
    @Test
    public void testaddFirst() {
        StudentArrayDeque<Integer> test = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ref = new ArrayDequeSolution<>();

        for (int i = 0; i < 100; i += 1) {
            Integer number = StdRandom.uniform(50);
            test.addFirst(number);
            ref.addFirst(number);
            }

        for (int i = 0; i < 100; i += 1) {
            assertEquals(ref.get(i), test.get(i));
            }
    }

    @Test
    public void testaddLast() {
        StudentArrayDeque<Integer> test = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ref = new ArrayDequeSolution<>();

        for (int i = 0; i < 100; i += 1) {
            Integer number = StdRandom.uniform(50);
            test.addLast(number);
            ref.addLast(number);
        }

        for (int i = 0; i < 100; i += 1) {
            assertEquals(ref.get(i), test.get(i));
        }
    }

    @Test
    public void testremoveFirst() {
        StudentArrayDeque<Integer> test = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ref = new ArrayDequeSolution<>();

        for (int i = 0; i < 99; i += 1) {
            double number = StdRandom.uniform(1, 4);

            if (number == 1) {
                test.addLast(i);
                ref.addLast(i);
                System.out.println("addLast(" + i +")");
            } else if (number == 2) {
                test.addFirst(i);
                ref.addFirst(i);
                System.out.println("addFirst(" + i + ")");
            } else if (number == 3) {
                if (ref.size() != 0 && test.size() != 0) {
                    Integer x = ref.removeFirst();
                    Integer y = test.removeFirst();
                    System.out.println("removeFirst()");
                    assertEquals("Error! Your answer should be " + x + " but you get " + y, x, y);
                }
            }
        }
    }

    @Test
    public void testremoveLast() {
        StudentArrayDeque<Integer> test = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ref = new ArrayDequeSolution<>();

        for (int i = 0; i < 99; i += 1) {
            double number = StdRandom.uniform(1, 4);

            if (number == 1) {
                test.addLast(i);
                ref.addLast(i);
                System.out.println("addLast(" + i +")");
            } else if (number == 2) {
                test.addFirst(i);
                ref.addFirst(i);
                System.out.println("addFirst(" + i + ")");
            } else if (number == 3) {
                if (ref.size() != 0 && test.size() != 0) {
                    Integer x = ref.removeLast();
                    Integer y = test.removeLast();
                    System.out.println("removeLast()");
                    assertEquals("Error! Your answer should be " + x + " but you get " + y, x, y);
                }
            }
        }
    }
    */
    @Test
    public void testAllMethods() {
        StudentArrayDeque<Integer> test = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ref = new ArrayDequeSolution<>();

        for (int i = 0; i < 99; i += 1) {
            double number = StdRandom.uniform(1, 5);

            if (number == 1) {
                test.addLast(i);
                ref.addLast(i);
                System.out.println("addLast(" + i +")");
            } else if (number == 2) {
                test.addFirst(i);
                ref.addFirst(i);
                System.out.println("addFirst(" + i + ")");
            } else if (number == 3) {
                if (ref.size() != 0 && test.size() != 0) {
                    Integer x = ref.removeFirst();
                    Integer y = test.removeFirst();
                    System.out.println("removeFirst()");
                    assertEquals(x, y);
                }
            } else if (number == 4) {
                if (ref.size() != 0 && test.size() != 0) {
                    Integer x = ref.removeLast();
                    Integer y = test.removeLast();
                    System.out.println("removeLast()");
                    assertEquals(x, y);
                }
            }
        }
    }
}
