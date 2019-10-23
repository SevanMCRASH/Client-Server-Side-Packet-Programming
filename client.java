package client;
import java.net.*;

import java.io.*;

public class client {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 try{
			//input - C:\\Users\\sevan\\Desktop\\input.txt
			 
			 Socket s = new Socket("localhost", 3400);//connect to ServerSocket
			 if(!s.isConnected())
			     System.out.println("Socket Connection Not established");
			 else
			     System.out.println("Socket Connection established : "+s.getInetAddress());
			 
			 BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\sevan\\Desktop\\input.txt"));
			 long startTime = System.nanoTime();
			 OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
			 PrintWriter out = new PrintWriter(os);
			 out.println(br.readLine());
			 br.close();
			 os.flush();
		        //recive a file and printout
		        byte[] bytes = new byte[3000000];
		        InputStream in = s.getInputStream();
	            FileOutputStream fos = new FileOutputStream("C:\\Users\\sevan\\Desktop\\a.txt");
	            BufferedOutputStream bos = new BufferedOutputStream(fos);
	            int bytesRead2;
	        	long endTime = System.nanoTime();
	    		long timeElapsed = endTime - startTime;
	    		System.out.println("Execution time in nanoseconds: " + timeElapsed);
	            while((bytesRead2 = in.read(bytes))>0) {
	            	bos.write(bytes,0,bytesRead2);
	            }
	            bos.close();
	            out.close();

	        }catch(Exception e){
	            System.out.println(e);
	         }
	}

}


/*number -1
System.out.print("Enter the file name :");
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
String myfile = br.readLine();
OutputStream  os = s.getOutputStream( );
PrintWriter pwrite = new PrintWriter(os, true);
pwrite.println(myfile);
BufferedReader sr = new BufferedReader(new InputStreamReader(s.getInputStream()));
String str;
int count = 0;
while((str = sr.readLine())  !=  null)
{ 
	count = str.length();          
} 
System.out.println(count);
os.flush();
sr.close();
br.close();
s.close();
*/

/*number -2
BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\sevan\\Desktop\\input.txt"));
OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
PrintWriter out = new PrintWriter(os);
out.println(br.readLine());
br.close();
os.flush();

BufferedReader readback = new BufferedReader(new InputStreamReader(s.getInputStream()));
System.out.println(readback.readLine().length());
*/

/*number -3
 * //send a file
			 /*
			 File myFile = new File("C:\\Users\\sevan\\Desktop\\input.txt");
			 byte[] b = new byte[(int)myFile.length()];
		        BufferedInputStream buffin = new BufferedInputStream(new FileInputStream(myFile));
		        OutputStream out = s.getOutputStream();
		        int bytesRead;
		        while((bytesRead = buffin.read(b))>0) {
		            out.write(b,0,bytesRead);
		        }
		        out.flush();
*/
