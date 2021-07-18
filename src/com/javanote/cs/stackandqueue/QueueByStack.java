package com.javanote.cs.stackandqueue;

import java.util.Stack;

public class QueueByStack {
    private static Stack<Integer> stack_a;  //  add할 떄 사용
    private static Stack<Integer> stack_b;  //  읽는 연산이 필요할 때 사용
    private static int stackSize;

    public static void main(String[] args) {
        stack_a = new Stack<>();
        stack_b = new Stack<>();

        //  Stack A : (top) 5 4 3 2 1
        enQueue(1);
        enQueue(2);
        enQueue(3);
        enQueue(4);
        enQueue(5);

        //  Stack B : (top) 1 2 3 4 5
        deQueue();

    }

    //  Stack A에 push
    public static void enQueue(int data) {
        stack_a.push(data);
        System.out.printf("%s%d%n", "Stack A - top : ", stack_a.peek());
    }

    //  Stack B에 push
    public static int deQueue() {
        if (stack_b.isEmpty()) {
            while (!stack_a.isEmpty()) {
                stack_b.push(stack_a.pop());
                System.out.printf("%s%d%n", "Stack B - top : ", stack_b.peek());
            }
        }
        //  Stack B가 비어있는 상태가 아니라면, Queue 순서가 꼬일 수 있다.
        return stack_b.pop();
    }
}
