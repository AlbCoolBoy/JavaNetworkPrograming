package UDP_Test;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Send {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket=new DatagramSocket();
        InetAddress inetAddress=InetAddress.getByName("192.168.0.104");
        int port=10086;
        Scanner scanner = new Scanner(System.in);
        String line;
        while((line=scanner.nextLine())!=null){         //只要发送的数据不是886，就一直发送和接收数据,这个方法可以用来实现一个中止机制
            if("886".equals(line)){
                break;
            }
            byte[] bytes=line.getBytes();
            DatagramPacket datagramPacket=new DatagramPacket(bytes, bytes.length,inetAddress,port);
            datagramSocket.send(datagramPacket);
        }
    }
}
