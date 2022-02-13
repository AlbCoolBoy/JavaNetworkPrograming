package TCP_Test_Demo;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.Buffer;

public class Client {
    public static void main(String[] args) throws IOException {

        InetAddress inetAddress=InetAddress.getByName("192.168.0.101");
        int port=10086;

        Socket client=new Socket(inetAddress,port);
        //封装输入流对象
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));     //System.in是从控制台输入字符流
        //封装输出流对象
        BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

        String line;
        while((line= bufferedReader.readLine())!=null){
            if("886".equals(line)){
                break;
            }
            bufferedWriter.write(line);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }
    client.close();
    }
}
