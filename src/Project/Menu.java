package Project;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Menu {

    public static JFrame frame = new JFrame("HelloWorldSwing");
    public static JPanel p = new JPanel(new GridLayout(8, 4));
    public static JPanel pp = new JPanel();
    public static JPanel all = new JPanel(new BorderLayout());
    public static JPanel[][] grids = new JPanel[8][4];
    public static JLabel[][] labels = new JLabel[8][4];

    public static void redraw(int[][] board, int[][] state) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 4; j++) {
                if(state[i][j] == 0) {
                    labels[i][j].setText("0");
                } else {
                    labels[i][j].setText(String.valueOf(board[i][j]));
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {

//        JFrame frame = new JFrame();
//        new Thread(() -> {
//            Scanner s = new Scanner(System.in);
//            s.nextLine();
////            MainGameAI.method();
//        }).start();
        SwingUtilities.invokeLater(() -> {
            JFrame.setDefaultLookAndFeelDecorated(true);

            // 创建及设置窗口
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // 显示窗口
            frame.pack();
            frame.setVisible(true);
            p.setSize(640, 480);
            frame.setSize(640, 480);
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 4; j++) {
                    JPanel t = new JPanel();
                    int finalI = i;
                    int finalJ = j;
                    t.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            super.mouseClicked(e);
                            View.method(finalI, finalJ);
                        }
                    });
                    p.add(t);
                    t.setBorder(new LineBorder(Color.black));
                    t.setVisible(true);
                    p.setVisible(true);
                    grids[i][j] = t;

                    JLabel l = new JLabel();
                    labels[i][j] = l;
                    t.add(l);
                }
            }
//            button.addActionListener((e) -> {
//                System.out.println("clicked");
//            });
            JButton b = new JButton("AAA");
            pp.add(b);
            b.addActionListener(e -> {
                System.out.println("AAAA");
            });
            all.add(p, "North");
            all.add(pp, "South");
            frame.add(all);
        });
//        frame.
        //-----------------------------------------------------------
        int round = 0;
        int c = 0;
        Scanner input = new Scanner(System.in);
        int[][] board = new int[8][4];
        int[][] state = new int[8][4];
        int[][] pub = new int[8][4];
        ArrayList<int[][]> BL = new ArrayList<>();
        ArrayList<int[][]> SL = new ArrayList<>();
        Var mode = new Var();
        Var clock = new Var();
        clock.setClock(-1);
        mode.setMode(0);
        int n = 100;
        if (n == 100) {
            System.out.println("欢迎游玩纯纯摆烂人摸鱼制作的小成本翻棋！");
        }
        do {
            System.out.println("0 开始游戏");
            System.out.println("1 加载棋盘");
            System.out.println("2 用户信息");
            System.out.println("3 排行榜");
            System.out.println("-1 退出游戏");
            System.out.println("10 人机对战");
            n = input.nextInt();
            if (n == 0) {
                Start.StartGame(board, state, pub, mode, BL, SL, round, c);
            }
            if (n == 1) {
                Start.LoadGame(board, state, pub, mode, BL, SL, round, c);
            }
            if (n == 10) {
                System.out.println("0 简单模式");
                System.out.println("1 困难模式");
                int k = input.nextInt();
                if (k == 0) {
                    Start.StartGameAI(board, state, pub, mode, BL, SL, round, c, clock);
                }
                if (k == 1) {
                    Start.StartGameAIHard(board, state, pub, mode, BL, SL, round, c, clock);
                }
            }
            if (n == 2) {
                User.showUser(clock);
            }
            if (n == -1) {
                System.exit(0);
            }
        } while (n != -1);
    }
}
