import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Main {

  public static void main(String[] args) {

    Room[] uniRooms = new Room[9]; //Array for list of rooms.
    ArrayList<Booking> confirmedBookings = new ArrayList<Booking>(); // Array for list of successful bookings for temporary storage.
  

    // Creating room objects and adding all rooms to uniRooms array.
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


//Main Menu
    boolean mainMenu = true;
    Scanner input = new Scanner(System.in);
//try-catch added to catch potential exceptions thrown by incorrect input (i.e. not an int)
    try {
      while (mainMenu) {
        System.out.println("Welcome to the University Room Booking System. Please choose from the options below.");
        System.out.println("1: Book A New Room.");
        System.out.println("2: View all Rooms.");
        System.out.println("3: Find bookings from customer name.");

        int userInput = input.nextInt();

        //Checking input is valid according to Main Menu options
        if (userInput >= 1 && userInput <= 4) {
          switch (userInput) {
          case 1:
          //Runs method to create a new booking
            Booking.createBooking(uniRooms, confirmedBookings);
            break;
          case 2:
          //Runs method to view list of all rooms.
            Room.viewAllRooms(uniRooms);
            break;
          case 3:
          //Runs method to search bookings by name and return bookings.
            Booking.returnBookings(confirmedBookings);
            break;
          }
        } else {
          System.out.println("Sorry, that input is not recognised");
        } 
        //Submenu
        System.out.println("Would you like to chose another option? Type 1 for Yes and 2 for No");
        int nextInput = input.nextInt();
        if (nextInput == 1) {
          mainMenu = true;
        }
        else if (nextInput == 2) {
          System.out.println("Thankyou.Exiting Programme.Goodbye");
          mainMenu = false;
        }
      }
      //Catching Mismatch Exception i.e. if user inputs something other than an int
    } catch (InputMismatchException e) {
      System.out.println("That is not a recognised input. Exiting programme. ");

    }
  }

}
