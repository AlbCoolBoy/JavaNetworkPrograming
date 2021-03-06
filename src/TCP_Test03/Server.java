package TCP_Test03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket=new ServerSocket(10086);
        Socket accept= serverSocket.accept();

        //获取输入流，并将其封装成BufferReader类，直接获取字符，不通过传统的字节进行获取
        InputStream inputStream= accept.getInputStream();
        InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
        BufferedReader bufferedReader=new BufferedReader(inputStreamReader);

        String line;
        while((line=bufferedReader.readLine())!=null){
            System.out.println(line);
        }
    serverSocket.close();

    }
}
