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
            File f=fileChooser.getSelectedFile();
            String fname = f.getName();//从文件名输入框中获取文件名
            //创建文件
            File file=new File(fileChooser.getCurrentDirectory()+"/"+fname+".txt");
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

    public static ArrayList<int[][]> load() {
        BufferedReader bufferedReader = null;
        ArrayList<int[][]> L = new ArrayList<>();
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
            ArrayList<int[][]> Full = new ArrayList<>();
            while ((line = bufferedReader.readLine()) != null) {
                String[] strings = line.split("\\t");
                int[][] F = new int[8][4];
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 4; j++) {
                        F[i][j] = Integer.parseInt(strings[4 * i + j]);
                    }
                }
                Full.add(F);
            }
            for (int i = 0; i < Full.size(); i++) {
                L.add(Full.get(i));
            }


        } catch (Exception e) {
            Start.k = 1;
            System.out.println("棋盘读取失败！请检查文件格式");
        }
        return L;
    }

    public static void saveU(ArrayList<String> U) {
        File ofile = new File(("D:\\Project\\User.txt"));
        ofile.delete();
        try {
            File file = new File(("D:\\Project\\User.txt"));
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
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(new File("D:\\project\\User.txt")));
            bufferedReader = new BufferedReader(inputStreamReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String[] u = line.split("\\t");
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
        File ofile = new File(("D:\\Project\\Password.txt"));
        ofile.delete();
        try {
            File file = new File(("D:\\Project\\Password.txt"));
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
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(new File("D:\\project\\Password.txt")));
            bufferedReader = new BufferedReader(inputStreamReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String[] u = line.split("\\t");
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
        File ofile = new File(("D:\\Project\\Winning.txt"));
        ofile.delete();
        try {
            File file = new File(("D:\\Project\\Winning.txt"));
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
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(new File("D:\\project\\Winning.txt")));
            bufferedReader = new BufferedReader(inputStreamReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String[] u = line.split("\\t");
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
        File ofile = new File(("D:\\Project\\Number.txt"));
        ofile.delete();
        try {
            File file = new File(("D:\\Project\\Number.txt"));
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
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(new File("D:\\project\\Number.txt")));
            bufferedReader = new BufferedReader(inputStreamReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String[] u = line.split("\\t");
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
