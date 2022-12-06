package Homework3;

import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[][] A = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = input.nextInt();
            }
        }
        //算1的个数
        int s = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 1) {
                    s = s + 4;
                }
            }
        }
        //算重数
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (A[i][j] == 1 && A[i][j + 1] == 1) {
                    s = s - 2;
                }
            }
        }
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n ; j++) {
                if (A[i][j] == 1 && A[i + 1][j] == 1) {
                    s = s - 2;
                }
            }
        }
        System.out.printf("%d",s);
    }
}
