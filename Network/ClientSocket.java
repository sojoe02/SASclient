/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Network;
import  java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ClassNotFoundException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientSocket {
    Socket socket;
 

	public SendObject sendToServer(SendObject sObject) 	{
       try{
            //
            // Create a connection to the server socket on the server application
            //
            	InetAddress host = InetAddress.getLocalHost();
             socket = new Socket(host.getHostName(), 7777);

            //
            // Send a message to the client application
            //
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(sObject);

            //
            // Read and display the response message sent by server application
            //
	    ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
           sObject = (SendObject) ois.readObject();
           



	            ois.close();
            oos.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
       return sObject;
    }
    }