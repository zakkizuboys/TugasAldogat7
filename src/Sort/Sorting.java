/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sort;

/**
 *
 * @author zakki zuboys
 */
public class Sorting {

    String[] d, k;
    int[] z;

    //number
    public void show(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("");
    }

    public void bubbleSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                }
            }
        }
        show(a);
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public void selectionSort(int[] a) {
        if (a == null || a.length < 2) {
            return;
        }
        int n = a.length;

        for (int i = n - 1; i > 0; i--) {
            int k = i;
            for (int j = 0; j < i; j++) {
                if (a[j] > a[k]) {
                    k = j;
                }
            }
            swap(a, k, i);
        }
        show(a);
    }

    public void insertionSort(int[] a) {
        if (a == null || a.length < 2) {
            return;
        }
        int n = a.length;

        for (int i = 1; i < n; i++) {
            int target = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > target) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = target;
        }
        show(a);
    }

    public int partition(int[] a, int i, int j) {
        int pivot = a[i];
        while (i < j) {
            while (i < j && a[j] >= pivot) {
                j--;
            }
            a[i] = a[j];
            while (i < j && a[i] <= pivot) {
                i++;
            }
            a[j] = a[i];
        }
        a[i] = pivot;
        return i;
    }

    public static int[] randomArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) ((Math.random() - 0.5) * 1000) % 100;
        }
        return arr;
    }
    
}
