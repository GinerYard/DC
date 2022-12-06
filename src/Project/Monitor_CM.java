package Project;

import java.util.Scanner;

class Monitor_CM {
    //在作弊模式下，除了公示棋盘、分数、回合和先后手以外，玩家输入要查看的未翻面棋子时将公布棋子类型
    static void cm(int[][] board, int[][] state, int[][] pub) {
        Scanner input = new Scanner(System.in);
        int[] num = new int[14];//将士象车马卒炮
        for(int i = 0;i<7;i++){
            if(i==0){
                num[i]=1;num[i+7]=1;
            }
            if(i==5){
                num[i]=5;num[i+7]=5;
            }
            if(i!=0&&i!=5){
                num[i]=2;num[i+7]=2;
            }
        }
        int[] r = new int[14];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 4; j++) {
                for(int k = 1;k<=7;k++)
                    if (board[i][j] == k) {
                        r[k-1]++;
                    }
                for(int k = -1;k>=-7;k--){
                    if (board[i][j] == k) {
                        r[Math.abs(k)+6]++;
                    }
                }
            }
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 4; j++) {
                if (state[i][j] == 0) {
                    pub[i][j] = 0;
                }
                if (state[i][j] == 1) {
                    pub[i][j] = board[i][j];
                }
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.printf("%s  ", Convert.convert(pub[i][j]));
            }
            if(i==0){
                System.out.printf("       红色方被吃子：      黑色方被吃子：");
            }
            else{
                System.out.printf("       %s x %d            %s x %d",Convert.convert(i),num[i-1]-r[i-1],Convert.convert(-i),num[i+6]-r[i+6]);
            }
            System.out.printf("\n");
        }
        int flagcm = 1;
        while (flagcm != 0) {
            System.out.println("继续请输入0，查看任意多个棋子的类型请输入查看数量和坐标");
            int n = input.nextInt();
            if (n == 0) {
                flagcm = 0;
            } else {
                for (int i = 0; i < n; i++) {
                    int x = input.nextInt();
                    int y = input.nextInt();
                    if (state[x][y] == 1) {
                        System.out.println("这个位置的棋子已经被显示了！");
                    }
                    if (state[x][y] == 0) {
                        System.out.printf("坐标(%d,%d)的棋子为%s\n", x, y, Convert.convert(board[x][y]));
                    }
                }
            }
        }
    }
}
