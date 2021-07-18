package com.javanote.cs.stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

/*
Queue 기본
 */
public class QueueTest {

    /*
    자바에서 Queue는 LinkedList를 활용하여 생성해야 한다.
     */

    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();
        //  Queue에 값을 추가. add & offer
        queue.add(1);
        queue.offer(2);
        queue.add(3);
        queue.add(4);
        queue.offer(5);
        //  Queue의 첫번째 값 참조
        System.out.println(queue.peek());
        //  Queue에 첫번째 값을 반환하고 있다면 제거 없다면 null. poll & remove
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue.remove());
        System.out.println(queue.peek());
        //  queue 초기화
        queue.clear();
        System.out.println(queue.isEmpty());
        //  Queue의 첫번쨰 값을 반환한다. 없으면 NoSuchElementException 반환
        queue.element();
    }
}
