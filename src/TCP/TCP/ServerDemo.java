package TCP.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
    public static void main(String[] args) {
        //接收数据的步骤
        //1.创建服务端的ServerSocket对象
        //2.获取输入流对象
        //3.释放资源

        try {
            ServerSocket server=new ServerSocket(10086);

            //这时候首先要做的不是获取数据流，而是监听客户端的socket对象，因此需要返回一个socket对象，然后使用socket的inpitStream得到输入流
            Socket accept = server.accept();
            InputStream inputStream = accept.getInputStream();
            byte[] bytes=new byte[1024];
            int length=inputStream.read(bytes);
            String data=new String(bytes,0,length);
            System.out.println("数据："+data);


            //记得释放两个资源
            accept.close();
            server.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
