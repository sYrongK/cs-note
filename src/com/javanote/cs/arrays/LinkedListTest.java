package com.javanote.cs.arrays;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListTest {

    /*
     * 연결 리스트 (LinkedList)
     * : ArrayList와 함께 List를 구체화한 클래스.
     * LinkedList는 양방향 연결 리스트로 구현되어 있다.
     * 데이터 추가 삭제가 원활하다.
     * 잦은 삽입/삭제 시 유리. 검색이 잦을 경우엔 ArrayList
     * */
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(Arrays.asList("Orange", "Grape", "Watermelon", "Peach"));

        setIndex(list, 2, "Apple");

        System.out.println();
        print(list);

        System.out.println();
        removeIndex(list, 1);

        System.out.println();
        print(list);

        System.out.println();
        contains(list, "Watermelon");
    }

    static void create() {
        LinkedList<Integer> integers1 = new LinkedList<>();
        LinkedList<Integer> integers2 = new LinkedList<>();
        LinkedList<Integer> integers3 = new LinkedList<>(integers1);
        LinkedList<Integer> integers4 = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
    }

    /**
     * 원하는 index에 요소 삽입
     */
    static void setIndex(LinkedList<String> list, int index, String val) {
        list.set(index, val);
    }

    /**
     * 원하는 index 요소 삭제
     */
    static void removeIndex(LinkedList<String> list, int index) {
        list.remove(index);
    }

    /**
     * 전체 값 출력
     */
    static void print(LinkedList<String> list) {
        System.out.print("Print for-each loop :: ");
        for (String str : list) {
            System.out.print(str + " ");
        }
        System.out.println();

        System.out.print("Print loop :: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        System.out.print("Print iterator :: ");
                Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        System.out.print("Print listIterator :: ");
                ListIterator<String> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            System.out.print(listIterator.previous() + " ");
        }
        System.out.println();
    }

    /**
     * 값 존재 유무 확인
     */
    static void contains(LinkedList<String> list, String find) {
        System.out.println(list.contains(find));
    }
}
