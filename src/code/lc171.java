package code;

/**
 * 171.Excel表列序列号
 * 题意：给定一个Excel表格中的列名称，返回其相应的序列号，如 A -> 1; B -> 2; … Z -> 26; AA ->27; AB -> 28; …
 * 难度：简单
 * 分类：数、数组
 * 思路：String存储输入，将字母串看成26进制数，将26进制数转成10进制。
 */
public class lc171 {
    public int titleToNumber(String s){
        int result = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            int base = 1;
            for (int j = 0; j < s.length()-1-i; j++) {
                base *= 26;
            }
            result = result + (s.charAt(i) - 'A' + 1)*base;
        }
        return result;
    }
}
