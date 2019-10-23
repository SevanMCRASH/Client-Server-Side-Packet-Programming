package server;
import java.net.*;
import java.io.*;

public class server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 try{
			 
	            ServerSocket ss = new ServerSocket(3400);//declare a new ServerSocket on port 3500
	            Socket s = ss.accept( );  //open the ServerckSoet to receive connections
	            if (!s.isConnected())
	                System.out.println("Client Socket not Connected...");
	            else
	                System.out.println("Client Socket Connected : " + s.getInetAddress());
	            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
	            long startTime = System.nanoTime();
	            String str = br.readLine();
	            String sub = str.substring(0,str.length());
	            //System.out.println(sub.getBytes("UTF-8").length);
	            OutputStream os = s.getOutputStream();
	            PrintWriter write = new PrintWriter(os, true);
	        	long endTime = System.nanoTime();
	    		long timeElapsed = endTime - startTime;
	    		System.out.println("Execution time in nanoseconds: " + timeElapsed);
	            write.println(sub);  
	            os.flush();
				 s.close();	
				 ss.close();
	        }catch(Exception e){
	             System.out.println(e);
	         }
	}
}
