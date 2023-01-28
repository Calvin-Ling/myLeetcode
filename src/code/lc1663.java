package code;

public class lc1663 {
    public String getSmallestString(int n, int k) {
        StringBuilder suffix = new StringBuilder();
        for (int i = 0; i < k / 26; i++) {
            suffix.append("z");
        }
        StringBuilder prefix = new StringBuilder();
        int m = k % 26;
        for (int i = 0; i < n - suffix.length(); i++) {
            prefix.append("a");
            m--;
        }
        if (m == 0) {
            return prefix.toString() + suffix.toString();
        }
        else if (m > 0) {
            prefix.replace(prefix.length()-1, prefix.length(), (char) ('a' + m) + "");
            return prefix.toString() + suffix.toString();
        } else {
            m = Math.abs(m);
            int index = 0;
            for (; index < m / 25; index++) {
                suffix.replace(index, index+1, "a");
            }
            suffix.replace(index, index+1, (char) ('z' - m%25) + "");
            return prefix.toString() + suffix.toString();
        }
    }
}
