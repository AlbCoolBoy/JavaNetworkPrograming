package TCP_Test_Demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server=new ServerSocket(10086);
        Socket accept= server.accept();

        //通过层层封装将输入流封装成BufferReader流，以字符形式进行输出
        InputStream inputStream=accept.getInputStream();
        InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
        BufferedReader bufferedReader=new BufferedReader(inputStreamReader);

        String line;
        while((line= bufferedReader.readLine())!=null){
            System.out.println(line);
        }

        server.close();
    }
}
