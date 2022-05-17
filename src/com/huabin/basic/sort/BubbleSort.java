package com.huabin.basic.sort;

public class BubbleSort {

    public static void main(String[] args) {
        int[] ints = {3, 1, 45, 23, 78, 28};
        bubbleSort(ints);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }

    public static void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = false;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (flag) {
                break;
            }
        }
    }

}
