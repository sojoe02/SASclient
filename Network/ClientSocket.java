package Network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientSocket {

    private Socket socket;
    private final int port = 7777;
// Sender metoden til sas, hvor responset fra sas returneres til kontrolklassen
    public SendObject sendToServer(SendObject sObject) {
	try {
	    // Skabe forbindelse til server med port og ipadress
	    InetAddress host = InetAddress.getLocalHost();
	    socket = new Socket(host.getHostName(), port);

	    //Sender sObject til serveren
	    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
	    oos.writeObject(sObject);

	    // Læser responset fra server applikationen
	    ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
	    sObject = (SendObject) ois.readObject();

	    // Lukker stream
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
