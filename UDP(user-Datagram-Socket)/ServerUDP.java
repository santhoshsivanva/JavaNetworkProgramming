import java.io.IOException;
import java.net.*;

public class ServerUDP {
    // public static final int Port = 1234;

    public static void main(String[] args) throws IOException {
        DatagramPacket Dp;
        String msg;
        DatagramSocket ds = new DatagramSocket(2000);
        // Receive from the Cilent Side.
        byte b[] = new byte[1024];
        Dp = new DatagramPacket(b, 1024);
        ds.receive(Dp);
        msg = new String(Dp.getData()).trim();
        System.out.println("From Client" + msg);
        msg = msg.toUpperCase();
        byte[] bf = msg.getBytes();
        Dp = new DatagramPacket(bf, bf.length, InetAddress.getLocalHost(), Dp.getPort());
        ds.send(Dp);
        ds.close();
    }
}