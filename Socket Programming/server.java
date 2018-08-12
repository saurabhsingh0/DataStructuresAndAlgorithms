import java.io.*;
import java.net.*;
public class server{
	ServerSocket ss= new ServerSocket(6666);
	Socket s=ss.accept();
	DataInputStream din= new DataInputStream(s.getInputStream());
	String str=(String)din.readUTF();
	System.out.println("message= "+str);  
	ss.close();  
}