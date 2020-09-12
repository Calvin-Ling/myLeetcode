package code;

/**
 * 459.重复的子字符串
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 * 示例 1:
 * 输入: "abab"
 * 输出: True
 * 解释: 可由子字符串 "ab" 重复两次构成。
 * 示例 2:
 * 输入: "aba"
 * 输出: False
 * 示例 3:
 * 输入: "abcabcabcabc"
 * 输出: True
 * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 * 难度：简单
 * 分类：字符串
 * 思路：思路一：枚举，思路二：
 * @author Calvin
 * @version 1.0
 * @date 2020/8/24 9:18
 */
public class lc459 {
    public boolean repeatedSubstringPattern(String s) {
//        return func1(s);
        return func2(s);
    }

    public boolean func2(String s){
        return (s+s).substring(1,2*s.length()-1).contains(s);
    }

    public boolean func1(String s){
        if(s == null || s.length() == 0) return false;
        String subStr = s.charAt(0)+"";
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == subStr.charAt(0) && isSubString(s,subStr)) return true;
            subStr += s.charAt(i);
        }
        return false;
    }

    public boolean isSubString(String s,String subStr){
        if (s.length()%subStr.length()!=0) return false;
        int c = s.length()/subStr.length();
        String res = "";
        for (int i = 0; i < c; i++) {
            res += subStr;
        }
        return s.equals(res);
    }
}
