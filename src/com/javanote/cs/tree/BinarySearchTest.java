package com.javanote.cs.tree;
/*
이진 탐색 Binary Search 구현
 */
public class BinarySearchTest {

    private static Integer[] test = {1, 3, 4, 5, 7, 11, 18, 33, 45, 60};

    public static void main(String[] args) {

        Integer result1 = search(test, 18);

        System.out.println("Search1 Success : " + result1);

        Integer result2 = search(test, 3);

        System.out.println("Search2 Success : " + result2);

        Integer result3 = search(test, 11);

        System.out.println("Search3 Success : " + result3);

        Integer result4 = search(test, 7);

        System.out.println("Search4 Success : " + result4);

    }

    public static Integer search(Integer[] arr, Integer key) {

        //  배열의 중간값의 index
        Integer medium = arr.length/ 2;

        if (key < arr[medium]) {
            for (int i = 0; i < medium; i++) {
                if (key == arr[i]) {
                    return arr[i];
                }
            }
        } else if (key > arr[medium]) {

            for (int j = arr.length-1; j > medium; j--) {
                if (key == arr[j]) {
                    return arr[j];
                }
            }

        } else if (key == arr[medium]) {
            return arr[medium];
        }
        return -1;
    }
}
