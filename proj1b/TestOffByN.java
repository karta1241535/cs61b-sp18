import org.junit.Test;
import static org.junit.Assert.*;


public class TestOffByN {
    CharacterComparator offBy3 = new OffByN(3);
    CharacterComparator offBy4 = new OffByN(4);
    CharacterComparator offBy5 = new OffByN(5);

    @Test
    public void testOffBy3() {
        assertFalse(offBy3.equalChars('a', 'c'));
        assertTrue(offBy3.equalChars('a', 'd'));
    }

    @Test
    public void testOffBy4() {
        assertFalse(offBy4.equalChars('a', 'c'));
        assertFalse(offBy4.equalChars('A', 'Z'));
        assertFalse(offBy4.equalChars('A', 'e'));
        assertFalse(offBy4.equalChars('&', 'd'));
        assertTrue(offBy4.equalChars('a', 'e'));
        assertTrue(offBy4.equalChars('A', 'E'));
        assertTrue(offBy4.equalChars('g', 'k'));
        assertTrue(offBy4.equalChars('e', 'i'));

    }

    @Test
    public void testOffBy5() {
        assertFalse(offBy5.equalChars('f', 'h'));
        assertFalse(offBy5.equalChars('e', 'h'));
        assertTrue(offBy5.equalChars('a', 'f'));
        assertTrue(offBy5.equalChars('f', 'a'));
        assertTrue(offBy5.equalChars('f', 'a'));
    }
}