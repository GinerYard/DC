package Project;

import java.io.*;
import java.net.Proxy;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Server {
    public static ServerSocket server;
    public static Socket socket;

    public static void startServer(int[][] board, int[][] state, ArrayList<int[][]> BL, ArrayList<int[][]> SL) throws IOException {
        //搭建服务器
        server = new ServerSocket(12138);
        System.out.println("服务器开启成功");
        while (true) {
            new Thread(() -> {
                try {
                    //等待客户连接
                    socket = server.accept();
                    System.out.println("一个客户端连接了");
                    //向客户端发送消息
                    //1.获取输出流
                    Initializer.Init(board, state, BL, SL);
                    Menu.c = 0;
                    Menu.round = 2;
                    Var.d = 1;
                    outData(board,state);
                    View.frame.setVisible(true);
                    View.textArea.setText(null);
                    View.redraw(board, state);


                    //接收客户端发来的消息
                    InputStream is = socket.getInputStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));
                    String text = br.readLine();
                    System.out.println("客户端消息：" + text);




                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

        }
    }

    public static void inData(int[][] board, int[][] state) throws IOException {
        InputStream is = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String text = br.readLine();
        int[][] F = new int[16][4];
        while (text != null) {
            String[] strings = text.split("\\t");
            for (int i = 0; i < 16; i++) {
                for (int j = 0; j < 4; j++) {
                    F[i][j] = Integer.parseInt(strings[4 * i + j]);
                }
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 4; j++) {
                board[i][j] = F[i][j];
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 4; j++) {
                state[i][j] = F[i + 8][j];
            }
        }
    }

    public static void outData(int[][] board, int[][] state) throws IOException {
        OutputStream os = socket.getOutputStream();
        PrintStream ps = new PrintStream(os);
        StringBuilder s = new StringBuilder(new String());
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 4; j++) {
                s.append(String.valueOf(board[i][j])).append("\t");
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 4; j++) {
                s.append(String.valueOf(state[i][j])).append("\t");
            }
        }
        ps.print(s);
    }


}
