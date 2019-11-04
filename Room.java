import java.util.Arrays;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class Room {

  private String roomName;
  private int capacity;

  //Room constructor
  public Room(String roomName, int capacity) {
    this.roomName = roomName;
    this.capacity = capacity;
  }

  public String getRoomName() {
    return roomName;
  }

  public int getCapacity() {
    return capacity;
  }

  public String toString() {
    return "Room Name: " + roomName + " Capacity: " + capacity;
  }

  // Method to print array of all uni rooms - method is called from Main.java
  public static void viewAllRooms(Room[] roomArray) {
    int x;
    for (x = 0; x < roomArray.length; x++) {
      System.out.println("Room Name: " + roomArray[x].getRoomName() + " Capacity: " + roomArray[x].getCapacity() + ".");
    }
  }

  }
