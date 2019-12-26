package com.booknara.problem.dc;

public class MergeSort {
    public void sort(int[] array, int n) {
        if (n < 2) {
            return;
        }

        int mid = n / 2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = array[i];
        }

        for (int i = mid; i < n; i++) {
            right[i - mid] = array[i];
        }

        sort(left, mid);
        sort(right, n - mid);

        merge(array, left, right, mid, n - mid);
    }

    private void merge(int[] array, int[] l, int[] r, int left, int right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] < r[j]) {
                array[k++] = l[i++];
            } else {
                array[k++] = r[j++];
            }
        }

        while (i < left) {
            array[k++] = l[i++];
        }

        while (j < right) {
            array[k++] = r[j++];
        }
    }
}
