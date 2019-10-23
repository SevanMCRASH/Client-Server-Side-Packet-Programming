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

/*number -1
BufferedReader file =new BufferedReader(new InputStreamReader(s.getInputStream()));
String myfile;
BufferedReader Read = new BufferedReader(new FileReader(myfile  = file.readLine( )));
PrintWriter pw = new PrintWriter(s.getOutputStream());
OutputStream os = s.getOutputStream();
PrintWriter write = new PrintWriter(os, true);
String str;
while((str = Read.readLine()) !=  null) 
{
 write.println(str);         
}
write.close(); 
file.close();
Read.close();
s.close();   
ss.close();
*/


/*number -2
BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
String str = br.readLine();
System.out.println(str);
String sub = str.substring(0,str.length());

OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
PrintWriter out = new PrintWriter(os);
out.println(sub);
os.flush();
br.close();
s.close();
ss.close();	 

int count;
byte[] buffer = new byte[8192]; // or 4096, or more
while ((count = in.read(buffer)) > 0)
{
  out.write(buffer, 0, count);
}
*/

