package code;

import java.util.LinkedList;
import java.util.List;

/**
 * 17.电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 难度：中等
 * 分类：字符串、递归、排列组合
 * 思路：暴力递归
 * @author Calvin
 * @version 1.0
 * @date 2020/8/26 23:02
 */
public class lc17 {
    char[][] chars = {{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
    List<String> res = new LinkedList<>();
    StringBuilder sb = new StringBuilder();
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return res;
        func(digits,0);
        return res;
    }

    public void func(String digits,int index){
        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        }
        int temp = digits.charAt(index)-'2';
        for (int i = 0; i < chars[temp].length; i++) {
            sb.append(chars[temp][i]);
            func(digits,index+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
