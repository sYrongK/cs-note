package com.javanote.cs.arrays;

public class SinglyLinkedListTest {
    /*
    * 단일 연결 리스트 (Single LinkedList)
    * : 데이터들이 한 쪽 방향으로만 연결되어 있는 list
    * 자기자신이 가진 정보(data)와 다음 요소를 가리키는 포인터(next)로 구성되어 있다.
    * */
    private static SinglyLinkedNode head = null;

    public static void main(String[] args) {

        addAtHead(1);

        get(1);

        addAtTail(3);
    }

    /**
     * index의 데이터를 리턴
     * @return
     */
    static SinglyLinkedNode get(int index) {
        /*
        * 연결리스트의 처음부터 index번째까지 따라가며 찾는 위치의 값을 가져온다.
        * */
        if (head == null) {
            System.out.println("연결 리스트가 비어 있습니다.");
            return null;
        }

        SinglyLinkedNode curr = head;
        for (int i = 0; i < index; i++) {
            if (curr.next == null) {
                return curr;
            }
            curr = curr.next;
        }
        System.out.println("검색 결과 :: " + curr.data);
        return curr;
    }

    /**
     * 맨 앞에 node 추가
     */
    static void addAtHead(int val) {
        /*
        * 새 node의 포인터가 head를 가리키게 한다.
        * */
        if (head == null) {
            head = new SinglyLinkedNode(val);
            return;
        }
        SinglyLinkedNode node = new SinglyLinkedNode(val);
        node.next = head;
        head = node;
    }

    /**
     * 맨 뒤에 node 추가
     */
    static void addAtTail(int val) {
        /*
        * tail까지 이동 후, tail next가 새로운 tail을 가리키게 하면 된다.
        * */
        SinglyLinkedNode node = new SinglyLinkedNode(val);

        if (head == null) {
            head = node;
            return;
        }

        SinglyLinkedNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = node;
    }

    /**
     * 특정 index에 node 추가
     */
    static void addAtIndex(int index, int val) {
        /*
        * 특정 index의 node와 그 이전 node를 찾고
        * 이전 node의 next에 새 노드를 넣고,
        * 새 node의 next에 그 node의 next를 넣으면 된다.
        * */
        SinglyLinkedNode node = new SinglyLinkedNode(val);

        if (head == null) {
            if (index == 0) {
                head = node;
            } else {
                System.out.println("바꾸려는 index보다 리스트가 짧습니다.");
            }
            return;
        }

        SinglyLinkedNode prev = null;
        SinglyLinkedNode curr = head;
        for (int i = 0; i < index; i++) {
            if (curr == null) {
                //  리스트가 이미 끝났음
                return;
            }
            prev = curr;
            curr = curr.next;
        }
        
        //  prev의 next에 새 node를, 새 node의 next에 curr node를
        //  TODO 이해 잘 안가는데?
        if (prev == null) { //
            //  node의 next에 head를, node를 head로
            node.next = head;
            head = node;
        } else if (curr == null) {  //  prev가 head다
            curr = node;
            prev.next = curr;
        } else {
            prev.next = node;
            node.next = curr;
        }
    }

    static void deleteAtIndex(int index) {

    }

}
