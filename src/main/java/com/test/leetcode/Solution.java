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

    /**
     * 剑指 Offer 25. 合并两个排序的链表
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
/*//    递归
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }*/

//    迭代
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1), pre = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                pre.next = l1;
                pre = pre.next;
                l1 = l1.next;
            } else {
                pre.next = l2;
                pre = pre.next;
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            pre.next = l1;
        }
        if (l2 != null) {
            pre.next = l2;
        }
        return dummyHead.next;
    }

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
        } else {
            switch (n) {
                case 0:
                    result = 0;
                    break;
                case 1:
                    result = 1;
                    break;
            }
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

    /**
     * 编写一个函数，用于生成随机密码，入参为随机密码的长度，出参为生成的随机密码，要求生成的随机密码必须同时包含大写字母小写字母数字。
     * 生成随机码，参数为随机码长度，同时包含大小写字母和数字
     */
    public String getRandomNum(int length) {

        char[] c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

        ArrayList<Character> list = new ArrayList<Character>();

        if (length < 3) {
            return "输入的随机数字应大于3";
        } else {
            Random random = new Random();

            //先从10个数字中任取一个
            int i1 = random.nextInt(10);
            list.add(c[i1]);

            //再从26个大写字母中任取一个
            int i2 = 10 + random.nextInt(26);
            list.add(c[i2]);

            //再从26个小写字母中任取一个
            int i3 = 36 + random.nextInt(26);
            list.add(c[i3]);

            //剩余的从全部中任选
            for (int i = 0; i < length - 3; i++) {
                int i4 = random.nextInt(62);
                list.add(c[i4]);
            }

            //打乱顺序
            ArrayList<Integer> indexList = new ArrayList<>();
            while (indexList.size() < length) {
                //随机产生下标值
                int i = random.nextInt(length);
                if (!indexList.contains(i)) {
                    indexList.add(i);
                }
            }

            //按随机产生的下标值，将随机码组成字符
            StringBuffer s = new StringBuffer();
            for (int i = 0; i < length; i++) {
                int index = indexList.get(i);
                s.append(list.get(index));
            }
            return s.toString();
        }
    }


    //    ""
    @Test
    public void testReplaceSpace() {
        Solution solution = new Solution();
        System.out.println(solution.replaceSpace("We are happy."));

        String s = "We are happy.";
        s.replaceAll(" ", "%20");
        System.out.println(s);
    }

    @Test
    public void testReversePrint() {
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
    public void testfib() {
        int n = 55;
        for (int i = 45; i < n; i++) {
            System.out.println(fib(i));
        }

//        int fib = fib(0);
//        System.out.println(fib);
    }

    @Test
    public void testNumWays() {
        int n = 2;
        int result = numWays(n);
        System.out.println(result);
    }

    @Test
    public void testMinArray() {
        int[] nums = new int[]{2, 2, 2, 0, 1};
        int i = minArray(nums);
        System.out.println(i);
    }

    @Test
    public void testMergeTwoLists() {
        ListNode l1 = new ListNode(1);
//        ListNode l1next = l1.next;
//        l1next.val = 2;
//        l1next.next.val = 4;
        ListNode l2 = new ListNode(2);
//        ListNode l2next = l2.next;
//        l2next.val = 3;
//        l2next.next.val = 4;
        ListNode listNode = mergeTwoLists(l1, l2);
        System.out.println(listNode);
    }

    @Test
    public void testGetRandomNum () {
        String randomNum = getRandomNum(5);
        System.out.println(randomNum);
    }

}