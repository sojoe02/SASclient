package control;

import Network.*;
import java.util.ArrayList;
import java.util.Date;

public class CActioner {

    private  ClientServerCommunication csc;
	private SendObject sObject;
	private final String login = "login";
	private final String findShipDates = "findShipDates";

    public CActioner() throws Exception {
	csc = new ClientServerCommunication();

    }

//    public ArrayList login(int userID) {
//	return broker.login(userID);
//    }

    //henter user og rettigheder
    public ArrayList<Integer> login(int userID) throws Exception {
	
	sObject = new SendObject(userID, login);
	csc.sendToServer(sObject);
	sObject = csc.getResponse();
	System.out.println(Integer.toString(sObject.getuserInfo().get(0)));
	System.out.println(Integer.toString(sObject.getuserInfo().get(1)));
	System.out.println(Integer.toString(sObject.getuserInfo().get(2)));
	return sObject.getuserInfo();
/*
	ArrayList<Integer> userInfo = new ArrayList<Integer>();
	userInfo.add(1);
	    userInfo.add(0);
	    userInfo.add(0);
	return userInfo;
 *
 */
    }

    // findShipDates henter de skibsdatoer der overholder kundens ønsker.
    public ArrayList<String[]> findShipDates(String startDest, String endDest, Date date, int containers) throws Exception {

	/* Resultet af de fundne datoer sendes op til kunden i
	 presentationsalget i form af et arraylist.
	 */
		System.out.println("her til");
	sObject = new SendObject(startDest, endDest, date, containers, findShipDates);
	csc.sendToServer(sObject);
	sObject = csc.getResponse();

	System.out.println(sObject.getAvailableShips().get(0));
	System.out.println(sObject.getAvailableShips().get(1));
	return sObject.getAvailableShips();
    }

    //opret order
    public void placeOrder (int userID, int shipID, int startSID, int endSID, int containers, String content) throws Exception {
	//opretter order i DB
	broker.placeOrder(userID, shipID, startSID, endSID, containers, content);
    }
}
