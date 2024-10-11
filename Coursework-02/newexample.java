import java.util.*;

class Example {
    public static void main(String args[]) {

        // Your ASCII art and other print statements remain the same

        Scanner input = new Scanner(System.in);

        String date;
        System.out.print("\t\t\t\t\tEnter Date: ");
        date = input.nextLine(); // Changed to nextLine() for multi-word input

        String location;
        System.out.print("\t\t\t\t\tLocation: ");
        location = input.nextLine(); // Changed to nextLine() for multi-word input

        // Your movie options and time options remain the same

        int movieNum;
        System.out.print("\t\t\t\t     Enter Movie Number: ");
        movieNum = input.nextInt();

        // Clear the buffer
        input.nextLine(); // This is important to clear the newline character left by nextInt()

        String hallNumber = "";

        System.out.print("\n\n");

        // Your ASCII art for time selection remains the same

        String time;
        System.out.print("\t\t\t\t     Enter Time: ");
        time = input.nextLine(); // Changed to nextLine() for multi-word input

        // Your ASCII art for customer details remains the same

        String cusName;
        System.out.print("                          Name : ");
        cusName = input.nextLine(); // Changed to nextLine() for multi-word input

        String contact;
        System.out.print("                          Phone Number : ");
        contact = input.nextLine(); // Changed to nextLine() for multi-word input

        String userType;
        System.out.print("                          Child OR Parent : ");
        userType = input.nextLine(); // Changed to nextLine() for multi-word input

        int numOfTickets;
        System.out.print("                          Number of Tickets : ");
        numOfTickets = input.nextInt();

        double totalAmount;
        totalAmount = numOfTickets * 90;

        double tax;
        tax = totalAmount * 0.08;

        double totalWithTax;
        totalWithTax = tax + totalAmount;

        if (movieNum == 1) {
            hallNumber = "Hall 1";
        } else if (movieNum == 2) {
            hallNumber = "Hall 2";
        } else if (movieNum == 3) {
            hallNumber = "Hall 3";
        } else if (movieNum == 4) {
            hallNumber = "Hall 4";
        } else {
            System.out.println("Invalid Input");
            return;
        }

        // Your final ASCII art and ticket summary print statements remain the same
    }
}
