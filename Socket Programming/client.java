import java.io.*;
import java.net.*;
public class client{
	Soket S= new Socket("localhost",6666);
	DataOutputStream dout=new DataOutputStream(s.getOutputStream());
	dout.writeUTF("Hello Server");
	dout.flush();
	dout.close();
	s.close();
}