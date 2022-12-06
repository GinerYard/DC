package Homework3;

import java.util.Scanner;

public class Problem5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[][] A = new int[n + 8][n + 8];
        for (int i = 0; i < n + 8; i++) {
            for (int j = 0; j < n + 8; j++) {
                A[i][j] = 0;
            }
        }
        for (int i = 4; i < n + 4; i++) {
            for (int j = 4; j < n + 4; j++) {
                A[i][j] = input.nextInt();
            }
        }

        int k = 0;


        int[][] B = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                B[i][j] = 0;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int s = 0;
                //横向
                for (int a = 0; a < 5; a++) {
                    if (A[i + 4][j + 4 + a] + A[i + 4][j + 3 + a] + A[i + 4][j + 2 + a] + A[i + 4][j + 1 + a] + A[i + 4][j + a] == 4 && A[i + 4][j + 4] == 0) {
                        B[i][j] = 1;
                        s = 1;
                    }
                }
                //纵向
                for (int a = 0; a < 5; a++) {
                    if (A[i + 4 + a][j + 4] + A[i + 3 + a][j + 4] + A[i + 2 + a][j + 4] + A[i + 1 + a][j + 4] + A[i + a][j + 4] == 4 && A[i + 4][j + 4] == 0) {
                        B[i][j] = 1;
                        s = 1;
                    }
                }
                //左上到右下
                for (int a = 0; a < 5; a++) {
                    if (A[i + 4 + a][j + 4 + a] + A[i + 3 + a][j + 3 + a] + A[i + 2 + a][j + 2 + a] + A[i + 1 + a][j + 1 + a] + A[i + a][j + a] == 4 && A[i + 4][j + 4] == 0) {
                        B[i][j] = 1;
                        s = 1;
                    }
                }
                //右上到左下
                for (int a = 0; a < 5; a++) {
                    if (A[i + 4 + a][j + 4 - a] + A[i + 3 + a][j + 5 - a] + A[i + 2 + a][j + 6 - a] + A[i + 1 + a][j + 7 - a] + A[i + a][j + 8 - a] == 4 && A[i + 4][j + 4] == 0) {
                        B[i][j] = 1;
                        s = 1;
                    }
                }
                k = k + s;
            }
        }
        if (k == 0) {
            System.out.printf("-1");
        }
        int flag =0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (B[i][j] == 1&&flag==0) {
                    System.out.printf("%d %d", i + 1, j + 1);
                    flag=1;
                    j++;
                }
                if (B[i][j] == 1&&flag==1) {
                    System.out.printf("\n%d %d", i + 1, j + 1);
                }

            }
        }


    }
}
