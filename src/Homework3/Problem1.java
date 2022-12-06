package Homework3;

import java.util.Scanner;

public class Problem1 {
    //主程序
    public static void main(String[] args) {
        //定义矩阵
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[][] A = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = input.nextInt();
            }
        }
        int[][] B = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                B[i][j] = input.nextInt();
            }
        }
        //定义分块矩阵
        int[][] A1 = new int[n / 2][n / 2];
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                A1[i][j] = A[i][j];
            }
        }
        int[][] A2 = new int[n / 2][n / 2];
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                A2[i][j] = A[i][j + n / 2];
            }
        }
        int[][] A3 = new int[n / 2][n / 2];
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                A3[i][j] = A[i + n / 2][j];
            }
        }
        int[][] A3T = new int[n / 2][n / 2];
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                A3T[i][j] = A3[j][i];
            }
        }
        int[][] A4 = new int[n / 2][n / 2];
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                A4[i][j] = A[i + n / 2][j + n / 2];
            }
        }
        int[][] B1 = new int[n / 2][n / 2];
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                B1[i][j] = B[i][j];
            }
        }
        int[][] B2 = new int[n / 2][n / 2];
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                B2[i][j] = B[i][j + n / 2];
            }
        }
        int[][] B2T = new int[n / 2][n / 2];
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                B2T[i][j] = B2[j][i];
            }
        }

        int[][] B3 = new int[n / 2][n / 2];
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                B3[i][j] = B[i + n / 2][j];
            }
        }
        int[][] B4 = new int[n / 2][n / 2];
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                B4[i][j] = B[i + n / 2][j + n / 2];
            }
        }
        //定义分块运算
        int[][] C1 = new int[n / 2][n / 2];
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                C1[i][j] = A1[i][j] + B1[i][j];
            }
        }
        int[][] C4 = new int[n / 2][n / 2];
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                C4[i][j] = A4[i][j] - B4[i][j];
            }
        }
        int[][] C2 = new int[n / 2][n / 2];
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                C2[i][j] = 0;
                for (int k = 0; k < n / 2; k++) {
                    C2[i][j] = C2[i][j] + A2[i][k] * B2T[k][j];
                }
            }
        }
        int[][] C3 = new int[n / 2][n / 2];
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                C3[i][j] = 0;
                for (int k = 0; k < n / 2; k++) {
                    C3[i][j] = C3[i][j] + B3[i][k] * A3T[k][j];
                }
            }
        }
        //写出最终矩阵
        int[][] C = new int[n][n];
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                C[i][j] = C1[i][j];
            }
        }
        for (int i = 0; i < n / 2; i++) {
            for (int j = n / 2; j < n; j++) {
                C[i][j] = C2[i][j - n / 2];
            }
        }
        for (int i = n / 2; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                C[i][j] = C3[i - n / 2][j];
            }
        }
        for (int i = n / 2; i < n; i++) {
            for (int j = n / 2; j < n; j++) {
                C[i][j] = C4[i - n / 2][j - n / 2];
            }
        }
        //打出最终矩阵
        for(int i = 0; i<n-1;i++){
            for(int j = 0;j<n;j++){
                System.out.printf(C[i][j]+" ");
            }
            System.out.printf("\n");
        }
        for(int j = 0;j<n;j++){
            System.out.printf(C[n-1][j]+" ");
        }
    }
}
