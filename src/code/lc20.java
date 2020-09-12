package code;

import java.util.Stack;

/**
 * 20.有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * 示例 1:
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * 输入: "{[]}"
 * 输出: true
 *
 * 难度：简单
 * 分类：字符串
 * 思路：利用栈来匹配括号
 * @author Calvin
 * @version 1.0
 * @date 2020/8/14 10:10
 */
public class lc20 {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '('||ch == '[' || ch == '{'){
                stack.push(ch);
            }else if (!stack.empty()){
                char peek = stack.peek();
                switch (ch){
                    case ')':if (peek=='(') stack.pop();else return false;break;
                    case ']':if (peek=='[') stack.pop();else return false;break;
                    case '}':if (peek=='{') stack.pop();else return false;break;
                }
            }else return false;
        }
        return stack.empty();
    }
}
