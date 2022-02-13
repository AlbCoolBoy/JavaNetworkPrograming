package UDP;

import java.io.IOException;
import java.net.*;

public class SendDemo {
    public static void main(String[] args) throws IOException {
        //发动数据的步骤
        //创建发送端的Socket对象（DatagramSocket）
        //创建数据并将数据打包
        //调用DatagramSocket的send方法发送数据
        //关闭发送端
        DatagramSocket datagramSocket=new DatagramSocket();
        byte[] bytes="hello,world".getBytes();
        InetAddress address=InetAddress.getByName("192.168.0.101");
        int port=10086;
        DatagramPacket dp=new DatagramPacket(bytes, bytes.length,address,port);

        datagramSocket.send(dp);
        datagramSocket.close();

    }
}
