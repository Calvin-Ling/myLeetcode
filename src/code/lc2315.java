package code;

public class lc2315 {
    public int countAsterisks(String s) {
        boolean isInPair = false;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '|') isInPair = !isInPair;
            else if (s.charAt(i) == '*' && !isInPair) res++;
        }
        return res;
    }
}
