package Project;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void server() throws IOException {
        //搭建服务器
        ServerSocket serverSocket = new ServerSocket(12138);
        System.out.println("服务器开启成功");
        while (true) {
            new Thread(() -> {
                try {
                    //等待客户连接
                    Socket socket = serverSocket.accept();
                    System.out.println("一个客户端连接了");
                    //向客户端发送消息
                    //1.获取输出流
                    OutputStream os = socket.getOutputStream();
                    PrintStream ps = new PrintStream(os);
                    ps.println("欢迎您的到来！");

                    //接收客户端发来的消息
                    InputStream is = socket.getInputStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));
                    String text = br.readLine();
                    var s = text.split(" ");
                    int x = Integer.parseInt(s[0]);
                    int y = Integer.parseInt(s[1]);
                    int id = Integer.parseInt(s[2]);
                    System.out.println("客户端消息：" + text);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }


}
