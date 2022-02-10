package UDP_Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Receive  {
    public static void main(String[] args) throws IOException {
        //这里使用死循环进行数据接收
        DatagramSocket datagramSocket=new DatagramSocket(10086);
        while(true){
            byte[] bytes=new byte[1024];

            DatagramPacket datagramPacket=new DatagramPacket(bytes, bytes.length);
            datagramSocket.receive(datagramPacket);
            byte[] data=datagramPacket.getData();       //是从数据包中获取数据的
            String receive=new String(data,0,data.length    );
            System.out.println("接收到数据："+receive);

        }

    }
}
