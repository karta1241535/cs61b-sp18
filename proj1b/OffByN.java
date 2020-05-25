public class OffByN implements CharacterComparator {

    private int interval;
    public OffByN(int N) {
        interval = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        int diff = x - y;
        return diff == interval || diff == -interval;
    }
}