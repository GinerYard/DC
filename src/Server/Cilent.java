package Server;

import java.io.*;
import java.net.Socket;

public class Cilent {
        /*
         * 客户端
         * */
        public static void main(String[] args) throws IOException {
            //与服务器进行连接
            Socket socket=new Socket("127.0.0.1",12138);

            //接收服务器发来的消息
            //1.获取输入流
            InputStream is=socket.getInputStream();
            //2.将输入流的类型转换为字符流 一次读一行
            BufferedReader br=new BufferedReader(new InputStreamReader(is));
            String text=br.readLine();
            System.out.println("服务器消息："+text);

            OutputStream os = socket.getOutputStream();
            PrintStream ps = new PrintStream(os);
            ps.println("1 2 3");
        }


}
