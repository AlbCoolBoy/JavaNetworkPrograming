package TCP_Test01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(10086);
        Socket accept = serverSocket.accept();

        //输入流是用来获取监听到的数据的
        InputStream inputStream= accept.getInputStream();
        byte[] bytes=new byte[1024];
        int length=inputStream.read(bytes);     //将输入流存储到字节数组中
        String data=new String(bytes,0,length);
        System.out.println("服务器: "+data);

        //给客户端一个反馈
        OutputStream outputStream = accept.getOutputStream();
        outputStream.write("数据已经收到".getBytes(StandardCharsets.UTF_8));

        //释放资源
        accept.close();
        serverSocket.close();
    }
}
