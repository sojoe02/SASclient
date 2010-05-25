/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Network;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Mats l
 */
public class SendObject implements Serializable{
   private  ArrayList<Integer> userInfo = new ArrayList<Integer>();
    ArrayList<String> ShipDates = new ArrayList<String>();
    ArrayList<String[]> availableShips;
    private int userID;
    private int containers;
    private String metodeChoose;
    private String startDest;
    private String endDest;
    private Date date;

  public SendObject (String metodeChoose, ArrayList<String[]> availableShips )   {
      this.availableShips = availableShips;
  }

    public SendObject(String startDest, String endDest, Date date, int containers, String metodeChoose) {
	this.startDest = startDest;
	this.endDest = endDest;
	this.date = date;
	this.containers = containers;
	this.metodeChoose = metodeChoose;
    }

    public SendObject(ArrayList<Integer> userInfo ) {
	this.userInfo = userInfo;
    }

 public SendObject(int userID, String metodeChoose)	{
     this.userID = userID;
     this.metodeChoose = metodeChoose;

 }
public ArrayList<String[]> getAvailableShips()	{
    return availableShips;
}

public ArrayList<Integer> getuserInfo()    {
    return userInfo;
}

public int getUserID()   {
    return userID;
}

public String getMetodeChoose()	{
    return metodeChoose;
}
public String getStartDest()	{
    return startDest;
}
public String getEndDest()	{
    return endDest;
}
public Date getDate()	{
    return date;
}

public int getContainers()	{
    return containers;
}

public void putShipDates (ArrayList ShipDates)   {
    this.ShipDates = ShipDates;
}

public ArrayList getShipDates()  {
    return ShipDates;
}
}

