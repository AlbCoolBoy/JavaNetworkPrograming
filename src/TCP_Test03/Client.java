package TCP_Test03;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket client=new Socket("192.168.0.104",10086);

        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        //封装输出流对象
        BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        String line;
        while((line=bufferedReader.readLine())!=null){
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
