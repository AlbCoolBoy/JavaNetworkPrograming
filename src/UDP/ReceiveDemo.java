package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ReceiveDemo {
    public static void main(String[] args) throws IOException {
        //创建接收端的DatagramSocket对象
        //创建一个数据包用于接收发送过来的数据包
        //嗲用DatagramSocket对象的接收方法接收数据
        //解析数据包并在控制台输出
        DatagramSocket datagramSocket=new DatagramSocket(10086);     //这里要使用的是有参构造，传递发送时的端口号
        byte[] bytes=new byte[1024];

        DatagramPacket datagramPacket=new DatagramPacket(bytes, bytes.length);
        datagramSocket.receive(datagramPacket);
        byte[] data = datagramPacket.getData();
        String receive=new String(data,0,data.length);
        System.out.println(receive);



    }
}
