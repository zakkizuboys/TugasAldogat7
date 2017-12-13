/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sort;

import java.util.Scanner;

/**
 *
 * @author zakki zuboys
 */
public class driver {

    public static void main(String[] args) {
        Sorting sr = new Sorting();
        Scanner sc = new Scanner(System.in);
        int z,k,n;
        int[] array = null, array_input;
        
        System.out.println("Masukkan banyak data : ");
        n = sc.nextInt();
        int[] loads = {n};
        
        for (int i = 0; i < loads.length; i++) {
            array_input = sr.randomArray(loads[i]);
            array = new int[loads[i]];
            System.arraycopy(array_input, 0, array, 0, loads[i]);

            System.out.println("Nilai Awal :");
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[j] + " ");
            }
            System.out.println("\n");
        }
        try {
            do {
                System.out.println("Algoritma Pengurutan");
                System.out.println("1. Selection Sort");
                System.out.println("2. Insertion Sort");
                System.out.println("3. Bubble Sort");
                System.out.print("Pilih algoritma pengurutan : ");
                z = sc.nextInt();
                switch (z) {
                    case 1:
                        sr.insertionSort(array);
                        break;
                    case 2:
                        sr.selectionSort(array);
                        break;
                    case 3:
                        sr.bubbleSort(array);
                        break;
                }
                System.out.println("");
                System.out.println("Ingin kembali ke menu awal? (1/0)");
                k = sc.nextInt();
            } while (k == 1);
            System.out.println("Terimakasih");
        } catch (Exception a) {
            System.err.println("Data yang anda masukkan salah");
        }

    }
}
