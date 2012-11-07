import java.io.BufferedReader; 
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * SNAlert - SparkNotifyAlert
 * Connects to a running SparkNotify server and sends that server/class necessary information
 * to complete the task of sending a given alert to everyone on the given contact list/
 * 
 * @author cmullins
 *
 */
public class SNAlert
{
	private static Socket socket;
	private static PrintWriter printWriter;
	private String message, contacts, text, line;
	private FileInputStream fstream;
	private DataInputStream in;
	private BufferedReader br;
	
	/**
	 * Connects to the local socket and writes two messages, then closes the socket
	 * 
	 * @param pathMess
	 * @param pathContacts
	 */
	public SNAlert(String pathMess, String pathContacts){
		message = readAndReturn(pathMess);			//finds the file with the pathMess path - the file is read and returns a string representation
		contacts = readAndReturn(pathContacts); 	//finds the file with the pathContacts path - the file is read and returns a string representation
		try{
			socket = new Socket("localhost",63500);  //connects to chosen socket (must be the same as SparkNotify's local socket
			printWriter = new PrintWriter(socket.getOutputStream(),true); //printwriter is created to output messages to the predefined socket
			printWriter.println(message);   //String message is sent through to SparkNotify
			printWriter.println(contacts);  //String contacts is sent through to SparkNotify 
		}
		catch(Exception e){
			System.out.println(e);  //in case of error, the system catches itself and prints that error
		}
	}
	
	/**
	 * Reads text in from a file with a given path/name and returns that text as a String
	 * 
	 * @param path - the path/name of the file
	 * @return message - text from file as a string
	 */
	public String readAndReturn(String path){
		text = "";							//String text is created to be filled with incoming message
		try{
			  fstream = new FileInputStream(path);    //file input stream created
			  in = new DataInputStream(fstream);	//data input stream created
			  br = new BufferedReader(new InputStreamReader(in));	//buffered reader created
			  while ((line = br.readLine()) != null)   {	//while the read line is not null
				 text+=line;							//add this line to our message
			  }
			  in.close();								//when this process is complete, close the data input stream
		}catch (Exception e){
			  System.err.println("Error: " + e.getMessage());  //if this process fails, report the error to console
		}
		return text;										//message is returned to the call
	}

	/**
	 * Creates SNAlert instance and sends it two arguements from the command line, the paths to both the message file and the contact file
	 * @param args
	 */
	public static void main(String[] args){
		//C:\\Users\\cmullins\\workspace\\ServerTest\\mess.txt     where the message is currently stored
		//C:\\Users\\cmullins\\workspace\\ServerTest\\conns.txt     where the contacts are currently stored
		try{
			SNAlert snalert = new SNAlert(args[0],args[1]);				//must run this command with two strings, path to message and path to contacts
		}																//contacts is a list of contact names separated by commas
		catch(Exception e){												//(ex:  cmullins,mnovak,jsmith) no spaces, or @jabber. just names and commas.
			System.err.println("Error: " + e.getMessage());			//catch the error to keep the connection live
		}
	}
}

