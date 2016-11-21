/**
 * Author: Jayden Urch
 * Student No: 5388406
 * Email: jsu22@nau.edu
 *
 * Author: Florian Vogel
 * Student No: 5373720
 * Email: fv69@nau.edu
 *
 * Date: 10/06/2016
 */

import java.net.*;
import java.io.*;
import java.util.*;
import java.lang.*;
import java.security.*;


public class EchoServer
{
	public static void main(String argv[])
	throws IOException
	{
		int portnumber = 21995;
		ServerSocket ss = new ServerSocket(portnumber);
                while (true) new ServConn(ss.accept());	
        }
	
}  

class ServConn extends Thread
{
	PrintWriter out;
	Socket sock;
	ServConn(Socket s)
	{
		sock=s;
		start();
	}
	public void run()
	{
		try
		{
			out = new PrintWriter(sock.getOutputStream(), true);
			//Server
			String Command=null;
			String req;
			String buf;
			//System.out.println("Socket.localPort:"+sock.getLocalPort()+" Socket.port:"+sock.getPort());
			System.out.println("Accepted Client");
			BufferedReader BR = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            //buf=BR.readLine();
            //System.out.println(buf);
			String str;
			while((str= BR.readLine())!=null){
				System.out.println(str);
			}
            //out.println(buf);
			sock.close();
                }catch(IOException e){System.out.println("I/O Error "+e);}
        }
}
