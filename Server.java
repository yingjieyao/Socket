import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.net.ServerSocket;  
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.*;



public class Server implements Runnable {  
    private Socket socket;  
    private ServerSocket ss; 
    private static int FileReceCnt=0;
    public Server(Socket s){
        super();
        this.socket=s;
    }
    public Server() throws IOException {  
        try{
            ss = new ServerSocket(7777);
            while(true){
                 socket = ss.accept();  
                  new Thread(new Server(socket)).start();
                  FileReceCnt++;
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }  
    public void run(){
        byte[] buf=new byte[100];
        InputStream is=null;
        FileOutputStream fos=null;
         try{
            // byte[] buf = new byte[1000];  
            is = socket.getInputStream();
            Arrays.fill(buf,(byte)0);
            int len=is.read(buf);
            String filename= new String(buf);
            System.out.println(filename);
            fos=new FileOutputStream(FileReceCnt+filename);
            int data;
            while((data=is.read())!=-1){
                fos.write(data);
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(fos!=null)fos.close();
                if(is!=null)is.close();
                this.socket.close();
            }catch(IOException e){
                e.printStackTrace();
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