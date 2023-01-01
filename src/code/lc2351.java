package code;

import java.util.HashSet;

/*
给你一个由小写英文字母组成的字符串 s ，请你找出并返回第一个出现 两次 的字母。

        注意：

        如果 a 的 第二次 出现比 b 的 第二次 出现在字符串中的位置更靠前，则认为字母 a 在字母 b 之前出现两次。
        s 包含至少一个出现两次的字母。

        来源：力扣（LeetCode）
        链接：https://leetcode.cn/problems/first-letter-to-appear-twice
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class lc2351 {
    public char repeatedCharacter(String s) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                return c;
            }
            set.add(c);
        }
        return ' ';
    }

    public char repeatedCharacter2(String s) {
        int seen = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int x = ch - 'a';
            if ((seen & (1 << x)) != 0) {
                return ch;
            }
            seen |= (1 << x);
        }
        return ' ';
    }
}
