package Project;


import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import java.util.Scanner;
import java.util.concurrent.Future;

public class View {
    public static int player;
    public static AudioPlayer bgm;
    public static AudioPlayer game;

    public static JFrame frame = new JFrame("翻翻棋");
    public static JPanel p = new JPanel(new GridLayout(8, 4));
    public static JPanel button = new JPanel();

    public static JButton endGame = new JButton("退出游戏");
    public static JButton b = new JButton("结束游戏");
    public static JButton r = new JButton("悔棋");
    public static JButton rs = new JButton("重新开始");
    public static JButton c = new JButton("作弊模式");
    public static JButton ol = new JButton("开启服务器");



    public static JPanel all = new JPanel();
    public static JLabel showChessLeft = new JLabel();
    public static JLabel showChessRight = new JLabel();
    public static JPanel[][] grids = new JPanel[8][4];
    public static JLabel[][] labels = new JLabel[8][4];
    public static int cheat;
    public static JTextArea textArea = new JTextArea();
    /*----------------------------------
    MainMenu:
     */
    public static JPanel MainMenu = new JPanel();
    public static JButton startGame = new JButton();
    public static JButton loadGame = new JButton();
    public static JButton onlineGame = new JButton();

    public static JTextArea rank = new JTextArea();
    public static JButton login = new JButton();
    public static JButton connect = new JButton();
    public static JButton exit = new JButton();
    public static JButton startGameAI = new JButton();
    public static JTextArea welcome = new JTextArea();
    //-----------------------------------------------

    public static JLabel sideA = new JLabel();
    public static JLabel sideB = new JLabel();

    public static JLabel l1 = new JLabel();
    public static JLabel l2 = new JLabel();
    public static JLabel l3 = new JLabel();
    public static JLabel l4 = new JLabel();
    public static JLabel l5 = new JLabel();
    public static JLabel l6 = new JLabel();
    public static JLabel l7 = new JLabel();
    public static JLabel r1 = new JLabel();
    public static JLabel r2 = new JLabel();
    public static JLabel r3 = new JLabel();
    public static JLabel r4 = new JLabel();
    public static JLabel r5 = new JLabel();
    public static JLabel r6 = new JLabel();
    public static JLabel r7 = new JLabel();

    public static JLabel redScore = new JLabel();

    public static JLabel blackScore = new JLabel();

    public static ImageIcon sideRed = new ImageIcon("D:\\Project\\Game\\SideR.png");
    public static ImageIcon sideBlack = new ImageIcon("D:\\Project\\Game\\SideB.png");
    public static ImageIcon sideNull = new ImageIcon("D:\\Project\\Game\\SideN.png");

    public static ImageIcon img0 = new ImageIcon("D:\\Project\\Game\\null.png");


    public static JPanel wel = new JPanel();

    public static JButton enter = new JButton();


