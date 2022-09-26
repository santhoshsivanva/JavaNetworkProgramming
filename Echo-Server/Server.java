import java.net.*;
import java.io.*;
public class Server {
    public static void main(String[] args) throws Exception{
        
        //Creating Socket requires:
        //java.net.ServerSocket
        //Knowledge of basic input and output Stream
        ServerSocket ss = new ServerSocket(2000);
        Socket stk = ss.accept();
        System.out.println(stk);

        //For this Socket we need two Streams
        //read stream
        BufferedReader br = new BufferedReader(new InputStreamReader(stk.getInputStream()));
        //write stream
        //printStream is the implementation of SYSTEM.OUT();
        PrintStream ps = new PrintStream(stk.getOutputStream());
        String msg;
        StringBuilder sb;
        //Inbuild method for String reversal..
        do{
              msg = br.readLine();
              sb = new StringBuilder(msg);
              sb.reverse();
              msg = sb.toString();
              ps.println(msg);
        }while(!msg.equals("dne"));
    }
}
