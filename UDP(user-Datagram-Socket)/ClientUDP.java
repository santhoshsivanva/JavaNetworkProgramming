import java.net.DatagramSocket;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.util.Scanner;

public class ClientUDP {
    public static final int port = 1235;

    public static void Connect() throws IOException {
        byte[] arr = null;
        DatagramSocket ds = new DatagramSocket(port);
        InetAddress ip = InetAddress.getLocalHost();
        // get the ip of the Host..
        Scanner inn = new Scanner(System.in);
        String msg = inn.nextLine();
        arr = msg.getBytes();
        DatagramPacket Dp = new DatagramPacket(arr, arr.length, ip, 2000);
        ds.send(Dp);

        // Receive from the Server Side.
        byte b[] = new byte[1024];
        Dp = new DatagramPacket(b, 1024);
        ds.receive(Dp);
        msg = new String(Dp.getData());
        System.out.println("The Msg received from the Server: " + msg);
        ds.close();
        inn.close();
    }

    public static void main(String[] args) {
        try {
            ClientUDP.Connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}