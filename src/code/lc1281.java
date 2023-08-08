package code;

public class lc1281 {
    public int subtractProductAndSum(int n) {
        int sum = 0, multi = 1;
        String s = n + "";
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - '0';
            sum += num;
            multi *= num;
        }
        return multi - sum;
    }
}
