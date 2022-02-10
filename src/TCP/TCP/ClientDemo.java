package TCP.TCP;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

public class ClientDemo {
    public static void main(String[] args) {
        //客户端发送数据的步骤
        //1.创建客户端的Socket对象
        //2.获取输出流，写数据
        //3.释放资源
        try {
            InetAddress inetAddress=InetAddress.getByName("192.168.0.104");
            int port=10086;
            Socket client=new Socket(inetAddress,port);

            OutputStream outputStream = client.getOutputStream();
            outputStream.write("hello world".getBytes(StandardCharsets.UTF_8));

            client.close();


        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
