package com.javanote.cs.stackandqueue;
/*
Linked List로 Stack 구현
 */
public class LinkedListStack {

    private ListStackNode head; //  첫 node 참조용
    private ListStackNode top;  //  Stack의 top 포인터
    private int stackSize;      //  Stack 사이즈

    public LinkedListStack(int stackSize) {
        head = null;    //  head 초기화
        top = null;     //  top 포인터 초기화
        this.stackSize = stackSize; //  Stack 사이즈 초기화
    }

    //  Stack empty 체크 (언더플로우 여부)
    public boolean empty() {
        return top == null;
    }
    
    //  Stack 다 찼는지 체크 (오버플로우 여부)
    public boolean full() {
        if (empty()) {
            return false;
        } else {
            int nodeCnt = 0;
            ListStackNode tempNode = head;  //  tempNode에 head 할당
            
            while (tempNode.link != null) {
                ++nodeCnt;
                tempNode = tempNode.link;   //  다음 node를 참조
            }
            //   Stack 사이즈와 node 갯수가 동일한지
            return this.stackSize - 1 == nodeCnt;
        }
    }

    //  Stack에 node 삽입
    public void push(String data) {
        //  새로운 node 생성
        ListStackNode newNode = new ListStackNode(data);
        if (full()) {
            System.out.println("스택 오버플로우가 발생했습니다.");
            return;
        } else if (empty()) {
            //  Stack이 비어있다 = top 포인터가 null이다.
            //  top은 새로운 node를 참조하면 된다.
            this.head = newNode;    //  첫 node 참조용
            this.top = this.head;
        } else {
            //  top 포인터가 null이 아니다 = 새 노드를 top에 넣으면 된다.
            //  기존에 node들 중 최하단 전까지 node들을 다음 node를 참조하도록 하면 된다.
            ListStackNode tempNode = top;

            while (tempNode.link != null) {
                tempNode = tempNode.link;   //  다음 node를 참조
            }
            //  tempNode 마지막 노드의 link가 다음 node를 참조하도록 함
            tempNode.link = newNode;
        }
    }
}

/*
    Stack을 구성하는 Node 클래스
 */
class ListStackNode {

    private String data;
    public ListStackNode link;

    public ListStackNode() {
        this.data = null;
        this.link = null;
    }

    public ListStackNode(String data) {
        this.data = data;
        this.link = null;
    }

    public ListStackNode(String data, ListStackNode link) {
        this.data = data;
        this.link = link;
    }

    public String getDate() {
        return this.data;
    }
}
