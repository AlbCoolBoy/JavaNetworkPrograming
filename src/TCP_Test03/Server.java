package TCP_Test03;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket=new ServerSocket(10086);
        Socket accept= serverSocket.accept();

        //获取输入流
        InputStream inputStream= accept.getInputStream();

    }
}
