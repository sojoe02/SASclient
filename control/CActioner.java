package control;

import Network.*;
import java.util.ArrayList;
import java.util.Date;

public class CActioner {

    private  ClientSocket cs;
    
	private SendObject sObject;
	private final String login = "login";
	private final String findShipDates = "findShipDates";
	private final String placeOrder = "placeOrder";

    public CActioner() throws Exception {
	cs = new ClientSocket();
	

    }

//    public ArrayList login(int userID) {
//	return broker.login(userID);
//    }

    //henter user og rettigheder
    public ArrayList<Integer> login(int userID) throws Exception {
	//cs.setup();
	sObject = new SendObject(userID, login);
	sObject = cs.sendToServer(sObject);

	
	System.out.println(Integer.toString(sObject.getUserInfo().get(0)));
	System.out.println(Integer.toString(sObject.getUserInfo().get(1)));
	System.out.println(Integer.toString(sObject.getUserInfo().get(2)));
	return sObject.getUserInfo();

    }

    // findShipDates henter de skibsdatoer der overholder kundens ønsker.
    public ArrayList<String[]> findShipDates(String startDest, String endDest, Date date, int containers) throws Exception {

	/* Resultet af de fundne datoer sendes op til kunden i
	 presentationsalget i form af et arraylist.
	 */
		
	sObject = new SendObject(startDest, endDest, date, containers, findShipDates);
	sObject = cs.sendToServer(sObject);



	System.out.println(sObject.getAvailableShips().get(0));
	System.out.println(sObject.getAvailableShips().get(1));
	return sObject.getAvailableShips();
    }

    //opret order
    public void placeOrder (int userID, int shipID, int startSID, int endSID, int containers, String content) throws Exception {
	//opretter order i DB
	sObject = new SendObject(userID, shipID, startSID, endSID, containers, content, placeOrder);
	cs.sendToServer(sObject);
	System.out.println("Ved placeorder ved kontrol");
    }
}
