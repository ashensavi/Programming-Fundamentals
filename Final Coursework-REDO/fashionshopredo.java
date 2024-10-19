import java.util.*;
class fashionshopredo {
    public static Scanner input = new Scanner(System.in);
    public static void main(String args[]){
        homePage();
    }

    public static void homePage(){

        System.out.println("===================Fashion SHOP===========================");
        System.out.println("\n [1] Place Order");
        System.out.println("\n [2] Search Customer");
        System.out.println("\n [3] Search Order");
        System.out.println("\n [4] View Reports");
        System.out.println("\n [5] Set Order Status");
        System.out.println("\n [6] Delete Order");
        System.out.print("Enter an option: ");
        int option = input.nextInt();

        switch (option) {
            case 1:
                placeOrder();
                break;
            case 2:
                searchCustomer();
            case 3:
                searchOrder();
                break;
            case 4:
                viewReports();
                break;
            case 5:
                setOrderStatus();
            case 6:
                deleteOrder();
                break;
            default:
                System.out.println("Invalid Input! Please Enter a valid option...");
        }

    }
}
