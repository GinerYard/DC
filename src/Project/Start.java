package Project;

import java.util.ArrayList;
import java.util.Scanner;

class Start {
    public static int global = 0;
    //给玩家选择：新游戏、加载棋盘、退出游戏三个选项，若玩家选择新游戏或加载棋盘，给玩家选择：NM或CM两个选项
    public static void StartGame(int[][] board, int[][] state, int[][] pub, Var mode, ArrayList<int[][]> BL, ArrayList<int[][]> SL,int round,int c) {
        mode(mode);
        Initializer.Init(board, state, pub, BL, SL);
        round = 2;
        Menu.redraw(board, state);
        MainGame.maingame(board, state, pub, BL, SL, mode,round,c);
    }
    public static void StartGameAI(int[][] board, int[][] state, int[][] pub, Var mode, ArrayList<int[][]> BL, ArrayList<int[][]> SL,int round,int c,Var clock) {
        mode(mode);
        Initializer.Init(board, state, pub, BL, SL);
        round = 2;
        MainGameAI.maingameAI(board, state, pub, BL, SL, mode,round,c,clock);
    }
    public static void StartGameAIHard(int[][] board, int[][] state, int[][] pub, Var mode, ArrayList<int[][]> BL, ArrayList<int[][]> SL,int round,int c,Var clock) {
        mode(mode);
        Initializer.Init(board, state, pub, BL, SL);
        round = 2;
        MainGameAIHard.maingameAIHard(board, state, pub, BL, SL, mode,round,c,clock);
    }

    public static void LoadGame(int[][] board, int[][] state, int[][] pub, Var mode, ArrayList<int[][]> BL, ArrayList<int[][]> SL, int round, int c) {
        int k = 0;
        ArrayList<int[][]> L = SaveLoad.load(k);
        if(k==1){
            return;
        }
        for (int i = 0; i < L.size() / 2; i++) {
            BL.add(L.get(i));
        }
        for (int i = L.size() / 2; i < L.size(); i++) {
            SL.add(L.get(i));
        }
        int[][] S0 = SL.get(1);
        for (int l = 0; l < BL.size(); l++) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 4; j++) {
                    if (S0[i][j] == 1) {
                        c = BL.get(l)[i][j];
                    }
                }
            }
        }
        round = BL.size() + 1;
        board = BL.get(BL.size() - 1);
        state = SL.get(SL.size() - 1);
        mode(mode);
        Monitor_NM.nm(board, state, pub);
        MainGame.maingame(board, state, pub, BL, SL, mode,round,c);
    }

    public static void mode(Var mode) {
        System.out.println("输入0开始普通模式，输入1开始作弊模式");
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        mode.setMode(m);
        if (mode.getMode() == 0) {
            System.out.println("您选择了普通模式，您将不能查看翻面的棋子");
        }
        if (mode.getMode() == 1) {
            System.out.println("您选择了作弊模式，您可以在每次操作结束后查看翻面的棋子");
        }
        System.out.println("游戏即将开始......");
    }


}
