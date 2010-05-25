package Network;

import java.io.*;	    // pakker til socket
import java.net.*;
import java.util.ArrayList;

import java.util.Date;

public class ClientServerCommunication {

    private String ipAddress = "localhost";
    private final int port = 6789;
     private WriteRead wr;
    Socket socket;
        ServerSocket serversocket;
    SendObject sObject;
    ArrayList<String> ShipDates = new ArrayList<String>();

    public ClientServerCommunication()	{

    }



    public void sendToServer(SendObject sObject) throws Exception    {

		try {
	    socket = new Socket(ipAddress, port);
	    System.out.println("\nClient is ready");
	    wr = new WriteRead(socket);
	    // Sender objektet sendes
	    wr.writeToSocket(sObject);

	    socket.close();

	} catch (IOException e) {
	    e.printStackTrace();
	}

    }

public SendObject getResponse() throws Exception	{
    	serversocket = new ServerSocket(6431);

	System.out.println("\nTCPServer waiting for connection on port 6789");
	socket = serversocket.accept();
	System.out.println("\nTCPServer got a connection");
	wr = new WriteRead(socket);
	//Læser fra socket i sendObject
	sObject = wr.readFromSocket();
	socket.close();

	return sObject;

}

}
