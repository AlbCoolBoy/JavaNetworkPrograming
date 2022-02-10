import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddress_Test01 {
    public static void main(String[] args) {
        try {
            InetAddress address=InetAddress.getByName("www.bing.com");      //解析主机名
            System.out.println(address);

            InetAddress address1=InetAddress.getByName("202.89.233.101");
            System.out.println(address1.getHostName());
            System.out.println(address1.getCanonicalHostName());
            //有些主机实际上有多个地址，可以将其返回成一个数组
            System.out.println("___________________________________________");
            InetAddress[] addresses=InetAddress.getAllByName("www.baidu.com");
            for(InetAddress inetAddress:addresses){
                System.out.println(inetAddress);
            }
            //查找本机地址
            System.out.println("__________________________________________");
            InetAddress local=InetAddress.getLocalHost();
            System.out.println(local);

        } catch (UnknownHostException e) {
            e.printStackTrace();
            System.out.println("can't find www.bing.com");
        }
    }
}
