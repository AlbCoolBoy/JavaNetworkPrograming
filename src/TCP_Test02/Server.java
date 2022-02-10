package TCP_Test02;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.RandomAccess;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket=new ServerSocket(10086);
            Socket accept=serverSocket.accept();

            InputStream inputStream=accept.getInputStream();
            byte[] bytes=new byte[1024];
            int length=inputStream.read(bytes);
            String data=new String(bytes,0,length);
            System.out.println("服务器："+data);

            OutputStream outputStream= accept.getOutputStream();
            outputStream.write("服务器收到数据".getBytes(StandardCharsets.UTF_8));

            accept.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
