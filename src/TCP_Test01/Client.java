package TCP_Test01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

public class Client {
    public static void main(String[] args){
        InetAddress inetAddress= null;
        try {
            inetAddress = InetAddress.getByName("192.168.0.104");
            int port=10086;
            Socket client=new Socket(inetAddress,port);

            OutputStream outputStream=client.getOutputStream();
            outputStream.write("hello Server,comming".getBytes(StandardCharsets.UTF_8));

            //客户端接收反馈
            InputStream inputStream=client.getInputStream();
            byte[] bytes=new byte[1024];
            int length=inputStream.read(bytes);
            String data=new String(bytes,0,length);
            System.out.println("客户端: "+data);

            client.close();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
