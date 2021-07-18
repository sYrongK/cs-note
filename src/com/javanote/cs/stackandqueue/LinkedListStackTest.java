package com.javanote.cs.stackandqueue;

public class LinkedListStackTest {

    private StackNode top;  //  Stack의 top

    public static void main(String[] args) {
        LinkedListStackTest stack = new LinkedListStackTest();

        stack.top = null;   //  Stack 생성 후 top 초기화
        push(stack, 7);
        push(stack, 5);
        push(stack, 4);
        pop(stack);
        push(stack, 6);
        pop(stack);
        show(stack);
        System.out.println("pause");
    }

    //  새 node 생성
    public static void push(LinkedListStackTest stack, int data) {
        //  새 node 생성
        //  새 node 값 할당
        StackNode node =  new StackNode(data);
        node.next = stack.top;    //  새 node의 next는 기존 최상단 top을 참조
        stack.top = node;   //  새로운 node가 Stack의 top이 된다.
    }

    //  node 삭제 (top 추출)
    public static void pop(LinkedListStackTest stack) {
        if (stack.top == null) {
            System.out.println("스택 언더플로우가 발생했습니다.");
            return;
        }
        //  기존 Stack의 top을 temp에 저장
        StackNode tempNode = stack.top;
        int data = tempNode.data;
        //  새 top는 기존 top의 next값(기존 두 번째 node)!
        stack.top = tempNode.next;
        //  기존 top은 삭제
        tempNode = null;
    }

    public static void show(LinkedListStackTest stack) {
        //  Stack의 입구부터 들어가서 순차적으로 
        StackNode curr = stack.top;
        System.out.println("=== 스택의 최상단 ===");

        //  현재 top이 null이 아닐 때까지 출력
        while (curr != null) {
            System.out.printf("%d%n", curr.data);
            //  다음 node 출력
            curr = curr.next;
        }
        System.out.println("=== 스택의 최하단 ===");
    }

}

class StackNode {
    public int data;
    public StackNode next;

    public StackNode(int data) {
        this.data = data;
    }
}
