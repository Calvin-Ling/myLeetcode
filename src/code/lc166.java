package code;

import java.util.HashMap;
import java.util.Map;

/**
 * 166. 分数到小数
 * 题目：给出两个整数n和d，分别表示分子和分母，以字符串形式返回小数，如果小数部分为循环小数，则将循环部分括在括号内
 * 难度：中等
 * 思路：用哈希表存储余数出现在小数部分的位置，当再次出现时，则说明循环
 * 方法一：长除法
 */
public class lc166 {
    public String fractionToDecimal(int numerator, int denominator){
        if (numerator == 0){
            return "0";
        }
        StringBuilder fraction = new StringBuilder();
        //当只有分子或分母为负数时
        if (numerator < 0 ^ denominator < 0){
            fraction.append("-");
        }
        //将除数和除数转化为long类型，并加绝对值
        long dividend = Math.abs(Long.valueOf(numerator));
        long divisor = Math.abs(Long.valueOf(denominator));
        fraction.append(String.valueOf(dividend/divisor));
        long remainder = dividend % divisor;
        if (remainder == 0){
            return fraction.toString();
        }
        fraction.append(".");
        //记录余数和对应的商所在fraction中的索引
        Map<Long,Integer> map = new HashMap<>();
        while(remainder != 0){
            //余数一样，则小数部分开始循环
            if (map.containsKey(remainder)){
                fraction.insert(map.get(remainder),"(");
                fraction.append(")");
                break;
            }
            map.put(remainder,fraction.length());
            remainder *= 10;
            fraction.append(String.valueOf(remainder/divisor));
            remainder %= divisor;
        }
        return fraction.toString();
    }
}
