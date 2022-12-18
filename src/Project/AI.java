package Project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AI {
    private static final int MIN_PROGRESS = 0;
    private static final int MAX_PROGRESS = 100;

    private static int currentProgress = MIN_PROGRESS;

//    static final JProgressBar progressBar = new JProgressBar();
//    public static void progress() {
//        JPanel panel = new JPanel();
//
//        // 创建一个进度条
//
//
//        // 设置进度的 最小值 和 最大值
//        progressBar.setMinimum(MIN_PROGRESS);
//        progressBar.setMaximum(MAX_PROGRESS);
//
//        // 设置当前进度值
//        progressBar.setValue(currentProgress);
//
//
//
//        // 添加到内容面板
//        panel.add(progressBar);
//
//
//        // 模拟延时操作进度, 每隔 0.5 秒更新进度
//        TimerTask task = new TimerTask() {
//            @Override
//            public void run() {
//                currentProgress++;
//                if (currentProgress > MAX_PROGRESS) {
//                    currentProgress = MIN_PROGRESS;
//                }
//                progressBar.setValue(currentProgress);
//            }
//        };
//        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
//        service.scheduleAtFixedRate(task,0,1000, TimeUnit.MILLISECONDS);
//    }


    public static void randomChoose(int[][] board, int[][] state, ArrayList<int[][]> BL,ArrayList<int[][]> SL) {


        new Thread(() -> {
            try {
                Thread.sleep(1000);

                int[] v = {0, 1, 2, 3, 4, 5, 6, 7};
                int[] h = {0, 1, 2, 3};
                Random r1 = new Random();
                for (int i = 0; i < 8; i++) {
                    int index = r1.nextInt(8);
                    int temp = v[index];
                    v[index] = v[i];
                    v[i] = temp;
                }
                Random r2 = new Random();
                for (int i = 0; i < 4; i++) {
                    int index = r2.nextInt(4);
                    int temp = h[index];
                    h[index] = h[i];
                    h[i] = temp;
                }
                int x = -1;
                int y = -1;
                define:
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 4; j++) {
                        if (randomChooseJudge(v[i], h[j], board, state)) {
                            x = v[i];
                            y = h[j];
                            break define;
                        }
                    }
                }
                if (state[x][y] != 0 && board[x][y] != 7) {
                    randomChooseMove(x, y, board, state);
                }
                if (state[x][y] != 0 && board[x][y] == 7) {
                    randomChooseCannon(x, y, board, state);
                }
                if (state[x][y] == 0) {
                    randomChooseTurn(x, y, board, state);
                }
                if (DarkChess.round % 2 == 0) {

                    if (DarkChess.c > 0) {
                        View.sideB.setIcon(View.sideRed);
                        View.sideA.setIcon(View.sideNull);
                    }
                    if (DarkChess.c < 0) {
                        View.sideB.setIcon(View.sideBlack);
                        View.sideA.setIcon(View.sideNull);
                    }
                }
                if (DarkChess.round % 2 == 1) {
                    if (DarkChess.c > 0) {
                        View.sideA.setIcon(View.sideBlack);
                        View.sideB.setIcon(View.sideNull);
                    }
                    if (DarkChess.c < 0) {
                        View.sideA.setIcon(View.sideRed);
                        View.sideB.setIcon(View.sideNull);
                    }
                }
                AudioPlayer.playSound("D:\\Project\\Audio\\click.wav");
                View.redraw(board, state);
                System.out.println("AI已经完成操作");
                View.textArea.append("\nAI已经完成操作");
                BoardList.setBoardlist(board, state, BL, SL);

                if (ScoreDetector.scoreRed(board) >= 60) {
                    Var.d = 0;
                    if (DarkChess.round % 2 == 1 && Var.clock != -1) {
                        User.plusWinningRate();
                    }
                    if (DarkChess.round % 2 == 0 && Var.clock != -1) {
                        User.minusWinningRate();
                    }
                    int userOption2 = JOptionPane.showConfirmDialog(null, "游戏结束，红色方胜利！是否查看棋谱？", "结束游戏", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (userOption2 == JOptionPane.OK_OPTION) {
                        ShowBoardList.showList(BL, SL);
                    }
                    User.showRank();
                    DarkChess.round = 2;
                    View.b.setVisible(false);
                    View.r.setVisible(false);
                    View.rs.setVisible(false);
                    View.c.setVisible(false);

                    View.endGame.setVisible(true);
                }
                if (ScoreDetector.scoreBlack(board) >= 60) {
                    Var.d = 0;
                    if (DarkChess.round % 2 == 1 && Var.clock != -1) {
                        User.plusWinningRate();
                    }
                    if (DarkChess.round % 2 == 0 && Var.clock != -1) {
                        User.minusWinningRate();
                    }
                    int userOption2 = JOptionPane.showConfirmDialog(null, "游戏结束，黑色方胜利！是否查看棋谱？", "结束游戏", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (userOption2 == JOptionPane.OK_OPTION) {
                        ShowBoardList.showList(BL, SL);
                    }
                    User.showRank();
                    DarkChess.round = 2;
                    View.b.setVisible(false);
                    View.r.setVisible(false);
                    View.rs.setVisible(false);
                    View.c.setVisible(false);
//            AI.progressBar.setVisible(false);
                    View.endGame.setVisible(true);
                }
                System.out.printf("第%d回合开始\n", DarkChess.round / 2);
                View.textArea.append("\n第" + DarkChess.round / 2 + "回合开始");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

    }


    public static boolean randomChooseJudge(int x, int y, int[][] board, int[][] state) {
        boolean r = false;
        int n = 0;
        if (state[x][y] == 0) {
            n = 1;
        }
        if (Math.abs(board[x][y]) != 7) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 4; j++) {
                    if (MoveJudge.mj(x, y, i, j, board, state)) {
                        n = 1;
                    }
                }
            }
        }
        if (Math.abs(board[x][y]) == 7) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 4; j++) {
                    if (CannonJudge.cj(x, y, i, j, board, state)) {
                        n = 1;
                    }
                }
            }
        }
        if ((state[x][y] == 1 && board[x][y] * DarkChess.c > 0) || (state[x][y] == 1 && board[x][y] == 100)) {
            n = 0;
        }
        if (n == 1) {
            r = true;
        }
        return r;
    }


    public static void randomChooseTurn(int x, int y, int[][] board, int[][] state) {
        state[x][y] = 1;
    }

    public static void randomChooseMove(int x, int y, int[][] board, int[][] state) {
        int[] v = {0, 1, 2, 3, 4, 5, 6, 7};
        int[] h = {0, 1, 2, 3};
        Random r1 = new Random();
        for (int i = 0; i < 8; i++) {
            int index = r1.nextInt(8);
            int temp = v[index];
            v[index] = v[i];
            v[i] = temp;
        }
        Random r2 = new Random();
        for (int i = 0; i < 4; i++) {
            int index = r2.nextInt(4);
            int temp = h[index];
            h[index] = h[i];
            h[i] = temp;
        }
        define:
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 4; j++) {
                if ((MoveJudge.mj(x, y, v[i], h[j], board, state))) {
                    board[v[i]][h[j]] = board[x][y];
                    board[x][y] = 100;
                    break define;
                }
            }
        }
    }

    public static void randomChooseCannon(int x, int y, int[][] board, int[][] state) {
        int[] v = {0, 1, 2, 3, 4, 5, 6, 7};
        int[] h = {0, 1, 2, 3};
        Random r1 = new Random();
        for (int i = 0; i < 8; i++) {
            int index = r1.nextInt(8);
            int temp = v[index];
            v[index] = v[i];
            v[i] = temp;
        }
        Random r2 = new Random();
        for (int i = 0; i < 4; i++) {
            int index = r2.nextInt(4);
            int temp = h[index];
            h[index] = h[i];
            h[i] = temp;
        }
        define:
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 4; j++) {
                if ((CannonJudge.cj(x, y, v[i], h[j], board, state))) {
                    int k = board[v[i]][h[j]];
                    int s = state[v[i]][h[j]];
                    board[v[i]][h[j]] = board[x][y];
                    state[v[i]][h[j]] = 1;
                    board[x][y] = 100;
                    if (s == 0) {
                        System.out.printf("*被吃掉的棋子是%s\n", Convert.convert(k));
                    }
                    break define;
                }
            }
        }
    }


    public static int calculateScore(int x, int y, int[][] board, int[][] state) {
        int s = 0;
        if (state[x][y] == 0) {
            for (int i = Math.max(0, x - 1); i <= Math.min(7, x + 1); i++) {
                for (int j = Math.max(0, y - 1); j <= Math.min(3, y + 1); j++) {
                    if (i != x && j != y && state[i][j] == 1) {
                        s++;
                    } else {
                        if (state[i][j] == 1) {
                            s--;
                        }
                    }
                }
            }
        }
        if (state[x][y] == 1 && Math.abs(board[x][y]) != 7) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 4; j++) {
                    if (MoveJudge.mj(x, y, i, j, board, state) && board[i][j] != 100) {
                        s = Math.max(s, Score.score(board[i][j]));
                    }
                    if (MoveJudge.mj(x, y, i, j, board, state) && board[i][j] == 100) {
                        int[][] tM = new int[8][4];
                        int t = 0;
                        for (int x1 = 0; x1 < 8; x1++) {
                            for (int y1 = 0; y1 < 4; y1++) {
                                if (MoveJudge.mj(i, j, x1, y1, board, state)) {
                                    tM[x1][y1] = Score.score(board[x1][y1]) / 2;
                                    t = Math.max(t, tM[x1][y1]);
                                }
                            }
                        }
                        s = Math.max(s, t);
                    }
                }
            }
        }
        if (state[x][y] == 1 && Math.abs(board[x][y]) == 7) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 4; j++) {
                    if (CannonJudge.cj(x, y, i, j, board, state) && state[i][j] == 0) {
                        s = Math.max(s, 5);
                    }
                    if (CannonJudge.cj(x, y, i, j, board, state) && state[i][j] == 1) {
                        s = Math.max(s, Score.score(board[i][j]) + 1);
                    }
                }
            }
        }

        return s;
    }

    public static void AIChoose(int[][] board, int[][] state, ArrayList<int[][]> BL,ArrayList<int[][]> SL) {
        new Thread(() -> {
            try {
                Thread.sleep(1000);
                int[][] score = new int[8][4];
                int s0 = 0;
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 4; j++) {
                        if (!randomChooseJudge(i, j, board, state)) {
                            score[i][j] = -100;
                        }
                        if (randomChooseJudge(i, j, board, state)) {
                            score[i][j] = calculateScore(i, j, board, state);
                            s0 = Math.max(s0, calculateScore(i, j, board, state));
                        }
                    }
                }
                int x = -1;
                int y = -1;
                define:
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 4; j++) {
                        if (score[i][j] == s0) {
                            x = i;
                            y = j;
                            break define;
                        }
                    }
                }
                System.out.println(x + "," + y);
                //------------------------------------------------------------------
                if (state[x][y] == 1 && Math.abs(board[x][y]) != 7) {
                    int[][] sM = new int[8][4];
                    int m = 0;
                    for (int i = 0; i < 8; i++) {
                        for (int j = 0; j < 4; j++) {

                            if (MoveJudge.mj(x, y, i, j, board, state) && board[i][j] != 100) {
                                sM[i][j] = Score.score(board[i][j]);
                            } else {
                                if (!MoveJudge.mj(x, y, i, j, board, state)) {
                                    sM[i][j] = -100;
                                } else {
                                    sM[i][j] = 1;
                                }
                            }
                            m = Math.max(m, sM[i][j]);
                            System.out.println("m=" + m);
                        }
                    }
                    int x1 = -1;
                    int y1 = -1;
                    Define:
                    for (int i = 0; i < 8; i++) {
                        for (int j = 0; j < 4; j++) {
                            if (sM[i][j] == m) {
                                x1 = i;
                                y1 = j;
                                break Define;
                            }
                        }
                    }
                    System.out.println("x1=" + x1 + "," + "y1=" + y1);
                    board[x1][y1] = board[x][y];
                    board[x][y] = 100;
                }
                //---------------------------------------------------------------------------------
                if (state[x][y] == 1 && Math.abs(board[x][y]) == 7) {
                    int[][] sM = new int[8][4];
                    int m = 0;
                    for (int i = 0; i < 8; i++) {
                        for (int j = 0; j < 4; j++) {
                            if (CannonJudge.cj(x, y, i, j, board, state) && state[i][j] == 0) {
                                sM[i][j] = 5;
                                m = Math.max(m, 5);
                            } else {
                                if (CannonJudge.cj(x, y, i, j, board, state) && state[i][j] == 1) {
                                    sM[i][j] = Score.score(board[i][j]) + 1;
                                    m = Math.max(m, sM[i][j]);
                                }
                                if (!CannonJudge.cj(x, y, i, j, board, state)) {
                                    sM[i][j] = -100;
                                    m = Math.max(m, sM[i][j]);
                                }
                            }
                        }
                    }
                    int x1 = -1;
                    int y1 = -1;
                    Define:
                    for (int i = 0; i < 8; i++) {
                        for (int j = 0; j < 4; j++) {
                            if (sM[i][j] == m) {
                                x1 = i;
                                y1 = j;
                                break Define;
                            }
                        }
                    }
                    System.out.println("x1=" + x1 + "," + "y1=" + y1);
                    int k = board[x1][y1];
                    int s = state[x1][y1];
                    board[x1][y1] = board[x][y];
                    state[x1][y1] = 1;
                    board[x][y] = 100;
                    if (s == 0) {
                        System.out.printf("*被吃掉的棋子是%s\n", Convert.convert(k));
                    }
                }
                //------------------------------------------------------------------------------
                if (state[x][y] == 0) {
                    state[x][y] = 1;
                }
                if (DarkChess.round % 2 == 0) {

                    if (DarkChess.c > 0) {
                        View.sideB.setIcon(View.sideRed);
                        View.sideA.setIcon(View.sideNull);
                    }
                    if (DarkChess.c < 0) {
                        View.sideB.setIcon(View.sideBlack);
                        View.sideA.setIcon(View.sideNull);
                    }
                }
                if (DarkChess.round % 2 == 1) {
                    if (DarkChess.c > 0) {
                        View.sideA.setIcon(View.sideBlack);
                        View.sideB.setIcon(View.sideNull);
                    }
                    if (DarkChess.c < 0) {
                        View.sideA.setIcon(View.sideRed);
                        View.sideB.setIcon(View.sideNull);
                    }
                }
                AudioPlayer.playSound("D:\\Project\\Audio\\click.wav");
                View.redraw(board, state);
                System.out.println("AI已经完成操作");
                View.textArea.append("\nAI已经完成操作");
                BoardList.setBoardlist(board, state, BL, SL);

                if (ScoreDetector.scoreRed(board) >= 60) {
                    Var.d = 0;
                    if (DarkChess.round % 2 == 1 && Var.clock != -1) {
                        User.plusWinningRate();
                    }
                    if (DarkChess.round % 2 == 0 && Var.clock != -1) {
                        User.minusWinningRate();
                    }
                    int userOption2 = JOptionPane.showConfirmDialog(null, "游戏结束，红色方胜利！是否查看棋谱？", "结束游戏", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (userOption2 == JOptionPane.OK_OPTION) {
                        ShowBoardList.showList(BL, SL);
                    }
                    User.showRank();
                    DarkChess.round = 2;
                    View.b.setVisible(false);
                    View.r.setVisible(false);
                    View.rs.setVisible(false);
                    View.c.setVisible(false);

                    View.endGame.setVisible(true);
                }
                if (ScoreDetector.scoreBlack(board) >= 60) {
                    Var.d = 0;
                    if (DarkChess.round % 2 == 1 && Var.clock != -1) {
                        User.plusWinningRate();
                    }
                    if (DarkChess.round % 2 == 0 && Var.clock != -1) {
                        User.minusWinningRate();
                    }
                    int userOption2 = JOptionPane.showConfirmDialog(null, "游戏结束，黑色方胜利！是否查看棋谱？", "结束游戏", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (userOption2 == JOptionPane.OK_OPTION) {
                        ShowBoardList.showList(BL, SL);
                    }
                    User.showRank();
                    DarkChess.round = 2;
                    View.b.setVisible(false);
                    View.r.setVisible(false);
                    View.rs.setVisible(false);
                    View.c.setVisible(false);
//            AI.progressBar.setVisible(false);
                    View.endGame.setVisible(true);
                }
                System.out.printf("第%d回合开始\n", DarkChess.round / 2);
                View.textArea.append("\n第" + DarkChess.round / 2 + "回合开始");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}
