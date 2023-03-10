package Project;

import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Scanner;

public class DarkChess {

    public static int round;
    public static int c;
    public static int n;
    public static int k;
    public static int[][] board = new int[8][4];
    public static int[][] state = new int[8][4];





    public static void main(String[] args) throws IOException, InterruptedException, InvocationTargetException {



//        JFrame frame = new JFrame();
//        new Thread(() -> {
//            Scanner s = new Scanner(System.in);
//            s.nextLine();
////            MainGameAI.method();
//        }).start();

//        frame.
        //-----------------------------------------------------------
        round = 0;
        c = 0;
        Scanner input = new Scanner(System.in);

        int[][] pub = new int[8][4];
        ArrayList<int[][]> BL = new ArrayList<>();
        ArrayList<int[][]> SL = new ArrayList<>();
        Var mode = new Var();
        Var.clock=-1;
        mode.setMode(0);
        View.welcome();
        View.createMainMenu(board,state,mode,BL,SL);
        View.createView(board,state,BL,SL);
        System.out.println("欢迎游玩纯纯摆烂人摸鱼制作的小成本翻棋！");
        do {
            //createView
            //JButton:{
            //mouseclicked:{
            //n = 0 ;
            //start();
            System.out.println("请选择模式");
            System.out.println("0 开始游戏");
            System.out.println("1 加载棋盘");
            System.out.println("2 用户信息");
            System.out.println("3 排行榜");
            System.out.println("-1 退出游戏");
            System.out.println("10 人机对战");
            System.out.println("11 联网模式");
            n = input.nextInt();
            if (n == 0) {
                Start.StartGameUI(board, state, mode, BL, SL);
            }
            if (n == 1) {
                Start.LoadGame(BL, SL);
            }
            if (n == 10) {
                System.out.println("0 简单模式");
                System.out.println("1 困难模式");
                k = input.nextInt();
                Start.StartGameAI(board, state, BL, SL);
            }
            if (n == 2) {
                User.showUser();
            }
            if (n == -1) {
                System.exit(0);
            }
            if (n == 11) {
                Server.startServer(board, state, BL, SL);
            }
            if(n==12){

            }
        } while (true);
    }
}
