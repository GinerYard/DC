package Project;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SaveLoad {
    public static void save(ArrayList<int[][]> BL, ArrayList<int[][]> SL) {
        try {
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("标签文件(*.txt)", "txt");
            fileChooser.setFileFilter(filter);
            fileChooser.setSelectedFile(new File("棋盘"));
            fileChooser.showSaveDialog(null);
            File f = fileChooser.getSelectedFile();
            String fname = f.getName();//从文件名输入框中获取文件名
            //创建文件
            File file = new File(fileChooser.getCurrentDirectory() + "/" + fname + ".txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fileWriter);
            for (int[][] B : BL) {
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 4; j++) {
                        bw.write(B[i][j] + "\t");
                    }
                }
                bw.write("\n");
            }
            for (int[][] S : SL) {
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 4; j++) {
                        bw.write(S[i][j] + "\t");
                    }
                }
                bw.write("\n");
            }
            bw.close();

        } catch (IOException e) {
            System.out.println("保存失败！");
        }
    }

    public static boolean check(int k) {
        return Math.abs(k) == 0 || Math.abs(k) == 1 || Math.abs(k) == 2 || Math.abs(k) == 3 || Math.abs(k) == 4 || Math.abs(k) == 5 || Math.abs(k) == 6 || Math.abs(k) == 7 || k == 100;
    }

    public static boolean checkMove(int[][] board1, int[][] board2, int[][] state1, int[][] state2) {
        boolean r = true;
        ArrayList<Integer> X = new ArrayList<>();
        ArrayList<Integer> Y = new ArrayList<>();
        Define:
        for (int i = 0; i < 8; i++) {
            for(int j = 0;j<4;j++){
                if(board1[i][j]!=board2[i][j]||state1[i][j]!=state2[i][j]){
                    X.add(i);
                    Y.add(j);
                }
            }
        }
        int x = X.get(0);
        int y = Y.get(0);
        if(X.size()==1){
            if((board1[x][y]!=board2[x][y]&&state1[x][y]==state2[x][y])||(board1[x][y]!=board2[x][y]&&state1[x][y]!=state2[x][y])){
                r = false;
            }
        }else {
            int a = X.get(1);
            int b = Y.get(1);
            if(!MoveJudge.mj(x,y,a,b,board1,state1)&&!MoveJudge.mj(a,b,x,y,board1,state1)&&!CannonJudge.cj(x,y,a,b,board1,state1)&&!CannonJudge.cj(a,b,x,y,board1,state1)){
                r = false;
            }
        }
        return r;
    }


    public static ArrayList<int[][]> load() {
        BufferedReader bufferedReader = null;
        ArrayList<int[][]> Full = new ArrayList<>();
        try {
            JFileChooser fd = new JFileChooser();
            fd.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            String[] saveType = {"txt"};
            fd.setFileFilter(new FileNameExtensionFilter("TXT FILE", saveType));
            fd.showOpenDialog(null);
            File file = fd.getSelectedFile();
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file));
            bufferedReader = new BufferedReader(inputStreamReader);
            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                String[] strings = line.split("\t");
                if (strings.length != 32) {
                    JOptionPane.showMessageDialog(null, "棋盘读取失败！请检查棋盘大小(102)", "加载失败", JOptionPane.WARNING_MESSAGE);
                    Start.k = 1;
                    throw new Exception("棋盘读取失败！请检查棋盘大小(102)");
                }
                int[][] F = new int[8][4];
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 4; j++) {
                        F[i][j] = Integer.parseInt(strings[4 * i + j]);
                        if (!check(F[i][j])) {
                            JOptionPane.showMessageDialog(null, "棋盘读取失败！请检查棋子格式(103)", "加载失败", JOptionPane.WARNING_MESSAGE);
                            Start.k = 1;
                            throw new Exception("棋盘读取失败！请检查棋子格式(103)");
                        }
                    }
                }
                Full.add(F);
            }
            int[][] board1 = Full.get(Full.size()/2-2);
                int[][] board2 = Full.get(Full.size()/2-1);
                int[][] state1 = Full.get(Full.size()-2);
                int[][] state2 = Full.get(Full.size()-1);
               if(!checkMove(board1,board2,state1,state2)){
                    JOptionPane.showMessageDialog(null, "棋盘读取失败！请检查棋子移动是否合法(105)", "加载失败", JOptionPane.WARNING_MESSAGE);
                   Start.k = 1;
                   throw new Exception("棋盘读取失败！请检查棋子移动是否合法(105)");
               }


        } catch (FileNotFoundException f) {
            Start.k = 1;
            System.out.println("棋盘读取失败！请检查文件格式");
            JOptionPane.showMessageDialog(null, "棋盘读取失败！请检查文件格式(101)", "加载失败", JOptionPane.WARNING_MESSAGE);
        } catch (Exception ignored) {

        }
        return Full;
    }

    public static void saveU(ArrayList<String> U) {
        File ofile = new File(("src\\User\\User.txt"));
        ofile.delete();
        try {
            File file = new File(("src\\User\\User.txt"));
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fileWriter);
            for (String u : U) {
                bw.write(u + "\t");
            }
            bw.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<String> loadU() {
        BufferedReader bufferedReader = null;
        ArrayList<String> U = new ArrayList<>();
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(new File("src\\User\\User.txt")));
            bufferedReader = new BufferedReader(inputStreamReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String[] u = line.split("\t");
                for (String s : u) {
                    U.add(s);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return U;
    }

    public static void saveP(ArrayList<String> P) {
        File ofile = new File(("src\\User\\Password.txt"));
        ofile.delete();
        try {
            File file = new File(("src\\User\\Password.txt"));
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fileWriter);
            for (String u : P) {
                bw.write(u + "\t");
            }
            bw.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<String> loadP() {
        BufferedReader bufferedReader = null;
        ArrayList<String> P = new ArrayList<>();
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(new File("src\\User\\Password.txt")));
            bufferedReader = new BufferedReader(inputStreamReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String[] u = line.split("\t");
                for (String s : u) {
                    P.add(s);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return P;
    }

    public static void saveW(ArrayList<Double> W) {
        File ofile = new File(("src\\User\\Winning.txt"));
        ofile.delete();
        try {
            File file = new File(("src\\User\\Winning.txt"));
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fileWriter);
            for (double u : W) {
                bw.write(u + "\t");
            }
            bw.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Double> loadW() {
        BufferedReader bufferedReader = null;
        ArrayList<Double> W = new ArrayList<>();
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(new File("src\\User\\Winning.txt")));
            bufferedReader = new BufferedReader(inputStreamReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String[] u = line.split("\t");
                for (String s : u) {
                    W.add(Double.valueOf(s));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return W;
    }

    public static void saveN(ArrayList<Integer> N) {
        File ofile = new File(("src\\User\\Number.txt"));
        ofile.delete();
        try {
            File file = new File(("src\\User\\Number.txt"));
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fileWriter);
            for (int u : N) {
                bw.write(u + "\t");
            }
            bw.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Integer> loadN() {
        BufferedReader bufferedReader = null;
        ArrayList<Integer> N = new ArrayList<>();
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(new File("src\\User\\Number.txt")));
            bufferedReader = new BufferedReader(inputStreamReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String[] u = line.split("\t");
                for (String s : u) {
                    N.add(Integer.valueOf(s));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return N;
    }


}
