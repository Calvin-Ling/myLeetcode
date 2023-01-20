package code;

/*如果一个密码满足以下所有条件，我们称它是一个 强 密码：

        它有至少 8 个字符。
        至少包含 一个小写英文 字母。
        至少包含 一个大写英文 字母。
        至少包含 一个数字 。
        至少包含 一个特殊字符 。特殊字符为："!@#$%^&*()-+" 中的一个。
        它 不 包含 2 个连续相同的字符（比方说 "aab" 不符合该条件，但是 "aba" 符合该条件）。
        给你一个字符串 password ，如果它是一个 强 密码，返回 true，否则返回 false 。

        来源：力扣（LeetCode）
        链接：https://leetcode.cn/problems/strong-password-checker-ii
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class lc2299 {
    public boolean strongPasswordCheckerII(String password) {
        if (password.length() < 8) return false;
        Character[] specialChars = new Character[] {
                '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '+'
        };
        Character[] upperCase = new Character[26];
        Character[] lowerCase = new Character[26];
        for (int i = 0; i < 26; i++) {
            upperCase[i] = (char) ('A' + i);
            lowerCase[i] = (char) ('a' + i);
        }
        boolean has = false;
        for (Character specialChar : specialChars) {
            has = password.contains(specialChar+"");
            if (has) break;
        }
        if (!has) return false;
        for (Character character : upperCase) {
            has = password.contains(character+"");
            if (has) break;
        }
        if (!has) return false;
        for (Character character : lowerCase) {
            has = password.contains(character+"");
            if (has) break;
        }
        if (!has) return false;
        for (int i = 0; i < 10; i++) {
            has = password.contains(i+"");
            if (has) break;
        }
        if (!has) return false;
        for (int i = 1; i < password.length(); i++) {
            if (password.charAt(i) == password.charAt(i-1)) return false;
        }
        return true;
    }
}
