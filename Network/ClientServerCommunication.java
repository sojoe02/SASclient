package Network;

import java.io.*;	    // pakker til socket
import java.net.*;
import java.util.ArrayList;

import java.util.Date;

public class ClientServerCommunication {

    private String ipAddress = "localhost";
     //private final int port = 6789;
     private WriteRead wr;
    Socket getSocket;

        ServerSocket serversocket;
    SendObject sObject;
    ArrayList<String> ShipDates = new ArrayList<String>();

    public ClientServerCommunication() throws IOException	{
    
    
    }
public void setup() throws IOException {
 
    
}


    public void sendToServer(int port, SendObject sObject) throws Exception    {
		    Socket sendSocket = null;
		try {
	       sendSocket = new Socket(ipAddress, 6400);
	    System.out.println("\nClient is ready");
	    wr = new WriteRead(sendSocket);
	    // Sender objektet sendes
	    wr.writeToSocket(sObject);

	    sendSocket.close();


	} catch (IOException e) {
	    e.printStackTrace();
	}

    }

public SendObject getResponse(int port) throws Exception	{
    	serversocket = null;
	getSocket = null;
	serversocket = new ServerSocket(6701);
	System.out.println("\nTCPServer waiting for connection on port 6789");
	getSocket = serversocket.accept();
	System.out.println("\nTCPServer got a connection");
	wr = new WriteRead(getSocket);
	//Læser fra socket i sendObject
	sObject = wr.readFromSocket();
	getSocket.close();

	return sObject;

}

}
