import java.util.Arrays;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.InputMismatchException;

public class Main {

  public static void main(String[] args) {

    Room[] uniRooms = new Room[9];
    ArrayList<Bookings> confirmedBookings = new ArrayList<Bookings>();

    // adding all rooms to array
    Room taff = new Room("Taff", 8);
    Room llangorse = new Room("Llangorse", 24);
    Room penYFan = new Room("Pen Y Fan", 70);
    Room usk = new Room("Usk", 8);
    Room bala = new Room("Bala", 24);
    Room cadairIdris = new Room("Cadair Idris", 70);
    Room wye = new Room("Wye", 8);
    Room gower = new Room("Gower", 24);
    Room snowdon = new Room("Snowdon", 70);

    uniRooms[0] = taff;
    uniRooms[1] = llangorse;
    uniRooms[2] = penYFan;
    uniRooms[3] = usk;
    uniRooms[4] = bala;
    uniRooms[5] = cadairIdris;
    uniRooms[6] = wye;
    uniRooms[7] = gower;
    uniRooms[8] = snowdon;

    boolean mainMenu = true;
    Scanner input = new Scanner(System.in);

    try {
      while (mainMenu) {
        System.out.println("Welcome to the University Room Booking System. Please choose from the options below.");
        System.out.println("1: Book A New Room.");
        System.out.println("2: View all Rooms.");
        System.out.println("3: Find bookings from customer name.");

        int userInput = input.nextInt();
        if (userInput >= 1 && userInput <= 3) {
          switch (userInput) {
          case 1:
            Bookings.createBooking(uniRooms, confirmedBookings);
            // System.out.println(confirmedBookings);
            break;
          case 2:
            Room.viewAllRooms(uniRooms);
            break;
          case 3:
            Bookings.returnBookings(confirmedBookings);
          } //  add break and default with comment this default will never happen
        } else {
          System.out.println("Sorry, that input is not recognised");
        }
        System.out.println("Would you like to chose another option? Type 1 for Yes and 2 for No");
        int nextInput = input.nextInt();
        if (nextInput == 1) {
          mainMenu = true;
        }
        if (nextInput == 2) {
          System.out.println("Thankyou.Goodbye");
          mainMenu = false;
        } else {
          System.out.println("Nope");
        }

      }
    } catch (InputMismatchException e) {
      System.out.println("Error");

    }
  }

}
