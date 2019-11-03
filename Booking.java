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

public class Booking {

  private String room;
  private String date;
  private String time;
  private String personName;
  private int groupSize;
  int x;

  public String getRoomName() {
    return room;
  }

  public String getDate() {
    return date;
  }

  public String getTime() {
    return time;
  }

  public String getPersonName() {
    return personName;
  }

  public int getGroupSize() {
    return groupSize;

  }

  public Booking(String roomName, String bookingDate, String bookingTime, String clientName, int clientGroupSize) {
    this.room = roomName;
    this.date = bookingDate;
    this.time = bookingTime;
    this.personName = clientName;
    this.groupSize = clientGroupSize;
  }


  public String toString() {
    return "Room Name: " + room + ", Date: " + date + ", Time: " + time + ", Name of Customer: " + personName
        + ", Group Size: " + groupSize + ".";
  }

  // METHOD TO RETURN BOOKINGS BY CUSTOMER NAME.
  public static void returnBookings(ArrayList<Booking> bookingArray) {
    int x;
    boolean hasBooking = false;
    System.out.println("Please enter your full name in lower case with no spaces");
    Scanner input = new Scanner(System.in);
    String userInput = input.next();
    userInput = userInput.toLowerCase();
    System.out.println("If you have any bookings, they will be listed below:");
    for (x = 0; x < bookingArray.size(); x++) {
      if (userInput.equals(bookingArray.get(x).getPersonName())) {
        System.out.println("Date: " + bookingArray.get(x).getDate() + ", Time: " + bookingArray.get(x).getTime()
            + ", Room: " + bookingArray.get(x).getRoomName() + ".");
        hasBooking = true;
      }
    }
    if (hasBooking == false) {
      System.out.println("Sorry, there are no bookings under that name");
    }
  }

  //Helper Method for creatBooking Method which returns whetehr a specific room is avilable at a specific time and date. 
  public static boolean isAvailable(String roomName, String requestedDate, String requestedTime,
      ArrayList<Booking> bookingArray) {
    int x;
    for (x = 0; x < bookingArray.size(); x++) {
      if (roomName.equals(bookingArray.get(x).getRoomName()) && requestedDate.equals(bookingArray.get(x).getDate())
          && requestedTime.equals(bookingArray.get(x).getTime())) {
        return false;
      }
    }
    return true;
  }

  //Method which takes in user criteria, provides a list of available rooms and allows user to chose a room to make a booking. 
  //Booking is then added to confirmedBooking ArrayList for temporary storage. 
  public static void createBooking(Room[] uniRooms, ArrayList<Booking> confirmedBookings) {
    int x;
    boolean takeRequirements = true;
    Scanner input = new Scanner(System.in);
    while (takeRequirements) {
      System.out.println("Please enter the date of your booking in 6 digit form. e.g. dd/mm/yy");
      String requestedDate = input.next();
    System.out.println("Please enter the time of your booking using 24hour clock eg 1300");
      String requestedTime = input.next();
      System.out.println("Please enter the number of people in your group (maximum 70)");
      int requestedGroupSize = input.nextInt();

      if (requestedGroupSize > 70) {
        System.out.println("Sorry, we dont have any rooms that are big enough for your group size.");
        takeRequirements = false;
      } else if (requestedGroupSize <= 70) {
        System.out.println("If we have rooms that meet your criteria they will be listed below.");
        for (x = 0; x < uniRooms.length; x++) {

          if ((Booking.isAvailable(uniRooms[x].getRoomName(), requestedDate, requestedTime, confirmedBookings))
              && (requestedGroupSize <= uniRooms[x].getCapacity())) {
            System.out.println("Room Number: " + x + " " + uniRooms[x].getRoomName() + " is Available.");
          }
        }
        System.out.println("Please type in the room number you would like to book:");
        String requestedRoomName = input.next();
        switch (requestedRoomName) {
        case "0":
          requestedRoomName = "Taff";
          break;
        case "1":
          requestedRoomName = "Llangorse";
          break;
        case "2":
          requestedRoomName = "Pen Y Fan";
          break;
        case "3":
          requestedRoomName = "Usk";
          break;
        case "4":
          requestedRoomName = "Bala";
          break;
        case "5":
          requestedRoomName = "Cadair Idris";
          break;
        case "6":
          requestedRoomName = "Wye";
          break;
        case "7":
          requestedRoomName = "Gower";
          break;
        case "8":
          requestedRoomName = "Snowdon";
        }
        System.out.println("Finally, please enter your full name in lowercase with no spaces.");
        String customerName = input.next();
        customerName = customerName.toLowerCase();
        Booking newBooking = new Booking(requestedRoomName, requestedDate, requestedTime, customerName,
            requestedGroupSize);
        confirmedBookings.add(newBooking);
        System.out.println("Thankyou for your booking. Your booking details are confirmed below:");
        System.out.println(newBooking.toString());
        takeRequirements = false;
        
      }
    } //**********Need to close scanner at end of method
  }
}



/*
 * Scanner input = new Scanner(System.in); DateFormat format = new
 * SimpleDateFormat("dd/MM/yy"); format.setLenient(false); System.out.
 * println("Please enter the date of your booking in 6 digit form. e.g. dd/mm/yy"
 * ); boolean dateCorrect = false; String userDate = null; while (!dateCorrect){
 * try { userDate = input.next(); format.parse(userDate); dateCorrect = true; }
 * catch (ParseException e) { System.out.println("Date " + userDate +
 * " is not valid according to " + ((SimpleDateFormat) format).toPattern() +
 * " pattern. Please try again"); } } DateFormat formatTime = new
 * SimpleDateFormat("kkmm"); formatTime.setLenient(false); System.out.
 * println("Please enter the time of your booking using 24hour clock eg 1300");
 * boolean timeCorrect = false; String userTime = null; while (!timeCorrect){
 * try { userTime = input.next(); formatTime.parse(userTime); timeCorrect =
 * true; } catch (ParseException e) { System.out.println("Time " + userTime +
 * " is not valid. Please try again using 24hour clock pattern e.g. 1300"); }
 */
