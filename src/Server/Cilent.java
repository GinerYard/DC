package Server;

import Project.MainGameClient;
import Project.Menu;
import Project.Server;
import Project.View;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class Cilent {
    /*
     * 客户端
     * */
    public static void main(String[] args) throws IOException {
        int[][] board = new int[8][4];
        int[][] state = new int[8][4];
        ArrayList<int[][]> BL = new ArrayList<>();
        ArrayList<int[][]> SL = new ArrayList<>();
        //与服务器进行连接

        Server.socket = new Socket("127.0.0.1", 12138);
        //接收服务器发来的消息
        //1.获取输入流
        //2.将输入流的类型转换为字符流 一次读一行
        OutputStream os =  Server.socket.getOutputStream();
        PrintStream ps = new PrintStream(os);
        ps.println("客户端连接成功");

        View.createView(board,state,BL,SL);


        Server.inData(board,state);
        View.createView(board,state,BL,SL);
        View.frame.setVisible(true);
        View.textArea.setText(null);
    }



}
