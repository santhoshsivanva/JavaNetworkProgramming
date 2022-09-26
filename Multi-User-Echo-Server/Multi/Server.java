import java.io.IOException;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

//Multi-Client Connection
public class Server extends Thread{
    Socket st;
    String user;
    public Server(Socket st,String user){
        this.st = st;
        this.user = user;
    }

    
    //wow condition
    public void run(){

        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(st.getInputStream()));
            PrintStream ps = new PrintStream(st.getOutputStream());
            String msg;
            do{
                msg=br.readLine();
                ps.println(user+": "+msg.toUpperCase());
            }while(!msg.equals("dne"));
        }
        catch(Exception e){
            System.out.println(e);
        }
        try {
            st.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    
    public static void main(String[] args) throws IOException{
        try (ServerSocket ss = new ServerSocket(2000)) {
            Socket st;
            int i=0;
            Server sr;
            //multiple users
            do{
                st = ss.accept();
                System.out.println(st);
                i++;
                sr = new Server(st, "User"+i);
                sr.start();

            }while(true && i<=10);
        } //try with resource type
     }
}
