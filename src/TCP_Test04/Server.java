package TCP_Test04;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {

        ServerSocket server=new ServerSocket(10086);
        Socket accept= server.accept();

        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(accept.getInputStream()));
        BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter("test.txt"));
        String line;
        while((line=bufferedReader.readLine())!=null){
            bufferedWriter.write(line);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }
        accept.close();
        server.close();
        bufferedWriter.close();
    }
}
