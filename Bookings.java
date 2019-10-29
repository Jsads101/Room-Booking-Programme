import java.util.Arrays;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Calendar;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Bookings {

private String room;
private String date;
private String time;
private String personName;
private int groupSize;
int x;

public String getRoomName(){
  return room;
}

public String getDate(){
  return date;
}

public String getTime(){
  return time;
}

public String getPersonName(){
  return personName;
}

public int getGroupSize(){
  return groupSize;

}


public Bookings(String roomName, String bookingDate, String bookingTime, String clientName, int clientGroupSize){
this.room = roomName;
this.date = bookingDate;
this.time = bookingTime;
this.personName = clientName;
this.groupSize = clientGroupSize;
}

//SECOND CONSTRUCTOR BECAUSE POTENTIAL BOOKING INSTANCES DONT HAVE ROOMNAME***********
public Bookings(String bookingDate, String bookingTime, String clientName, int clientGroupSize){
this.date = bookingDate;
this.time = bookingTime;
this.personName = clientName;
this.groupSize = clientGroupSize;
}


public String toString(){
    return "Room Name: " + room + ", Date: " + date + ", Time: " + time + ", Name of Customer: "
    + personName + ", Group Size: " + groupSize + ".";
   }

//METHOD TO RETURN BOOKINGS BY CUSTOMER NAME.
public static void returnBookings(ArrayList<Bookings> bookingArray){
  int x;
  boolean hasBooking = false;
  System.out.println("Please enter your surname below");
  Scanner input = new Scanner(System.in);
  String userInput = input.next();
  userInput = userInput.toLowerCase();
  System.out.println("If you have any bookings, they will be listed below:");
     for (x = 0; x < bookingArray.size(); x++){
       if (userInput.equals(bookingArray.get(x).getPersonName())){
            System.out.println("Date: " + bookingArray.get(x).getDate() + ", Time: "
            + bookingArray.get(x).getTime() + ", Room: " + bookingArray.get(x).getRoomName() + ".");
            hasBooking = true;
          }
        } if (hasBooking == false){
          System.out.println("Sorry, there are no bookings under that name");
 }
}
}










//METHOD TO COLLECT USERINPUT TO CREATE POTENTIAL BOOKING**************************  public static void createPotentialBooking(){

    /*Scanner input = new Scanner(System.in);
    DateFormat format = new SimpleDateFormat("dd/MM/yy");
    format.setLenient(false);
    System.out.println("Please enter the date of your booking in 6 digit form. e.g. dd/mm/yy");
    boolean dateCorrect = false;
    String userDate = null;
    while (!dateCorrect){
      try {
        userDate = input.next();
        format.parse(userDate);
        dateCorrect = true;
    } catch (ParseException e) {
        System.out.println("Date " + userDate + " is not valid according to " +
            ((SimpleDateFormat) format).toPattern() + " pattern. Please try again");
          }
        }
    DateFormat formatTime = new SimpleDateFormat("kkmm");
    formatTime.setLenient(false);
     System.out.println("Please enter the time of your booking using 24hour clock eg 1300");
     boolean timeCorrect = false;
  String userTime = null;
     while (!timeCorrect){
       try {
         userTime = input.next();
         formatTime.parse(userTime);
         timeCorrect = true;
     } catch (ParseException e) {
         System.out.println("Time " + userTime + " is not valid. Please try again using 24hour clock pattern e.g. 1300");
       }*/
