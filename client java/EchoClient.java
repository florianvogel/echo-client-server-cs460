import java.net.*;
import java.io.*;
import java.util.Scanner;

public class EchoClient {

	public static void main(String args[]){						//check input
        if (args.length!=2)
            System.err.println("Usage java EchoClient <host> <port>");
        else	
        try{
            Socket s		= new Socket(args[0],Integer.parseInt(args[1]));	//open Socket
            PrintStream O	= new PrintStream(s.getOutputStream());				//open Stream
            BufferedReader I= new BufferedReader(new InputStreamReader(s.getInputStream()));
            String X;
            Scanner scanner =new Scanner(System.in);
			while (true) {
				System.out.println("Input: (q stops)");
				String input = scanner.nextLine();			//get input from user
				if(input.equals("q")){
					break;
				}
                O.println("" + input);							//send input to server
                X=I.readLine();
                System.out.println("From Server:\n"+X);                                 //output response from server
			}
        s.close();									//close socket
        }catch(Exception e){System.out.println(e);e.printStackTrace();}

    }
}	

