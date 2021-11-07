package com.javanote.cs.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ArraysSearchTest {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("생성할 배열의 길이를 정하세요 > ");
        int first = s.nextInt();
        System.out.println();

        System.out.print("배열의 길이에 맞게 숫자를 입력하세요 >");
        int[] numbers = new int[first];
        for (int i = 0; i < first; i++) {
            numbers[i] = s.nextInt();
        }

        System.out.print("선형 탐색으로 배열에서 찾아 올 숫자를 입력하세요 >");
        int find1 = s.nextInt();

        doLinearSearch(numbers, find1);

        System.out.print("이진 탐색으로 배열에서 찾아 올 숫자를 입력하세요 >");
        int find2 = s.nextInt();
        doBinarySearch(numbers, find2);
    }

    /*
     * 선형 검색 (Linear Search)
     * : 요소가 직선 모양으로 늘어선 배열에서 원하는 키 값을 앞에서부터 끝까지 돌면서 찾는 검색
     * */
    static void doLinearSearch(int[] arr, int find) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (find == arr[i]) {
                index = i;
            }
        }

        if (index >= 0) {
            System.out.println("숫자는 " + (index + 1) + " 번째에 위치합니다.");
        } else {
            System.out.println("해당 요소를 찾지 못했습니다.");
        }
    }

    /*
    * 이진탐색
    * : 정렬된 리스트에서 중간 값을 임의로 선택해 찾고자 하는 값과 대소를 비교하는 방식
    * */
    static void doBinarySearch(int[] arr, int find) {
        //  sort
        Arrays.sort(arr);

        System.out.print("Sorted Array :: ");
        for (int number : arr) {
            System.out.print(number);
        }
        System.out.println();

        int index = Arrays.binarySearch(arr, find);

        if (index >= 0) {
            System.out.println("숫자는 " + (index + 1) + " 번째에 위치합니다.");
        } else {
            System.out.println("해당 요소를 찾지 못했습니다.");
        }
    }

}
