package com.test.leetcode;

//剑指 Offer 09. 用两个栈实现队列

import java.util.Stack;

class CQueue {
    Stack<Object> stack1;
    Stack<Object> stack2;

    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.empty()) {
            return -1;
        } else {
            int pop = (int) stack2.pop();
            return pop;
        }
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */