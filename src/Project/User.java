package Project;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

import static Project.Var.clock;

public class User {
    public static ArrayList<String> U = new ArrayList<>();
    public static ArrayList<String> P = new ArrayList<>();
    public static ArrayList<Double> W = new ArrayList<>();//胜率

    public static ArrayList<Integer> N = new ArrayList<>();
    static Var user = new Var();
    static Var password = new Var();
    static Var ensurePassword = new Var();
    public static JPanel User = new JPanel();

    public static JButton login = new JButton();
    public static JButton register = new JButton();
    public static JButton quitLogin = new JButton();
    public static JButton showWinningRate = new JButton();
    public static JButton back = new JButton();


    public static void showUser() {
        U = SaveLoad.loadU();
        P = SaveLoad.loadP();
        W = SaveLoad.loadW();
        N = SaveLoad.loadN();
        while (true) {
            String[] options = {"登录", "注册", "退出登录", "返回"};
            String info = (String) JOptionPane.showInputDialog(null, "请输入你的选项：", "用户", JOptionPane.QUESTION_MESSAGE, null, options, options[2]);
            if (info.equals(options[0])) {
                login();
            }
            if (info.equals(options[1])) {
                register();
            }
            if (info.equals(options[2])) {
                clock = -1;
                JOptionPane.showMessageDialog(null, "退出登录成功！", "退出登录", JOptionPane.WARNING_MESSAGE);
                View.welcome.setText("欢迎回来!");
                return;
            }
            if (info.equals(options[3])) {
                return;
            }
        }
//        int flag = 0;
//        Scanner input = new Scanner(System.in);
//        ArrayList<String> U0 = SaveLoad.loadU();
//        U.setU(U0);
//        ArrayList<String> P0 = SaveLoad.loadP();
//        P.setP(P0);
//        ArrayList<Double> W0 = SaveLoad.loadW();
//        W.setW(W0);
//        ArrayList<Integer> N0 = SaveLoad.loadN();
//        N.setN(N0);
//        if (clock != -1) {
//            System.out.println("欢迎回来！" + U.getU().get(clock));
//        }
//        System.out.println("0 登录");
//        System.out.println("1 注册");
//        System.out.println("-1 返回");
//        System.out.println("2 退出登录");
//        System.out.println("3 显示胜率");
//        System.out.println("4 排行榜");
//        do {
//            int n = input.nextInt();
//            if (n == 0) {
//                login();
//                System.out.println("-1 返回");
//                System.out.println("2 退出登录");
//                System.out.println("3 显示胜率");
//                System.out.println("4 排行榜");
//            }
//            if (n == 1) {
//                register();
//                flag = 1;
//            }
//            if (n == -1) {
//                flag = 1;
//            }
//            if (n == 2) {
//                clock = -1;
//                System.out.println("退出登录成功！");
//                flag = 1;
//            }
//            if (n == 3) {
//                showWinningRate();
//                flag = 1;
//            }
//            if (n == 4) {
//                showRank();
//                flag = 1;
//            }
//        } while (flag != 1);
    }

