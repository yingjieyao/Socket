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
        client=new Socket("127.0.0.1",7777);  
        os=(client.getOutputStream());
        Scanner cin = new Scanner(System.in);
        String s=cin.nextLine();
        filein=new FileInputStream(s); 
        os.write(s.getBytes());
       // BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
        int data;
        while((data=filein.read())!=-1){
            os.write(data);
            System.out.println(data);
        }
      //  os.write(br.readLine().getBytes());  
        os.close();  
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