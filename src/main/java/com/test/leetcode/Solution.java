package com.test.leetcode;

import org.junit.Test;

import java.text.NumberFormat;
import java.util.*;

public class Solution {

    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> numSet = new HashSet<>();
        int number = 0;
        int numSetSize = 0;
        int length = nums.length;
        for (int num : nums) {
            numSet.add(num);
            if (numSet.size() == numSetSize) {
                number = num;
                break;
            }
            numSetSize = numSet.size();
        }
        return number;
    }

//    在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
//    示例:
//    现有矩阵 matrix 如下：
//            [
//            [1,   4,  7, 11, 15],
//            [2,   5,  8, 12, 19],
//            [3,   6,  9, 16, 22],
//            [10, 13, 14, 17, 24],
//            [18, 21, 23, 26, 30]
//            ]
//    给定 target = 5，返回 true。
//    给定 target = 20，返回 false。
//    限制：
//            0 <= n <= 1000
//            0 <= m <= 1000

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        boolean b = false;
        int m = matrix.length;
        for (int i = 0; i < m; i++) {
            int n = matrix[i].length;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == target) {
                    b = true;
                    break;
                }
            }
        }
        return b;
    }


//    请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
//    示例 1：
//    输入：s = "We are happy."
//    输出："We%20are%20happy."
//    限制： 0 <= s 的长度 <= 10000

    public String replaceSpace(String s) {
        StringBuilder s1 = new StringBuilder();
        String replaceStr = "%20";
        String block = " ";
        int index = 0;
        int lastBlockIndex = 0;
        int length = s.length();
        if (s.equals(block)) {
            return replaceStr;
        } else {
            for (int i = 0; i < length; i++) {
                if (block.charAt(0) == s.charAt(i)) {
                    s1.append(s, index, i).append(replaceStr);
                    index = i + 1;
                    lastBlockIndex = index;
                }
                if (i == length - 1) {
                    s1.append(s, lastBlockIndex, length);
                }
            }
        }
        return String.valueOf(s1);
    }

//    剑指 Offer 06. 从尾到头打印链表
//    输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
//    示例 1：
//    输入：head = [1,3,2]
//    输出：[2,3,1]
//    限制：0 <= 链表长度 <= 10000

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

//    public int[] reversePrint(ListNode head) {
//        Stack<ListNode> stack = new Stack<ListNode>();
//        ListNode node = head;
//        while (node != null){
//            stack.push(node);
//            node = node.next;
//        }
//        int size = stack.size();
//        int[] ints = new int[size];
//        for (int i = 0; i < size; i++) {
//            ints[i] = stack.peek().val;
//            stack.pop();
//        }
//        return ints;
//    }

    public int[] reversePrint(ListNode head) {
        ListNode node = head;
        int count = 0;
        while (node != null) {
            ++count;
            node = node.next;
        }

        int[] ints = new int[count];
        node = head;
        for (int i = (count - 1); i >= 0; i--) {
            ints[i] = node.val;
            node = node.next;
        }
        return ints;
    }

    //    剑指 Offer 10- I. 斐波那契数列
    public int fib(int n) {
        int result = 0;
        if (n >= 2) {
            int[] fibList = new int[n + 1];
            fibList[0] = 0;
            fibList[1] = 1;
            for (int i = 2; i <= n; i++) {
                fibList[i] = (int) ((fibList[i - 1] + fibList[i - 2]) % (1e9 + 7));
            }
            result = fibList[n];
        } else switch (n) {
            case 0:
                result = 0;
                break;
            case 1:
                result = 1;
                break;
        }
        return result;
    }

    //    剑指 Offer 10- II. 青蛙跳台阶问题

    /*
     * 此种解法精度控制出问题
     * */
