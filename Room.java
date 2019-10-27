import java.util.Arrays;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class Room {

private String roomName;
private int capacity;


public Room(String nameOfRoom, int roomCapacity){
this.roomName = nameOfRoom;
this.capacity = roomCapacity;
}

public String getRoomName(){
  return roomName;
}

public int getCapacity(){
  return capacity;
}

public String toString(){
  return "Room Name: " + roomName + " Capacity: " + capacity;
}

//Method to print array of all uni rooms.
public static void viewAllRooms(Room[] roomArray){
  int x;
  for(x=0; x < roomArray.length; x++){
    System.out.println("Room Name: " + roomArray[x].getRoomName() + " Capacity: " + roomArray[x].getCapacity() + ".");
  }
}

public static boolean isAvailable(String roomName, String requestedDate, String requestedTime, ArrayList<Bookings> bookingsArray){
  int x;
   for(x=0; x < bookingsArray.size(); x++){
     if (roomName.equals(bookingsArray.get(x).getRoomName()) && requestedDate.equals(bookingsArray.get(x).getDate()) && requestedTime.equals(bookingsArray.get(x).getTime())){
       return false;
     }
     }
     return true;
   }

public static void createBooking(Room[] uniRooms, ArrayList<Bookings> confirmedBookings){
int x;
Scanner input = new Scanner(System.in);
System.out.println("Please enter the date of your booking in 6 digit form. e.g. dd/mm/yy");
String requestedDate = input.next();
System.out.println("Please enter the time of your booking using 24hour clock eg 1300");
String requestedTime = input.next();
System.out.println("Please enter the number of people in your group (maximum 70)");
int requestedGroupSize = input.nextInt();
System.out.println("If we have rooms that meet your criteria they will be listed below.");
for (x=0; x < uniRooms.length; x++){
if((Room.isAvailable(uniRooms[x].getRoomName(), requestedDate, requestedTime, confirmedBookings)) && (requestedGroupSize <= uniRooms[x].getCapacity())){
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
    requestedRoomName = "LLangorse";
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
    requestedRoomName= "Wye";
    break;
    case "7":
    requestedRoomName = "Gower";
    break;
    case "8":
    requestedRoomName = "Snowdon";
  }
    System.out.println("Finally, please enter your full name in lowercase with no spaces.");
    String customerName = input.next();
Bookings newBooking = new Bookings(requestedRoomName, requestedDate, requestedTime, customerName, requestedGroupSize);
confirmedBookings.add(newBooking);
}
}
