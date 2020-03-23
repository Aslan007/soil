package com.lx.soil.demos.leetcode;

public class Solution {
    /**
     * 反转整数
     *
     * @param x
     * @return
     */
    public int reserve(int x) {
        int result = 0;
        while (x != 0) {
            //判断是否溢出，若溢出则结果会不相等；
            if ((result * 10) / 10 != result) {
                return 0;
            }
            result = result * 10 + x % 10;
            x = x / 10;
        }
        return result;
    }

    /**
     * 判断是否回文数
     * 反转一半的数字，判断前后是否相等
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        //负数和最后一位是0，且不等于0的数一定不是回文
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return Boolean.FALSE;
        }
        //当原数字小于反转后的数字时，说明已经反转了一半了【】
        int reverNumber = 0;
        while (x > reverNumber) {
            reverNumber = reverNumber * 10 + x % 10;
            x = x / 10;
        }
        //当前后相等，或者为奇数位，去掉中间的一位后相等，说明是回文，否则不是
        return x == reverNumber || x == reverNumber / 10;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(65256));
    }

}