    public static void welcome() {
        try {
            SwingUtilities.invokeAndWait(() -> {

                JFrame.setDefaultLookAndFeelDecorated(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
                frame.setBounds(320, 180, 1037, 583);
                Toolkit tk = Toolkit.getDefaultToolkit();
                //获取图片 三种图片格式都可以
                java.awt.Image img = tk.getImage("D:\\Project\\View\\image.png");
                // 给窗体设置图标
                frame.setIconImage(img);

                wel = new JPanel() {
                    @Override
                    protected void paintComponent(Graphics g) {
                        super.paintComponent(g);
                        ImageIcon img = new ImageIcon("D:\\Project\\View\\Start.png");
                        img.paintIcon(this, g, -5, 0);
                    }
                };
                wel.setLayout(null);
                wel.setBounds(0, 0, 1037, 583);
                enter.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        wel.setVisible(false);
                        bgm.stop();
                        MainMenu.setVisible(true);
                    }
                });
                enter.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        wel.setVisible(false);
                        MainMenu.setVisible(true);
                    }
                });
                enter.setContentAreaFilled(false);
                enter.setBounds(0, 0, 1037, 583);
                wel.add(enter);
                frame.add(wel);
                bgm = AudioPlayer.playBgm("D:\\Project\\Audio\\majSoul.wav");


            });
        } catch (InterruptedException |
                 InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }


    public static void createMainMenu(int[][] board, int[][] state, Var mode, ArrayList<int[][]> BL, ArrayList<int[][]> SL) throws InterruptedException, InvocationTargetException {
        try {
            SwingUtilities.invokeAndWait(() -> {
                JFrame.setDefaultLookAndFeelDecorated(true);
                MainMenu = new JPanel() {
                    @Override
                    protected void paintComponent(Graphics g) {
                        super.paintComponent(g);
                        ImageIcon img = new ImageIcon("D:\\Project\\View\\Platform.png");
                        img.paintIcon(this, g, -3, -3);
                    }
                };


                MainMenu.setLayout(null);
                MainMenu.setBounds(0, 0, 1037, 583);

                startGame.addActionListener(e -> {
                    Start.StartGameUI(board, state, mode, BL, SL);
                });
                startGame.setContentAreaFilled(false);
                startGame.setBounds(608, 73, 245, 59);
                loadGame.addActionListener(e -> {
                    Start.LoadGame(BL, SL);
                });
                loadGame.setContentAreaFilled(false);

                onlineGame.addActionListener(e -> {
                    View.MainMenu.setVisible(false);
                    View.all.setVisible(true);
                    View.b.setVisible(true);
                    View.r.setVisible(true);
                    View.rs.setVisible(true);
                    View.c.setVisible(true);
                    View.endGame.setVisible(false);
                    View.textArea.setText(null);
                    ol.setVisible(true);
                    View.showChessLeft.setIcon(View.img0);
                    View.showChessRight.setIcon(View.img0);
                    sideA.setIcon(sideNull);
                    sideB.setIcon(sideNull);
                    int[][] a = new int[8][4];
                    int[][] b = new int[8][4];
                    redraw(a,b);
                    View.redScore.setText("0");
                    View.blackScore.setText("0");
                });
                onlineGame.setContentAreaFilled(false);
                onlineGame.setBounds(608, 163, 245, 59);

                connect.addActionListener(e -> {
                    try {
                        Client.startClient();
                    } catch (IOException | InterruptedException | InvocationTargetException ex) {
                        throw new RuntimeException(ex);
                    }
                });
                connect.setContentAreaFilled(false);
                connect.setBounds(870, 163, 59, 59);

                startGameAI.addActionListener(e -> {
                    Start.StartGameAI(board, state, BL, SL);
                });
                startGameAI.setContentAreaFilled(false);
                startGameAI.setBounds(608, 253, 245, 59);
                login.addActionListener(e -> {
                    User.showUser();
                });
                login.setContentAreaFilled(false);
                login.setBounds(608, 343, 245, 59);
                exit.addActionListener(e -> {
                    System.exit(0);
                });
                exit.setContentAreaFilled(false);
                exit.setBounds(877, 343, 59, 59);

                rank.setBounds(110, 200, 350, 250);
                rank.setBackground(new Color(52, 51, 52));

                rank.setLineWrap(true);
                rank.setFont(new Font("Times New Roman", Font.BOLD, 20));
                rank.setForeground(Color.WHITE);
                MainMenu.add(rank);
                User.showRank();

                welcome.setBounds(80, 450, 600, 100);
                welcome.setBackground(new Color(52, 51, 52));
                welcome.setFont(new Font("微软雅黑", Font.BOLD, 20));
                welcome.setForeground(Color.WHITE);
                welcome.setText("欢迎回来！");
                MainMenu.add(welcome);
                MainMenu.add(startGame);
                MainMenu.add(startGameAI);
                MainMenu.add(onlineGame);
                MainMenu.add(connect);
                MainMenu.add(login);
                MainMenu.add(exit);


                frame.add(MainMenu);
            });
        } catch (InterruptedException |
                 InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }


    public static void createView(int[][] board, int[][] state, ArrayList<int[][]> BL, ArrayList<int[][]> SL) {
        Var.x0 = -1;
        Var.y0 = -1;
        cheat = -1;

        try {
            SwingUtilities.invokeAndWait(() -> {
                JFrame.setDefaultLookAndFeelDecorated(true);
                all = new JPanel() {
                    @Override
                    protected void paintComponent(Graphics g) {
                        super.paintComponent(g);
                        ImageIcon img = new ImageIcon("D:\\Project\\Game\\Game.png");
                        img.paintIcon(this, g, -3, -3);
                    }
                };



                // 创建及设置窗口


                //创建一个文本框

                // 自动换行
                textArea.setLineWrap(true);

                // 设置字体
                textArea.setFont(new Font("微软雅黑", Font.BOLD, 18));
                JScrollPane jScrollPane = new JScrollPane(
                        textArea,
                        ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                        ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
                );
                jScrollPane.setBounds(722, 53, 237, 375);


                all.add(jScrollPane);

                // 显示窗口
                redScore.setBounds(633, 66, 30, 30);
                redScore.setOpaque(true);
                redScore.setBackground(new Color(255, 255, 229));
                all.add(redScore);
                blackScore.setBounds(633, 121, 30, 30);
                blackScore.setOpaque(true);
                blackScore.setBackground(new Color(255, 255, 229));
                all.add(blackScore);
                showChessLeft.setBounds(85, 52, 55, 375);
                showChessRight.setBounds(447, 160, 55, 375);

                showChessLeft.setIcon(img0);
                showChessRight.setIcon(img0);
                p.setBounds(187, 55, 240, 475);
                sideA.setBounds(36, 57, 27, 27);
                sideB.setBounds(563, 505, 27, 27);
                sideA.setIcon(sideNull);
                sideB.setIcon(sideNull);
                l1.setBackground(new Color(255, 255, 229));
                l1.setOpaque(true);
                l1.setBounds(145, 65, 30, 30);
                l2.setBackground(new Color(255, 255, 229));
                l2.setOpaque(true);
                l2.setBounds(145, 120, 30, 30);
                all.add(l2);
                l3.setBackground(new Color(255, 255, 229));
                l3.setOpaque(true);
                l3.setBounds(145, 175, 30, 30);
                all.add(l3);
                l4.setBackground(new Color(255, 255, 229));
                l4.setOpaque(true);
                l4.setBounds(145, 227, 30, 30);
                all.add(l4);
                l5.setBackground(new Color(255, 255, 229));
                l5.setOpaque(true);
                l5.setBounds(145, 280, 30, 30);
                all.add(l5);
                l6.setBackground(new Color(255, 255, 229));
                l6.setOpaque(true);
                l6.setBounds(145, 335, 30, 30);
                all.add(l6);
                l7.setBackground(new Color(255, 255, 229));
                l7.setOpaque(true);
                l7.setBounds(145, 390, 30, 30);
                all.add(l7);

                r1.setBackground(new Color(255, 255, 229));
                r1.setOpaque(true);
                r1.setBounds(507, 173, 30, 30);
                all.add(r1);
                r2.setBackground(new Color(255, 255, 229));
                r2.setOpaque(true);
                r2.setBounds(507, 228, 30, 30);
                all.add(r2);
                r3.setBackground(new Color(255, 255, 229));
                r3.setOpaque(true);
                r3.setBounds(507, 283, 30, 30);
                all.add(r3);
                r4.setBackground(new Color(255, 255, 229));
                r4.setOpaque(true);
                r4.setBounds(507, 338, 30, 30);
                all.add(r4);
                r5.setBackground(new Color(255, 255, 229));
                r5.setOpaque(true);
                r5.setBounds(507, 390, 30, 30);
                all.add(r5);
                r6.setBackground(new Color(255, 255, 229));
                r6.setOpaque(true);
                r6.setBounds(507, 443, 30, 30);
                all.add(r6);
                r7.setBackground(new Color(255, 255, 229));
                r7.setOpaque(true);
                r7.setBounds(507, 498, 30, 30);
                all.add(r7);
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 4; j++) {
                        JPanel t = new JPanel();
                        Color c = new Color(255, 255, 255);
                        t.setBackground(Color.WHITE);
                        t.setOpaque(false);
                        int finalI = i;
                        int finalJ = j;
                        t.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {

                                if (DarkChess.n == 11) {
                                    if (player == 2) {
                                        try {
                                            MainGameClient.methodClient(finalI, finalJ, DarkChess.board, DarkChess.state, BL, SL);
                                        } catch (IOException ex) {
                                            throw new RuntimeException(ex);
                                        }
                                    }
                                    if (player == 1) {
                                        try {
                                            MainGameClient.methodServer(finalI, finalJ, DarkChess.board, DarkChess.state, BL, SL);
                                        } catch (IOException ex) {
                                            throw new RuntimeException(ex);
                                        }
                                    }
                                }
                                if (e.isMetaDown()) {
                                    if (cheat == 1) {
                                        textArea.append("\n" + "位置(" + finalI + "," + finalJ + ")的棋子是" + (Convert.convertGUI(DarkChess.board[finalI][finalJ])));
                                    }
                                }
                                if (DarkChess.n == 0 && !e.isMetaDown()) {
                                    MainGameUI.method(finalI, finalJ, DarkChess.board, DarkChess.state, BL, SL);
                                }
                                if (DarkChess.n == 10 && !e.isMetaDown()) {
                                    MainGameAI.method(finalI, finalJ, DarkChess.board, DarkChess.state, BL, SL);
                                    MainGameAI.method(-1, -1, DarkChess.board, DarkChess.state, BL, SL);
                                }
                                if (Var.d == 2 || Var.d == 3) {
                                    t.setOpaque(true);
                                    t.setBackground(Color.GRAY);
                                }
                            }

                            @Override
                            public void mouseEntered(MouseEvent e) {
                                t.setOpaque(true);
                                Color c = new Color(139, 162, 255);
                                t.setBackground(c);
                            }

                            @Override
                            public void mouseExited(MouseEvent e) {
                                Color c = new Color(255, 255, 255);
                                t.setBackground(c);
                                t.setOpaque(false);
                                if (Var.x0 != -1 && Var.y0 != -1) {
                                    grids[Var.x0][Var.y0].setOpaque(true);
                                    grids[Var.x0][Var.y0].setBackground(Color.GRAY);
                                    if (Var.d == 2) {
                                        for (int i = 0; i < 8; i++) {
                                            for (int j = 0; j < 4; j++) {
                                                if (MoveJudge.mj(Var.x0, Var.y0, i, j, DarkChess.board, DarkChess.state)) {
                                                    grids[i][j].setOpaque(true);
                                                    grids[i][j].setBackground(Color.YELLOW);
                                                }
                                            }
                                        }
                                    }
                                    if (Var.d == 3) {
                                        for (int i = 0; i < 8; i++) {
                                            for (int j = 0; j < 4; j++) {
                                                if (CannonJudge.cj(Var.x0, Var.y0, i, j, DarkChess.board, DarkChess.state)) {
                                                    grids[i][j].setOpaque(true);
                                                    grids[i][j].setBackground(Color.YELLOW);
                                                }
                                            }
                                        }
                                    }
                                }
                            }

                        });
                        p.add(t);

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

                p.setBackground(Color.WHITE);
                p.setOpaque(false);

                b.addActionListener(e -> {
                    exit(BL, SL);
                });
                b.setBounds(580, 180, 100, 35);
                b.setBackground(new Color(255, 255, 255));
                all.add(b);
                endGame.addActionListener(e -> {
                    if(game!=null){
                    game.stop();}
                    if(Server.t!=null){
                        Server.t.interrupt();
                    }
//                    AI.progressBar.setVisible(false);
                    all.setVisible(false);
                    MainMenu.setVisible(true);
                });
                endGame.setVisible(false);
                endGame.setBounds(257, 280, 100, 35);
                endGame.setBackground(new Color(255, 255, 255));
                all.add(endGame);

                r.addActionListener(e -> {
                    regret(BL, SL, DarkChess.board, DarkChess.state);
                });
                r.setBounds(580, 230, 100, 35);
                r.setBackground(new Color(255, 255, 255));
                all.add(r);


                rs.addActionListener(e -> {
                    restart(BL, SL, DarkChess.board, DarkChess.state);
                });
                rs.setBounds(580, 280, 100, 35);
                rs.setBackground(new Color(255, 255, 255));
                all.add(rs);
//                AI.progressBar.setBounds(450,60,100,20);
//                all.add(AI.progressBar);
//                AI.progressBar.setVisible(false);


                c.addActionListener(e -> {
                    if (cheat == -1) {
                        c.setText("普通模式");
                    }
                    if (cheat == 1) {
                        c.setText("作弊模式");
                    }
                    cheat = -cheat;
                });
                c.setBounds(580, 330, 100, 35);
                c.setBackground(new Color(255, 255, 255));

                ol.addActionListener(e -> {
                    try {
                        Server.startServer(board, state, BL, SL);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });
                ol.setBounds(580, 380, 100, 35);
                ol.setBackground(new Color(255, 255, 255));
                ol.setVisible(false);
                all.add(c);
                all.add(ol);
                all.setLayout(null);
                all.add(showChessLeft);
                all.add(showChessRight);
                all.add(sideA);
                all.add(sideB);
                all.add(l1);
                all.add(p);


                all.setBounds(320, 180, 1037, 583);
                all.setVisible(false);

                frame.add(all);

            });
        } catch (InterruptedException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public static void redraw(int[][] board, int[][] state) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 4; j++) {
                labels[i][j].setIcon(SetImg.setImg(i, j, board, state));
            }
        }
        View.redScore.setText(String.valueOf(ScoreDetector.scoreRed(board)));
        View.blackScore.setText(String.valueOf(ScoreDetector.scoreBlack(board)));
    }

    public static void setBack(int x, int y) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 4; j++) {
                grids[i][j].setBackground(Color.WHITE);
                grids[i][j].setOpaque(false);
            }
        }
    }


    public static void regret(ArrayList<int[][]> BL, ArrayList<int[][]> SL, int[][] board, int[][] state) {
        if (DarkChess.round == 2 || DarkChess.round == 3) {
            System.out.println("你现在不能悔棋！");
            return;
        }
        BL.remove(DarkChess.round - 2);
        SL.remove(DarkChess.round - 2);
        BL.remove(DarkChess.round - 3);
        SL.remove(DarkChess.round - 3);
        if (DarkChess.round == 4) {
            DarkChess.c = 0;
        }
        DarkChess.round = DarkChess.round - 2;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 4; j++) {
                board[i][j] = BL.get(DarkChess.round - 2)[i][j];
                state[i][j] = SL.get(DarkChess.round - 2)[i][j];
            }
        }
        Monitor_NM.nm(board, state);
        redraw(board, state);
    }

    public static void restart(ArrayList<int[][]> BL, ArrayList<int[][]> SL, int[][] board, int[][] state) {
        int userOption = JOptionPane.showConfirmDialog(null, "是否重新开始？", "重新开始", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (userOption == JOptionPane.OK_OPTION) {
            Var mode = new Var();
            Start.mode(board, state, mode, BL, SL);

        }
    }

    public static void exit(ArrayList<int[][]> BL, ArrayList<int[][]> SL) {
        int userOption = JOptionPane.showConfirmDialog(null, "游戏结束，是否保存进度？", "结束游戏", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE);  //确认对话框
//如果用户选择的是OK
        if (userOption == JOptionPane.OK_OPTION) {
            SaveLoad.save(BL, SL);
        }
        int userOption2 = JOptionPane.showConfirmDialog(null, "是否查看棋谱？", "结束游戏", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (userOption2 == JOptionPane.OK_OPTION) {
            ShowBoardList.showList(BL, SL);
        }
        Var.d = 0;
        View.b.setVisible(false);
        View.r.setVisible(false);
        View.rs.setVisible(false);
        View.c.setVisible(false);

        endGame.setVisible(true);
    }

    public static void draw(ArrayList<int[][]> BL, ArrayList<int[][]> SL, Var flagdo) {
        Scanner input = new Scanner(System.in);
        int x = 0;
        int d = 0;
        int e = 0;
        if (x == 101 && d != -1) {
            System.out.println("确定要和棋吗？对方玩家输入0以和棋，输入-1以拒绝和棋：");
            d = input.nextInt();
            if (d == 0) {
                System.out.println("游戏结束，双方平局！输入0直接退出，输入1查看棋谱：");
                e = input.nextInt();
                if (e == 0) {
                    return;
                }
                if (e == 1) {
                    ShowBoardList.showList(BL, SL);
                    return;
                }
            }
            if (d == -1) {
                System.out.println("对方玩家拒绝了和棋！");
                flagdo.setFlagdo(1);

            }
        }
        if (x == 101 && d == -1) {
            System.out.println("对方拒绝和棋后，本回合内不能求和！");
            flagdo.setFlagdo(1);

        }
    }


}
