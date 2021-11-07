package com.javanote.cs.arrays;

import java.util.*;

public class ArraysTest {
    //  TODO 정렬, 삭제

    public static void main(String[] args) {
        int[] numbers = create();

        getElements(numbers);

        getRandomElements(numbers);

        isEmpty(numbers);

        numbers = add(numbers, 9);
        getElements(numbers);

        shuffle(numbers);

        removeDuplicate(numbers);
    }

    /**
     * 배열 생성
     */
    static int[] create() {
        int[] numbers = new int[4];
        numbers[0] = 1;
        numbers[1] = 2;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                numbers[i] = 7;
            }
        }
        return numbers;
    }

    /**
     * 배열 요소 읽기
     */
    static void getElements(int[] arr) {
        int first = arr[0];
        int last = arr[arr.length - 1];
        System.out.println("first :: "+ first +" last :: "+ last);
    }

    static void getRandomElements(int[] arr) {
        int random = arr[new Random().nextInt(arr.length)];
        System.out.println("Random :: "+ random);
    }

    /**
     * 배열 비어있는지
     */
    static void isEmpty(int[] arr) {
        System.out.println(arr == null || arr.length == 0);
    }

    /**
     * 배열 추가
     */
    static int[] add(int[] arr, int item) {
        int[] newArrays = Arrays.copyOf(arr, arr.length + 1);
        newArrays[newArrays.length-1] = item;
        return newArrays;
    }

    /**
     * 배열 요소 섞기 shuffle
     */
    static void shuffle(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            int index = new Random().nextInt(arr.length);
            if (index != i) {
                int value = arr[index];
                arr[index] = arr[i];
                arr[i] = value;
            }
        }
        for (int number : arr) {
            System.out.println("After Shuffle :: " + number);
        }
    }

    /**
     * 중복 제거
     */
    static void removeDuplicate(int[] arr) {
        /*
        * wrap : primitive 타입을 하나의 객체로 만든다. 객체가 primitive 타입을 갖는 형태.
        * Object타입을 인자로 받는 메서드 등을 사용할 때 wrap해주는 과정이 필요하다.
         * */
        /*
        * 배열의 중복제거를 위해 배열을 Set으로 바꿔주고 싶음.
        * 그런데 Set은  Generics로 객체타입을 갖는다고 되어있다.
        * int를 wrap해줘야 함.
        * */

        //  box
        List<Integer> list = new ArrayList<>();
        for (int number : arr) {
            list.add(number);
        }
        //  Integer : Wrapper Class
        HashSet<Integer> set = new HashSet<>(list);

        //  unbox
        Integer[] integers = set.toArray(new Integer[set.size()]);
        int[] newArr = new int[integers.length];
        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = integers[i];
            System.out.println("Remove Duplicate :: " + newArr[i]);
        }
    }
}
