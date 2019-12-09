package com.booknara.practice;

import java.util.Arrays;
import java.util.List;

public class Matrix {

    public static void main(String[] args) {
        new Matrix().getRow(3);
    }

    public List<Integer> getRow(int rowIndex) {
        Integer[] arr = new Integer[rowIndex + 1];
        Arrays.fill(arr, 0);
        arr[0] = 1;

        System.out.println("stop : " + Arrays.toString(arr));
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i; j > 0; j--) {
                arr[j] = arr[j] + arr[j - 1];
                System.out.println("stop : " + Arrays.toString(arr));
            }
        }

        return Arrays.asList(arr);
    }

}
