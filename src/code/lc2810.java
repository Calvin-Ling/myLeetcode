package code;

public class lc2810 {
    public String finalString(String s) {
        StringBuilder sb = new StringBuilder();
        int i = s.indexOf('i'), last = 0;
        while (i >= 0) {
            sb.append(s, last, i);
            sb.reverse();
            last = i + 1;
            i = s.indexOf('i', last);
        }
        sb.append(s.substring(last));
        return sb.toString();
    }
}
