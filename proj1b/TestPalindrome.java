import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testisPalindrome() {
        assertFalse(palindrome.isPalindrome("cat"));
        assertFalse(palindrome.isPalindrome("accra"));
        assertTrue(palindrome.isPalindrome("AdA"));
        assertTrue(palindrome.isPalindrome("A"));
    }

    @Test
    public void testisPalindromeCC() {
        OffByOne one = new OffByOne();
        assertFalse(palindrome.isPalindrome("cat", one));
        assertTrue(palindrome.isPalindrome("yyyxz", one));
        assertFalse(palindrome.isPalindrome("aa", one));
        assertFalse(palindrome.isPalindrome("xyz", one));
        assertFalse(palindrome.isPalindrome("aa", one));
        assertFalse(palindrome.isPalindrome("zxzx", one));
        assertTrue(palindrome.isPalindrome("", one));
        assertTrue(palindrome.isPalindrome("a", one));
        assertTrue(palindrome.isPalindrome("flake", one));
        assertTrue(palindrome.isPalindrome("zyzy", one));
        assertTrue(palindrome.isPalindrome("yyxz", one));
    }
}     /** Uncomment this class once you've created your Palindrome class. */