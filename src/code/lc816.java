package code;

import java.util.LinkedList;
import java.util.List;

/*
我们有一些二维坐标，如 "(1, 3)" 或 "(2, 0.5)"，然后我们移除所有逗号，小数点和空格，得到一个字符串S。返回所有可能的原始字符串到一个列表中。

        原始的坐标表示法不会存在多余的零，所以不会出现类似于"00", "0.0", "0.00", "1.0", "001", "00.01"或一些其他更小的数来表示坐标。此外，一个小数点前至少存在一个数，所以也不会出现“.1”形式的数字。

        最后返回的列表可以是任意顺序的。而且注意返回的两个数字中间（逗号之后）都有一个空格。

        来源：力扣（LeetCode）
        链接：https://leetcode.cn/problems/ambiguous-coordinates
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class lc816 {
    public List<String> ambiguousCoordinates(String s) {
        List<String> res = new LinkedList<>();
        String num = s.substring(1, s.length() - 1);
        for (int split = 1; split < num.length(); split++) {
            String l = num.substring(0, split);
            String r = num.substring(split);
            List<String> lList = getNumsAsStrs(l);
            List<String> rList = getNumsAsStrs(r);
            if (lList.isEmpty() || rList.isEmpty()) {
                continue;
            }
            for (String s1 : lList) {
                for (String s2 : rList) {
                    res.add("(" + s1 + ", " + s2 +")");
                }
            }
        }
        return res;
    }

    private List<String> getNumsAsStrs(String s) {
        List<String> res = new LinkedList<>();
        // 1 位数
        if (s.length() == 1) {
            res.add(s);
            return res;
        }
        // 多位数
        if (!s.startsWith("0")) {
            res.add(s);
        }
        for (int pointIndex = 1; pointIndex < s.length(); pointIndex++) {
            String integerPart = s.substring(0, pointIndex);
            String decimalPart = s.substring(pointIndex);
            boolean intPartCondition = integerPart.length() == 1 || !integerPart.startsWith("0");
            boolean decimalPartCondition = !decimalPart.endsWith("0");
            if (intPartCondition && decimalPartCondition) {
                res.add(integerPart + "." + decimalPart);
            }
        }
        return res;
    }
}
