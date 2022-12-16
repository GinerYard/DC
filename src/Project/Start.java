package Project;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

class Start extends View {
    public static int k = 0;
    //给玩家选择：新游戏、加载棋盘、退出游戏三个选项，若玩家选择新游戏或加载棋盘，给玩家选择：NM或CM两个选项
    public static void StartGame(int[][] board, int[][] state, int[][] pub, Var mode, ArrayList<int[][]> BL, ArrayList<int[][]> SL,int round,int c) {
        mode(board,state,mode,BL,SL);
        Initializer.Init(board, state, BL, SL);
        round = 2;
    }
    public static void StartGameUI(int[][] board, int[][] state, Var mode, ArrayList<int[][]> BL, ArrayList<int[][]> SL) {
        DarkChess.n = 0;
        mode(board,state,mode,BL,SL);
    }
    public static void newGame(int[][] board, int[][] state, Var mode, ArrayList<int[][]> BL, ArrayList<int[][]> SL) {
        DarkChess.n = 0;
        mode(board,state,mode,BL,SL);

    }
    public static void StartGameAI(int[][] board, int[][] state,ArrayList<int[][]> BL, ArrayList<int[][]> SL) {
        Var mode = new Var();
        DarkChess.n = 10;
        Object[] options ={ "简单模式", "普通模式" };
        int m = JOptionPane.showOptionDialog(null, "请选择游戏模式", "开始游戏",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if (m == JOptionPane.OK_OPTION) {
            DarkChess.k = 0 ;
        }else{
            DarkChess.k = 1;
        }
        mode(board,state,mode,BL,SL);

    }


    public static void LoadGame(ArrayList<int[][]> BL, ArrayList<int[][]> SL) {
        DarkChess.n = 0;
        k = 0;
        ArrayList<int[][]> L = SaveLoad.load();

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
                        DarkChess.c = BL.get(l)[i][j];
                    }
                }
            }
        }
        DarkChess.round = BL.size() + 1;
        System.out.println(DarkChess.c);
        System.out.println(DarkChess.round);
        DarkChess.board = BL.get(BL.size() - 1);
        DarkChess.state = SL.get(SL.size() - 1);
        if (DarkChess.c > 0) {
            ImageIcon img1 = new ImageIcon("src\\Game\\redFblack.png");
            View.showChessLeft.setIcon(img1);
            ImageIcon img2 = new ImageIcon("src\\Game\\redFred.png");
            View.showChessRight.setIcon(img2);
        }
        if (DarkChess.c < 0) {
            ImageIcon img1 = new ImageIcon("src\\Game\\blackFred.png");
            View.showChessLeft.setIcon(img1);
            ImageIcon img2 = new ImageIcon("src\\Game\\blackFblack.png");
            View.showChessRight.setIcon(img2);
        }
        View.redScore.setText(String.valueOf(ScoreDetector.scoreRed(DarkChess.board)));
        View.blackScore.setText(String.valueOf(ScoreDetector.scoreBlack(DarkChess.board)));
        if (DarkChess.round % 2 == 0) {
            System.out.printf("第%d回合开始\n", DarkChess.round / 2);
            View.textArea.append("\n第"+ DarkChess.round/2+"回合开始");
            if(DarkChess.c>0){
                View.sideB.setIcon(View.sideRed);
                View.sideA.setIcon(View.sideNull);
            }
            if(DarkChess.c<0){
                View.sideB.setIcon(View.sideBlack);
                View.sideA.setIcon(View.sideNull);
            }
        }
        if(DarkChess.round % 2 == 1){
            if(DarkChess.c>0){
                View.sideA.setIcon(View.sideBlack);
                View.sideB.setIcon(View.sideNull);
            }
            if(DarkChess.c<0){
                View.sideA.setIcon(View.sideRed);
                View.sideB.setIcon(View.sideNull);
            }
        }

        Var mode = new Var();
        Var.d = 1;
        View.MainMenu.setVisible(false);
        View.all.setVisible(true);
        View.b.setVisible(true);
        View.r.setVisible(true);
        View.rs.setVisible(true);
        View.c.setVisible(true);
        View.endGame.setVisible(false);
        View.redraw(DarkChess.board, DarkChess.state);
        Monitor_NM.nm(DarkChess.board, DarkChess.state);
        ShowBoardList.showList(BL,SL);

    }

    public static void mode(int[][] board, int[][] state, Var mode, ArrayList<int[][]> BL, ArrayList<int[][]> SL) {
        if (DarkChess.n != 10) {
            Object[] options = {"新游戏", "加载棋盘"};
            int m = JOptionPane.showOptionDialog(null, "请选择游戏模式", "开始游戏", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (m == JOptionPane.OK_OPTION) {
                mode.setMode(m);
                Initializer.Init(board, state, BL, SL);
                DarkChess.c = 0;
                DarkChess.round = 2;
                Var.d = 1;
                View.MainMenu.setVisible(false);
                View.all.setVisible(true);
                View.b.setVisible(true);
                View.r.setVisible(true);
                View.rs.setVisible(true);
                View.c.setVisible(true);
                View.endGame.setVisible(false);
                View.textArea.setText("第1回合开始");
                View.redraw(board, state);
            } else {
                mode.setMode(1);
                LoadGame(BL, SL);
            }
            if (mode.getMode() == 0) {
                System.out.println("");
            }
            if (mode.getMode() == 1) {
                System.out.println("");
            }
            System.out.println("游戏即将开始......");
        }
        if (DarkChess.n == 10) {
                mode.setMode(0);
                Initializer.Init(board, state, BL, SL);
                DarkChess.c = 0;
                DarkChess.round = 2;
                Var.d = 1;
                View.MainMenu.setVisible(false);
                View.all.setVisible(true);
                View.b.setVisible(true);
                View.r.setVisible(true);
                View.rs.setVisible(true);
                View.c.setVisible(true);
                View.endGame.setVisible(false);
                View.textArea.setText("第1回合开始");
                View.redraw(board, state);

        }
    }


}
