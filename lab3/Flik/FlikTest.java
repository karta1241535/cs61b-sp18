import static org.junit.Assert.*;

import org.junit.Test;

public class FlikTest {

    @Test
    public void testisSameNumber() {
        assertFalse(Flik.isSameNumber(4, 5));
        assertFalse(Flik.isSameNumber(1, 128));
        assertTrue(Flik.isSameNumber(4, 4));
        assertTrue(Flik.isSameNumber(128, 128)); // bugged
    }
}
