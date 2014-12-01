import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class SendFileClient {

	private static final String SERVERIP = "172.0.0.1";
	private static final int SERVERPORT = 2234;
	private static final int CLIENTPORT = 5432;
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 用来接受传输过来的字符
		byte[] buf = new byte[100];
		
		Socket s = new Socket();
		try {
			// 建立连接
			s.connect(new InetSocketAddress(SERVERIP,SERVERPORT), CLIENTPORT);
			System.out.println("Su");
			InputStream is = s.getInputStream();
			// 接收传输来的文件名
			int len = is.read(buf);
			String fileName = new String(buf,0,len);
			System.out.println(fileName);
			
			//接收传输来的文件
			FileOutputStream fos = new FileOutputStream("D:\\"+"receive1.txt");
			int data;
			while(-1!=(data = is.read()))
			{
				fos.write(data);
//				System.out.println((char)data);
			}
			is.close();
			s.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

