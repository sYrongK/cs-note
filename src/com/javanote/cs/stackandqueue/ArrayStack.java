package com.javanote.cs.stackandqueue;
/*
Array로 Stack 구현
 */
public class ArrayStack {

    private int top;        //Stack 최상단. 포인터
    private int stackSize;  //Stack 사이즈
    private int stackArr[]; //Stack 배열

    public ArrayStack(int stackSize) {
        this.top = -1;  //  Stack 포인터 초기화
        this.stackSize = stackSize;
        this.stackArr = new int[this.stackSize];
    }

    public static void main(String[] args) {

        //  배열 size를 미리 할당한 후 Stack을 생성
        ArrayStack arrayStack = new ArrayStack(5);
        arrayStack.push(7);
        arrayStack.push(5);
        arrayStack.push(4);
        arrayStack.pop();
        arrayStack.push(6);
        arrayStack.pop();
        arrayStack.show();
        arrayStack.clear();
        System.out.println("pause");
    }

    //  Stack에 데이터 추가
    public void push(int data) {
        if (top == stackSize - 1) {
            //  오버플로우 : 더 이상 data가 들어갈 수 없게 가득 찼다.
            System.out.println("스택 오버플로우가 발생했습니다.");
        } else {
            stackArr[++top] = data;
        }
    }

    //  Stack 최상위 데이터 추출 후 삭제
    public int pop() {
        if (top == -1) {
            //  언더플로우 : 더 이상 data가 남아있지 않다.
            System.out.println("스택 언더플로우가 발생했습니다.");
            return 0;
        }
        return stackArr[top--];
    }
    
    //  Stack 초기화
    public void clear() {
        if (top == -1) {
            System.out.println("스택이 이미 비어있습니다.");
        } else {
            stackArr = new int[this.stackSize];
            System.out.println("스택이 초기화되었습니다.");
        }
    }

    public void show() {
        if (top == -1) {
            System.out.println("스택이 비어있습니다.");
        } else {
            System.out.println("=== 스택의 최상단 ===");
            for (int i = top; i >= 0; i--) {
                System.out.println(stackArr[i]);
            }
            System.out.println("=== 스택의 최하단 ===");
        }
    }
    
}
