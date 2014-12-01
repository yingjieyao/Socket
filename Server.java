import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.net.ServerSocket;  
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
public class Server {  
    private Socket socket;  
    private ServerSocket ss;  
    
    public Server() throws IOException {  
        ss = new ServerSocket(7777);
        byte[] buf = new byte[1000];  
        while (true) {  
            socket = ss.accept();  
            InputStream is = socket.getInputStream();
            int len=is.read(buf);
            String filename= new String(buf,0,len);
            System.out.println(filename);
            FileOutputStream fos=new FileOutputStream("new"+filename);
            int data;
            while((data=is.read())!=-1){
                fos.write(data);
                System.out.print((char)(data));
            }
        }  
    }  
  
    public static void main(String[] args) {  
        try {  
            new Server();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
}  