package control;

import Network.*;
import java.util.ArrayList;
import java.util.Date;

public class CActioner {
    private ClientSocket cs;
    private SendObject sObject;
    private final String login = "login";
    private final String findShipDates = "findShipDates";
    private final String placeOrder = "placeOrder";

    public CActioner() throws Exception {
	cs = new ClientSocket();
    }

    //henter user og rettigheder
    public ArrayList<Integer> login(int userID) throws Exception {
	sObject = new SendObject(userID, login);
	sObject = cs.sendToServer(sObject);
	// returnere arraylist userInfo til presentationslaget
	return sObject.getUserInfo();
    }

    // findShipDates henter de skibsdatoer der overholder kundens ønsker.
    public ArrayList<String[]> findShipDates(String startDest, String endDest, Date date, int containers) throws Exception {
	sObject = new SendObject(startDest, endDest, date, containers, findShipDates);
	sObject = cs.sendToServer(sObject);
	// returnere arraylist availableships til presentaionslaget
	return sObject.getAvailableShips();
    }

    public void placeOrder(int userID, int shipID, int startSID, int endSID, int containers, String content) throws Exception {
	//opretter order i DB
	sObject = new SendObject(userID, shipID, startSID, endSID, containers, content, placeOrder);
	cs.sendToServer(sObject);
    }
}
