package JZ;

/**
 * 11旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 *
 * 示例 1：
 *
 * 输入：[3,4,5,1,2]
 * 输出：1
 * 示例 2：
 *
 * 输入：[2,2,2,0,1]
 * 输出：0
 *
 * 思路：二分法，O(log n)
 * @author Calvin
 * @version 1.0
 * @date 2020/8/29 16:09
 */
public class jz11 {
    public int minArray(int[] numbers) {
        int left = 0,right = numbers.length-1;
        while(left < right){
            int medi = left + (left+right)/2;
            if (numbers[medi] < numbers[right]){
                //在left到medi之间
                right = medi;
            }else if (numbers[medi] > numbers[right]){
                //在medi+1到right之间
                left = medi+1;
            }else {
                //不确定，但一定在left和right之间，而且right位置的元素和medi位置的相同，所以可以先排除right位置的元素
                right--;
            }
        }
        return numbers[left];
    }
}
