package com.javanote.cs.stackandqueue;

import java.util.Stack;
/*
Stack 기본
 */
public class StackTest {

    public static void main(String[] args) {
        /*
         * stack의 사이즈
         * stack의 최상단 top 제일 나중에 들어온 값
         * stack의 최하단 제일 먼저 들어온 값
         * stack은 추상 자료형이기 때문에 구현 방법을 따로 명시하지 않아 다양한 방법으로
         * 구현이 가능하다?
         *
         * */
        test1();

    }

    public static void test1() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.contains(2));
        stack.push(3);
        stack.pop();
        System.out.println(stack.peek());
        stack.push(3);
        System.out.println(stack.peek());
        System.out.println(stack.empty());
        stack.clear();
        System.out.println(stack.empty());
    }
}
