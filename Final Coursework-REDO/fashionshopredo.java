import java.util.*;
class fashionshopredo {
    public static String[] orderIdArray = new String[0]; // using 0 as the number of elements becuase we dont know how many orders will be there
    public static String[] phoneNumberArray = new String[0];
    public static String[] sizeArray = new String[0];
    public static int[] qtyArray = new int[0];
    public static double[] AmountArray = new double[0];
    public static int[] statusArray = new int[0];

    public static Scanner input = new Scanner(System.in);
    public static void main(String args[]){
        homePage();
    }

    //===========Generate Order Id====================
    public static String generateId(){
        int id1;
        if (orderIdArray.length>0){
            id1=Integer.parseInt(orderIdArray[orderIdArray.length-1].split("[#]")[1]);
            id1++;
        }else{
            return "ODR#00001";
        }
        return String.format("ODR#%05d",id1);
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
    //=========PLACE ORDER=============
    public static void placeOrder(){
        do {
            System.out.println("=============Place Order================");
            System.out.println("\nEnter Order ID: ");
        } while (true);
    }


    public static void searchCustomer(){

    }


    public static void searchOrder(){

    }


    public static void viewReports(){

    }


    public static void setOrderStatus(){

    }


    public static void deleteOrder(){

    }


}
