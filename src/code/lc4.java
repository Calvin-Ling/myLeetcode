package code;

/**
 * 4.寻找两个有序数组的中位数
 * 题意：两个大小为m和n的有序数组，在时间复杂度O（log(m+n)）内找出两个数组的中位数，假设两个数组不会同时为空
 * 难度：困难
 * 分类：数组
 * 思路：首先联想到归并排序中的合并操作，应该用递归来实现，结果没有写递归，时间复杂度达到了O(n+m)
 * 然后提交，结果还击败了大多数用户，原来是因为lc上的测试不会检测时间复杂度是否正确
 *方法一：
 */
public class lc4 {
    public double findMedianSortedArrays(int[] nums1,int[] nums2){
        /*
        //while合并数组法：
        int m = (nums1 == null)? 0 : nums1.length;
        int n = (nums2 == null)? 0 : nums2.length;
        int[] nums = new int[m+n];
        int p = 0;
        int q = 0;
        int k = 0;
        while(p < m && q < n){
            if (nums1[p] < nums2[q]){
                nums[k++] = nums1[p++];
            }
            else {
                nums[k++] = nums2[q++];
            }
        }
        if (p < m){
            while (p < m){
                nums[k++] = nums1[p++];
            }
        }
        if (q < n){
            while (q < n){
                nums[k++] = nums2[q++];
            }
        }
        if (k == 1){
            return nums[0];
        }
        else {
            return (k-1)%2 == 0 ? nums[(k-1)/2] : (nums[(k-1)/2]+nums[(k-1)/2+1])*1.0/2;
        }
         */

        //采用二分法,求第k小的数：
        int n = nums1.length;
        int m = nums2.length;
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;
        //亮点一：
        //将偶数和奇数的情况合并，如果是奇数，会求两次同样的 k 。
        return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
    }
    private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        //k表示这两个数组中的第 k 小的数，k 从1开始
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        //亮点二：
        //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
        if (len1 > len2) return getKth(nums2, start2, end2, nums1, start1, end1, k);
        //也即这里nums1肯定是长度较小的数组，若num1为空，则返回num2的中间的数
        if (len1 == 0) return nums2[start2 + k - 1];

        //如果是求第一小的数，那即是最小的数
        if (k == 1) return Math.min(nums1[start1], nums2[start2]);

        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;
        //其他情况则二分法，即是找num1的k/2小的数及num2的k/2小的数

        if (nums1[i] > nums2[j]) {
            //画图分析，这里应该选num1的全部及num2的后半段
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        }
        else {
            //画图分析，这里应该选num1的后半段及num2的全部
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }
}
