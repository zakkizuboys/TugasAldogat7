/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BinaryTree;

import java.util.Scanner;

/**
 *
 * @author zakkizuboys
 */
public class driver {

    public static void main(String[] args) {
        int z, k;
        char n;
        Scanner scan = new Scanner(System.in);
        BinTree tree = new BinTree();
        try {
            do {
                System.out.println("Pilihan menu");
                System.out.println("1. Masukkan Data ");
                System.out.println("2. Hapus Data");
                System.out.println("3. Cari Data dan Tmapilkan route");
//                System.out.println("4. Hitung Node");
//                System.out.println("5. Hitung Leaf");
//                System.out.println("6. Tampilkan Data");
                System.out.print("Masukkan pilihan anda : ");

                z = scan.nextInt();
                switch (z) {
                    case 1:
                        do {
                            System.out.print("Silahkan masukkan angka : ");
                            tree.insert(scan.nextInt());
                            System.out.println("ingin memasukkan angka lagi ?{y/n}");
                            n = scan.next().toLowerCase().charAt(0);
                        } while (n == 'y');
                        break;
                    case 2:
                        System.out.print("Masukkan Angka yang mau hapus : ");
                        tree.delete(scan.nextInt());
                        break;
                    case 3:
                        System.out.print("Masukkan Angka yang dicari : ");
                        int a = scan.nextInt();
                        System.out.println("Hasil pencarian : ");
                        tree.searchPaths(a);
                        break;
//                    case 4:
//                        System.out.println("Banyak Node = " + tree.countNodes());
//                        break;
//                    case 5:
//                        System.out.println("Banyak Leaf = " + tree.getLeafCount());
//                        break;
//                    case 6:
//                        tree.traverse(1);
//                        tree.traverse(2);
//                        tree.traverse(3);
//                        break;
                }
                System.out.println("");
                System.out.println("Ingin kembali ke menu awal? (1/0)");
                k = scan.nextInt();
            } while (k == 1);
            System.out.println("Terimakasih");
        } catch (Exception a) {
            System.err.println("Data yang anda masukkan salah");
        }

    }
}
