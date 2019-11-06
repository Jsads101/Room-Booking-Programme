import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.LocalTime;

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

  // Booking Constructor
  public Booking(String room, String date, String time, String personName, int groupSize) {
    this.room = room;
    this.date = date;
    this.time = time;
    this.personName = personName;
    this.groupSize = groupSize;
  }

  // Overiding the toString() method for printing out Booking objects.
  public String toString() {
    return "Room Name: " + room + ", Date: " + date + ", Time: " + time + ", Name of Customer: " + personName
            + ", Group Size: " + groupSize + ".";
  }


  // METHOD TO RETURN BOOKINGS BY CUSTOMER NAME - method called from Main BOoking Programme
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


  // Helper Method (for createBooking Method) which returns whether a specific room is avilable at a specific time and date.
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

  /*
   * Method which takes in user criteria, provides a list of available rooms and allows user to chose a room to make
   * a booking. Booking is then added to confirmedBooking ArrayList for temporary storage.
   */
  public static void createBooking(Room[] uniRooms, ArrayList<Booking> confirmedBookings) {
    //declaring all variables needed for method.
    int x;
    Scanner input = new Scanner(System.in);
    String requestedDate = null;
    String requestedTime = null;
    int requestedGroupSize = 0;
    boolean takeFinalRequirements = true;
    boolean dateIsValid = false;
    boolean timeIsValid = false;
    boolean groupSizeIsValid = false;
    ArrayList<String> availableRooms = new ArrayList<String>();


      // Taking date requirement from customer.
      while (!dateIsValid) {
        System.out.println("Please enter a valid date in the format dd/mm/yyyy");
        requestedDate = input.nextLine();

        //checking date is entered correctly and catching parse exceptions.
        try {
          DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
          LocalDate localDate = LocalDate.parse(requestedDate, dtf);
          LocalDate todaysDate = LocalDate.now();
          if (localDate.isBefore(todaysDate)) {
            System.out.println("You can only make bookings for dates from tomorrow. Please try again.");
            dateIsValid = false;
          } else if (requestedDate.equals(dtf.format(localDate))) {
            System.out.println(requestedDate + " is a valid date");
            dateIsValid = true;
          }
        } catch (DateTimeParseException ex) {
          System.out.println("Date is not valid. Please try again");
          dateIsValid = false;
        }
      }

      // Taking time requirement from customer.
      while (!timeIsValid) {
        System.out.println("Our rooms can be booked for one hour,starting on the hour.");
        System.out.println("Please enter the hour you want your meeting to start, using 24 hour format eg 1300");
        requestedTime = input.nextLine();

        // Checking time is entered correctly and catching DateTimeParse exceptions:
        try {
          DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HHmm");
          LocalTime localTime = LocalTime.parse(requestedTime, dtf);
          //checking if requestedTime starts on the hour.
          if (localTime.getMinute() > 00) {
            System.out.println("That time is not valid because we can only start bookings on the hour");
            timeIsValid = false;
          } else if (requestedTime.equals(dtf.format(localTime))) {
            System.out.println(requestedTime + " is a valid time");
            timeIsValid = true;
          }
        } catch (DateTimeParseException ex) {
          System.out.println("Time is not valid. Please try again");
          timeIsValid = false;
        }
      }

      // Taking group size requirement from customer.
        System.out.println("Please enter the number of people in your group (maximum 70)");
        requestedGroupSize = input.nextInt();

        if (requestedGroupSize > 70){
          System.out.println("Sorry, we do not have any rooms with a large enough capacity for your group size");
          takeFinalRequirements = false;
        }
        //Checking availablity and capacity before printing list of available rooms to customer.
        else if (requestedGroupSize <= 70){
          for (x = 0; x < uniRooms.length; x++) {
            if ((Booking.isAvailable(uniRooms[x].getRoomName(), requestedDate, requestedTime, confirmedBookings))
                    && (requestedGroupSize <= uniRooms[x].getCapacity())) {
              System.out.println("Room Number: " + x + " " + uniRooms[x].getRoomName() + " is Available.");
              availableRooms.add(uniRooms[x].getRoomName());
            }
            //Telling customer if all suitable rooms have already been booked.
          }if (availableRooms.isEmpty()) {
            System.out.println("We're sorry, we have no rooms available which fit your criteria");
            takeFinalRequirements = false;
          }
        }

      // Taking final requirements from customer- which room and customer name.
      while (takeFinalRequirements) {
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

        // Creates new Booking object from customer requirements and prints out to customer.
        Booking newBooking = new Booking(requestedRoomName, requestedDate, requestedTime, customerName,
                requestedGroupSize);
        confirmedBookings.add(newBooking); // Adds new Booking object to confirmedBookings array.
        System.out.println("Thankyou for your booking. Your booking details are confirmed below:");
        System.out.println(newBooking.toString());
        takeFinalRequirements = false;
      }
  }
}


