import java.util.Arrays;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class Room {

  private String roomName;
  private int capacity;

  public Room(String nameOfRoom, int roomCapacity) {
    this.roomName = nameOfRoom;
    this.capacity = roomCapacity;
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

  // Method to print array of all uni rooms.
  public static void viewAllRooms(Room[] roomArray) {
    int x;
    for (x = 0; x < roomArray.length; x++) {
      System.out.println("Room Name: " + roomArray[x].getRoomName() + " Capacity: " + roomArray[x].getCapacity() + ".");
    }
  }

  }
