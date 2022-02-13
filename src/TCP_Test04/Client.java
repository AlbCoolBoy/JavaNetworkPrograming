package TCP_Test04;

import com.sun.source.tree.Scope;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.Buffer;

public class Client {
    public static void main(String[] args) throws IOException {
        InetAddress address=InetAddress.getByName("192.168.0.101");
        int port=10086;
        Socket client=new Socket(address,port);

        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        String line;
        while((line=bufferedReader.readLine())!=null){
            if("$".equals(line)){
                break;
            }
            bufferedWriter.write(line);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }



    }
}