    public static void register() {
        int r = 0;
        while (r != 1) {
            String t1 = JOptionPane.showInputDialog(null, "请输入您的用户名：", "注册", JOptionPane.WARNING_MESSAGE);
            user.setUser(t1);
            for (String s : U) {
                if (user.getUser().equals(s)) {
                    JOptionPane.showMessageDialog(null, "用户名已存在！", "注册失败", JOptionPane.WARNING_MESSAGE);
                    break;
                }
            }
            int k = 0;
            do {
                String t2 = JOptionPane.showInputDialog(null, "请输入您的密码", "注册", JOptionPane.WARNING_MESSAGE);
                password.setPassword(t2);
                String t3 = JOptionPane.showInputDialog(null, "请确认您的密码", "注册", JOptionPane.WARNING_MESSAGE);
                ensurePassword.setEnsurePassword(t3);
                if (!password.getPassword().equals(ensurePassword.getEnsurePassword())) {
                    JOptionPane.showMessageDialog(null, "两次密码输入不一致！", "注册失败", JOptionPane.WARNING_MESSAGE);
                }
                if (password.getPassword().equals(ensurePassword.getEnsurePassword())) {
                    k = 1;
                }
            } while (k == 0);
            if (password.getPassword().equals(ensurePassword.getEnsurePassword())) {
                JOptionPane.showMessageDialog(null, "账号注册成功！", "注册成功", JOptionPane.WARNING_MESSAGE);
                ArrayList<String> U1 = U;
                U1.add(user.getUser());
                U=U1;
                ArrayList<String> P1 = P;
                P1.add(password.getPassword());
                P = P1;
                ArrayList<Double> W1 = W;
                W1.add((double) 0);
                W= W1;
                ArrayList<Integer> N1 = N;
                N1.add(0);
                N=N1;
                SaveLoad.saveU(U);
                SaveLoad.saveP(P);
                SaveLoad.saveW(W);
                SaveLoad.saveN(N);
                r = 1;
            }
        }
    }


    public static void login() {

        String t1 = JOptionPane.showInputDialog(null, "请输入您的用户名：", "登录", JOptionPane.WARNING_MESSAGE);
        user.setUser(t1);
        int n = 0;
        if (U.contains(user.getUser())) {
            for (String s : U) {
                if (!user.getUser().equals(s)) {
                    n++;
                }
                if (user.getUser().equals(s)) {
                    break;
                }
            }
        }else {JOptionPane.showMessageDialog(null, "用户名不存在！", "登录", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String t2 = JOptionPane.showInputDialog(null, "请输入您的密码：", "登录", JOptionPane.WARNING_MESSAGE);
        password.setPassword(t2);
        if (password.getPassword().equals(P.get(n))) {
            JOptionPane.showMessageDialog(null, "登录成功！", "登录", JOptionPane.WARNING_MESSAGE);
            clock = n;
            View.welcome.setText("欢迎回来,"+U.get(clock)+"!");
            System.out.println(clock);
            return;
        }
        if (!password.getPassword().equals(P.get(n))) {
            JOptionPane.showMessageDialog(null, "密码错误！", "登录", JOptionPane.WARNING_MESSAGE);
        }

    }

    public static void showWinningRate() {
        if (clock != -1) {
            System.out.println("您的胜率为" + W.get(clock));
        }
        if (clock == -1) {
            System.out.println("您还未登录！");
        }
    }

    public static void showRank() {
        U=(SaveLoad.loadU());
        P=(SaveLoad.loadP());
        W=(SaveLoad.loadW());
        N=(SaveLoad.loadN());
        ArrayList<Double> W1 = W;
        View.rank.setText(null);
        System.out.println("排名" + "  " + "用户" + "  " + "胜率");
        int k = 0;
        int r = 1;
        while (k != 1) {
            for (Double d : W1) {
                int n = 0;
                for (Double d1 : W1) {
                    if (d >= d1) {
                        n++;
                    }
                }
                if (n == W1.size() && d != 0) {
                    View.rank.append(String.valueOf(r));
                    View.rank.append("             " + U.get(W1.indexOf(d)));
                    View.rank.append("             " + String.format("%.1f", d * 100));
                    View.rank.append("%\n");
                    W1.set(W1.indexOf(d), (double) 0);
                    r++;
                }
                if (n == W1.size() && d == 0) {
                    k = 1;
                }
            }
        }
    }


    public static void plusWinningRate() {
        System.out.println(W.get(0)+" "+W.get(1));
        int n = N.get(clock);
        N.set(clock, n + 1);
        double w = W.get(clock);
        W.set(clock, (n * w + 1) / (n + 1));
        SaveLoad.saveN(N);
        SaveLoad.saveW(W);
    }

    public static void minusWinningRate() {
        int n = N.get(clock);
        N.set(clock, n + 1);
        double w = W.get(clock);
        W.set(clock, (n * w) / (n + 1));
        SaveLoad.saveN(N);
        SaveLoad.saveW(W);
    }
}
