package code;

public class lc2309 {
    public String greatestLetter(String s) {
        int[] upper = new int[26];
        int[] letter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a') {
                upper[c-'a'] = 1;
            } else if (c >= 'A'){
                letter[c-'A'] = 1;
            }
        }
        for (int i = 25; i >= 0; i--) {
            if (upper[i] == 1 && letter[i] == 1) return ((char) (i + 'A')) + "";
        }
        return "";
    }
}