/*    public int numWays(int n) {
        //result为总方案数
        int result = 1;
        //当台阶只有一级，方案只有一种
        if (n == 1) {
            return result;
        }
//        i为一步跳两个台阶的次数
        for (int i = 1; i <= (n / 2); i++) {
//            amn为组合的数量结果
            long amn = 0;
            //分子
            long amnUp = 1;
            //分母
            long amnDown = 1;
//            （n-i）为总步数
//            这步循环是为了求组合的阶乘公式结果
            for (int i1 = 0; i1 < i; i1++) {
                //如果出现A23，A34这样的情况，amn等于n
                if (i + 1 == n - i) {
                    amn = n - i;
                } else {
                    amnUp = amnUp * (n - i - i1);
                    amnDown = amnDown * (i - i1);
                    amn = amnUp / amnDown;
                }
            }
            result = (int) ((result + amn) % (1e9 + 7));
        }
        return result;
    }*/
/*//    动态规划，时间复杂度O（n）解法
    public int numWays(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int[] nums = new int[n + 1];
        nums[1] = 1;
        nums[2] = 2;
        for (int i = 3; i <= n; i++) {
            nums[i] = (int) ((nums[i - 1] + nums[i - 2]) % (1e9 + 7));
        }
        return nums[n];
    }*/


    //    动态规划，时间复杂度O（1）解法
    public int numWays(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        int next;
        for (int i = 3; i <= n; i++) {
            next = (int) ((first + second) % (1e9 + 7));
            first = second;
            second = next;
        }
        return second;
    }

    //    剑指 Offer 11. 旋转数组的最小数字
    public int minArray(int[] numbers) {
        //因为递增数组的旋转数组，先假设未旋转，则最小数字为首数字
        int minNum = numbers[0];
        int length = numbers.length;
        for (int i = 0; i < length - 1; i++) {
            if (numbers[i + 1] < numbers[i]) {
                minNum = numbers[i + 1];
            }
        }
        return minNum;
    }

    //    剑指 Offer 12. 矩阵中的路径
    public boolean exist(char[][] board, String word) {
        boolean isExist = false;
        int strLength = word.length();
        int rowLength = board.length;
        int verLength = board[0].length;

        HashMap<String, Map<Integer, List>> strMap = new HashMap<>();
        ArrayList jList = new ArrayList();

        for (int i = 0; i < strLength; i++) {
            char c = word.charAt(i);
            String str = String.valueOf(c + i);
            HashMap<Integer, List> intMap = new HashMap<>();
            for (int j = 0; j < rowLength; j++) {
                List verList = new ArrayList();
                for (int k = 0; k < verLength; k++) {
                    char c1 = board[j][k];
                        if (c == c1) {
                            if (i == 0) {
                                verList.add(k);
                                jList.add(j);
                                intMap.put(j, verList);
                                strMap.put(str, intMap);
                            }
                            if (jList.contains(j + 1)) {

                            }
                            if (jList.contains(j - 1)) {

                            }
                        }

                    }
                }
            }
            return isExist;
        }

        //    ""
        @Test
        public void testReplaceSpace () {
            Solution solution = new Solution();
            System.out.println(solution.replaceSpace("We are happy."));

            String s = "We are happy.";
            s.replaceAll(" ", "%20");
            System.out.println(s);
        }

        @Test
        public void testReversePrint () {
//        ListNode head = [1,2,3];
//        ListNode node = head;
//        int count = 0;
//        while (count < 11) {
//            count++;
//            node = node.next;
//        }
//        int[] ints = reversePrint(head);
//        System.out.println(ints);
        }


        //    斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
//    答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
//    提示：0 <= n <= 100
        @Test
        public void testfib () {
            int n = 55;
            for (int i = 45; i < n; i++) {
                System.out.println(fib(i));
            }

//        int fib = fib(0);
//        System.out.println(fib);
        }

        @Test
        public void testNumWays () {
            int n = 2;
            int result = numWays(n);
            System.out.println(result);
        }

        @Test
        public void testMinArray () {
            int[] nums = new int[]{2, 2, 2, 0, 1};
            int i = minArray(nums);
            System.out.println(i);
        }

    }