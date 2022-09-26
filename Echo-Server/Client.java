import java.net.*;
import java.io.*;

public class Client{

    public static void main(String[] args) throws IOException {
        Socket st = new Socket("localhost",2000);
        
        BufferedReader kr = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(st.getInputStream()));
        PrintStream pr = new PrintStream(st.getOutputStream());

        String msg;
        do{
            msg = kr.readLine();
            //sending the msg on to the servegr
            pr.println(msg);
            msg = br.readLine();
         System.out.println("From Server:"+msg);
        }while(!msg.equals("dne"));

        st.close();
    }
    
}