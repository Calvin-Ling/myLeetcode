package code;

public class lc2697 {
    public String makeSmallestPalindrome(String s) {
        int i = 0, len = s.length();
        char[] chars = s.toCharArray();
        while (i <= len / 2) {
            if (chars[len - 1 - i] < chars[i]) {
                chars[i] = chars[len - 1 - i];
            } else {
                chars[len - 1 - i] = chars[i];
            }
            i++;
        }
        return new String(chars);
    }
}
