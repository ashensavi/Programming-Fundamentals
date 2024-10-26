import java.util.*;
class fashionshopredo {
    //Creating the arrays
    public static String[] orderIdArray = new String[0]; // using 0 as the number of elements becuase we dont know how many orders will be there
    public static String[] phoneNumberArray = new String[0];
    public static String[] sizeArray = new String[0];
    public static int[] qtyArray = new int[0];
    public static double[] AmountArray = new double[0];
    public static int[] statusArray = new int[0];
    
    //Constants
    public static final double XS = 600;
    public static final double S = 800;
    public static final double M = 900;
    public static final double L = 1000;
    public static final double XL = 1100;
    public static final double XXL = 1200;

    public static final int PROCCESSING = 0;
    public static final int DELIVERING = 1;
    public static final int DELIVERED = 2;

    public static Scanner input = new Scanner(System.in);
    public static void main(String args[]){
        homePage();
    }
    
    
    public final static void clearConsole() {  
        try { 
              final String os = System.getProperty("os.name");  
              if (os.contains("Windows")) { 
                  new ProcessBuilder("cmd", "/c", 
   "cls").inheritIO().start().waitFor(); 
              } else { 
                   System.out.print("\033[H\033[2J");  
                   System.out.flush(); 
                 } 
          } catch (final Exception e) { 
               e.printStackTrace(); 
               // Handle any exceptions. 
           } 
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

    public static boolean  validatePhoneNumber(String phoneNumber){
        if (phoneNumber.length()==10 && phoneNumber.charAt(0)=='0') {
            return true;
        }
        return false;
    }

    public static boolean validateQty(int qty){
        if(qty>0){
            return true;
        }
        return false;
    }

    public static void extendArrays(){
         //create temp arrays for size 1 more than orderIdArray length.
        String[] tempOrderIdArray = new String[orderIdArray.length+1];
        String[] tempPhoneNumberArray = new String[orderIdArray.length+1];
        String[] tempSizeArray = new String[orderIdArray.length+1];
        int[] tempQtyrArray = new int[orderIdArray.length+1];
        double[] tempAmountArray = new double[orderIdArray.length+1];
        int[] tempStatusArray = new int[orderIdArray.length+1];
       
        for(int i=0 ; i < orderIdArray.length; i++){
            tempOrderIdArray[i] = orderIdArray[i];
            tempPhoneNumberArray[i] = phoneNumberArray[i];
            tempSizeArray[i] = sizeArray[i];
            tempQtyrArray[i] = qtyArray[i];
            tempAmountArray[i] = AmountArray[i];
            tempStatusArray[i] = statusArray[i];
        }
        //Swapping the array reference
        orderIdArray = tempOrderIdArray;
        phoneNumberArray = tempPhoneNumberArray;
        sizeArray = tempSizeArray;
        qtyArray = tempQtyrArray;
        AmountArray = tempAmountArray;
        statusArray = tempStatusArray;
    }
    //=========PLACE ORDER=============
    public static void placeOrder(){
        L1:do {
            System.out.println("=============Place Order================");
            String orderId = generateId();
            System.out.println("\nEnter Order ID: "+orderId);
           String phoneNumber;
           L2: do{
                System.out.print("\nEnter Customer Phone Number: ");
                phoneNumber = input.next();
                boolean isValidPhoneNumber = validatePhoneNumber(phoneNumber);

                if(isValidPhoneNumber){
                    break L2;
                }
                System.out.println("Invalid Phone Number!...Try Again!");
                System.out.print("Do you want to enter phone number again? (Y/N)");
                char ch = input.next().charAt(0);
                if(ch == 'y' || ch == 'Y'){
                     // Move the cursor up five lines 
                     System.out.print("\033[6A"); 
                     // Clear the lines 
                     System.out.print("\033[0J");
                     continue L2;
                }else if(ch == 'n' || ch == 'N'){
                    clearConsole();
                    homePage();
                }
            }while(true);

            System.out.print("\nEnter T-Shirt Size(XS/S/M/L/XL/XXL): ");
            String size = input.next();

            int qty;
            L3:do{
                System.out.print("\nEnter QTY : ");
                qty = input.nextInt();

                boolean isValidQty = validateQty(qty);

                if(isValidQty){
                    break L3;
                }
                System.out.println("Invalid QTY!.Try Again...");
                System.out.print("Do you want to enter qty again? (Y/N)");
                char ch = input.next().charAt(0);
                if(ch == 'y' || ch == 'Y'){
                     // Move the cursor up five lines 
                     System.out.print("\033[6A"); 
                     // Clear the lines 
                     System.out.print("\033[0J");
                     continue L3;
                }else if(ch == 'n' || ch == 'N'){
                    clearConsole();
                    homePage();
                }
            }while(true);

            double amount = 0;
            switch(size.toUpperCase()){
                case "XS" :
                    amount = XS * qty;
                break;
                case "S" :
                    amount = S * qty;
                break;
                case "M" :
                    amount = M * qty;
                break;
                case "L":
                    amount = L * qty;
                break;
                case "XL":
                    amount = XL * qty;
                break;
                case "XXL":
                    amount = XXL * qty;
                    break;
            }
            System.out.println("\nAmount : "+amount);
            System.out.print("\nDo you want to place this order? (Y/N)");
            char ch = input.next().charAt(0);

            if (Character.toUpperCase(ch) == 'Y') {
                extendArrays();
                //Adding values to arrays
                orderIdArray[orderIdArray.length-1]=orderId;
                phoneNumberArray[phoneNumberArray.length-1] = phoneNumber;
                sizeArray[sizeArray.length-1] = size;
                qtyArray[qtyArray.length-1] = qty;
                AmountArray[AmountArray.length-1] = amount;
                statusArray[statusArray.length-1] = PROCCESSING;

                System.out.println("\nOrder Placed Successfuly!");


            }
            System.out.print("\nDo you want to place another order? (Y/N)");
            char choice = input.next().charAt(0);
            clearConsole();
            if(Character.toUpperCase(choice)=='Y'){
                continue L1;
            }else if(Character.toUpperCase(choice) == 'N'){
                homePage();
            }

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
