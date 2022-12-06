package Homework3;

import java.util.Scanner;

public class Problem4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int n = input.nextInt();
        int[][] M = new int[m][n];
        int i = 0;
        int j = 0;
        int hang = m - 1;
        int lie = n - 1;
        int heng = 0;
        int zong = 0;
        M[0][0] = input.nextInt();
        int k = 1;
        while (k < m * n) {
            while (i != hang && k < m * n) {
                i++;
                M[i][j] = input.nextInt();
                if (k != m * n) {
                    k++;
                }
            }
            while (j != lie && k < m * n) {
                j++;
                M[i][j] = input.nextInt();
                if (k != m * n) {
                    k++;
                }
            }
            while (i != heng && k < m * n) {
                i--;
                M[i][j] = input.nextInt();
                if (k != m * n) {
                    k++;
                }
            }
            while (j != zong + 1 && k < m * n) {
                j--;
                M[i][j] = input.nextInt();
                if (k != m * n) {
                    k++;
                }
            }
            hang--;
            lie--;
            heng++;
            zong++;
        }
        for (int a = 0; a < m - 1; a++) {
            for (int b = 0; b < n; b++) {
                System.out.printf("%d ", M[a][b]);
            }
            System.out.printf("\n");
        }
        for (int b = 0; b < n; b++) {
            System.out.printf("%d ", M[m - 1][b]);
        }


    }

}
