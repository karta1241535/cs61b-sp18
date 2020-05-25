public class Palindrome {

    public Deque<Character> wordToDeque(String word) {
        Deque<Character> c = new LinkedListDeque<Character>();
        for (int i = 0; i < word.length(); i++) {
            c.addLast(word.charAt(i));
        }
        return c;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> c = wordToDeque(word);
        if (c.size() == 1 || c.size() == 0) {
            return true;
        }

        while (c.size() > 1) {
            if (c.removeFirst().equals(c.removeLast())) {
                continue; }
            else { return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> c = wordToDeque(word);
        if (c.size() == 1 || c.size() == 0) {
            return true;
        }

        while (c.size() > 1) {
            if (cc.equalChars(c.removeFirst(), c.removeLast())) {
                continue; }
            else { return false;
            }
        }
        return true;
    }
}
