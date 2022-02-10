package TCP_Test02;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws SocketException {

        try {
            InetAddress inetAddress=InetAddress.getByName("192.168.0.104");
            int port=10086;
            Socket socket=new Socket(inetAddress,port);
            Scanner scanner = new Scanner(System.in);
            String cin;
            while((cin=scanner.nextLine())!=null){
                if("886".equals(cin)){
                    System.out.println("检测到终止符，通信挂起");
                    break;
                }
                OutputStream outputStream=socket.getOutputStream();
                outputStream.write(cin.getBytes(StandardCharsets.UTF_8));

                InputStream inputStream=socket.getInputStream();
                byte[] bytes=new byte[1024];
                int length= bytes.length;
                String data=new String(bytes,0,length);
                System.out.println("客户端："+data);
                System.out.println("发送成功");
            }
            socket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
