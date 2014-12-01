import java.net.Socket;  
import java.net.UnknownHostException;  
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
import java.util.*;



public class Client {  
    Socket client;  
    OutputStream os=null;  
    FileInputStream filein=null;
    public Client() throws UnknownHostException, IOException {  
        client=new Socket("localhost",7777);  
        os=(client.getOutputStream());
        Scanner cin = new Scanner(System.in);
            String s=cin.next();
            client=new Socket("localhost",7777);  
            os=(client.getOutputStream());
            filein=new FileInputStream(s);
            // s=s+"\0"; 
            os.write(s.getBytes());
            int data;
            while((data=filein.read())!=-1){
                os.write(data);
                System.out.println(data);
            }
         os.close();  
        // while(true);
    }  
    public static void main(String[] args) {  
        try {  
            new Client();  
        } catch (UnknownHostException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
}  