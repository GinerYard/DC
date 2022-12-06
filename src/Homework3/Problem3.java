package Homework3;

import java.util.Scanner;

public class Problem3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        //标数
        int[][] dia = new int[203][203];
        for (int x = 0; x < 203; x++) {
            for (int y = 0; y < 203; y++) {
                dia[x][y] = 0;
            }
        }
        for (int i = 0; i < n; i++) {
            int k = input.nextInt();
            int x = input.nextInt();
            int y = input.nextInt();
            if (dia[x + 101][y + 101] != 3) {
                if (k == 1) {
                    dia[x + 101][y + 101] = 1;
                }
                if (k == 2) {
                    dia[x + 101][y + 101] = 3;
                }
            }
        }
        //缺少方法
        //面积
        int case1 = 0;
        int case2 = 0;
        int case3 = 0;
        for (int x = 0; x < 202; x++) {
            for (int y = 0; y < 202; y++) {
                if (dia[x + 1][y + 1] + dia[x][y + 1] + dia[x + 1][y] + dia[x][y] >= 3) {
                    case1 = case1 + 1;
                }
                if (dia[x + 1][y + 1] + dia[x][y + 1] + dia[x + 1][y] + dia[x][y] == 1) {
                    case2 = case2 + 1;
                }
                if (dia[x + 1][y + 1] + dia[x][y + 1] + dia[x + 1][y] + dia[x][y] == 2) {
                    if (dia[x + 1][y + 1] == dia[x][y]) {
                        case1 = case1 + 1;
                    } else {
                        case3 = case3 + 1;
                    }
                }
            }
        }
        double sum = case1 + case3 * (Math.sqrt(3) / 4 + Math.PI / 6) + case2 * Math.PI / 4;
        System.out.printf("%.5f", sum);


    }

}

