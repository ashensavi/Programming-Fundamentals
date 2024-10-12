import java.util.*;

public class FashionShop {

    public static int[] orders = new int[0];
    public static String[] customers = new String[0];
    public static String[] tsizes = new String[0];
    public static int[] qty = new int[0];

    public static Scanner input = new Scanner(System.in);

    public static boolean yesNoChoice(String text) {

        System.out.print("\n\n" + text);
        char choice = input.next().toLowerCase().charAt(0);

        return choice == 'y' ? true : false;

    }

    public static int getIntegerLength(int num) {
       
        int length = 0;
        
        do {
            length++;
        } while ((num/=10) != 0);


        return length;

        
    }

    public static String validatePhoneNumber() {


        System.out.print("Enter Customer Phone Number : ");
        String phoneNumber = input.next(); //length??
        
        if (phoneNumber.length() == 10 && phoneNumber.charAt(0) == '0' ) {
           
            return phoneNumber;
        }

        System.out.println("\n\tInvalid phone number! Try again.");

        boolean choice = yesNoChoice("Do you want to enter phone number again (y/n) : ");


        if (choice) {

            System.out.print("\033[6A");
            System.out.print("\033[0J");

            return validatePhoneNumber();

        } 

        return "none";


    }

    public static String validateTSize() {

        System.out.print("Enter T-Shirt Size (XS/S/M/L/XL/XXL) : ");
        String tSize = input.next();

        switch (tSize.toLowerCase()) {
            case "xs":
            case "s":
            case "m"://?
            case "l":
            case "xl":
            case "xxl":
                break;
        
            default:
                
                System.out.print("\033[0A");
                System.out.print("\033[0J");

                return validateTSize();
            
        }

        return tSize;

    }

    public static int validateQty() {

        System.out.print("Enter Quantity : ");
        int quantity = input.nextInt();

        if (quantity > 0) return quantity;

        
        System.out.print("\033[0A");
        System.out.print("\033[0J");

        return validateQty();//?
    }

    public static double calculateAmount(String tSize, int quantity) {

        double unit_price = 0;

        switch (tSize.toLowerCase()) {
            case "xs":
                unit_price = 600;
                break;

            case "s":
                unit_price = 800;
                break;

            case "m":
                unit_price = 900;
                break;

            case "l":
                unit_price = 1000;
                break;

            case "xl":
                unit_price = 1100;
                break;

            case "xxl":
                unit_price = 1200;
                break;
            
        }
        
        return unit_price * quantity;
    }

    public static String createOrderString(int orderID) {
        
        int length = getIntegerLength(orderID);

        String orderString = "";
        while (orderString.length() != 5 - length) {
            orderString += "0";
            
        }

        orderString += Integer.toString(orderID);

        return "ODR#"+orderString;
    }

    public static void createOrder(String tSize, int quantity) {
        
        // orders
        int[] temp_o = new int[orders.length+1];


        for (int i = 0; i < orders.length; i++) {
            //System.out.println("orders.length : " + orders.length + " i : " + i);
            temp_o[i] = orders[i];

        }

   
        temp_o[temp_o.length-1] = temp_o.length;
        orders = temp_o;

        //System.out.println(Arrays.toString(orders));

        // Tsizes
        String[] temp_s = new String[tsizes.length+1];

        for (int i = 0; i < tsizes.length; i++) {
            temp_s[i] = tsizes[i];
        }

        tsizes = temp_s;
        tsizes[tsizes.length - 1] = tSize;

        // qty
        int[] temp_qty = new int[qty.length+1];

        for (int i = 0; i < qty.length; i++) {
            temp_qty[i] = qty[i];
        }

        qty = temp_qty;
        qty[qty.length-1] = quantity;



    }

   public static void createCustomer(String phoneNumber) {//??
        String[] temp = new String[customers.length+1];

        for (int i = 0; i < customers.length; i++) {
            temp[i] = customers[i];
        }

        customers = temp;
        customers[customers.length-1] = phoneNumber;

   }

    public static void placeOrder() {
 
        clearConsole();
System.out.println("         _____  _                   ____          _");           
System.out.println(" |  __ \\| |                 / __ \\        | |");          
System.out.println(" | |__) | | __ _  ___ ___  | |  | |_ __ __| | ___ _ __"); 
System.out.println(" |  ___/| |/ _` |/ __/ _ \\ | |  | | '__/ _` |/ _ \\ '__|");
System.out.println(" | |    | | (_| | (_|  __/ | |__| | | | (_| |  __/ |");   
System.out.println(" |_|    |_|\\__,_|\\___\\___|  \\____/|_|  \\__,_|\\___|_|"); 
System.out.println();
System.out.println();  

        System.out.println("Order ID : " + createOrderString(orders.length+1));

        String phoneNumber = validatePhoneNumber();
        
        if (phoneNumber == "none") return;

        String tSize = validateTSize();

        int qty = validateQty();

        System.out.println("Amount : " + calculateAmount(tSize, qty));

        boolean choice = yesNoChoice("Do you want to place this order? (y/n)");

        if (choice) {
            
            createOrder(tSize, qty);

            createCustomer(phoneNumber);

            System.out.println("\n\n\tOrder placed!");
        }

        choice = yesNoChoice("Do you want to place another order? (y/n)");

        if (choice) {
            placeOrder();
        }else{
			choice = yesNoChoice("Do you want to go to main menu? (y/n)");
			if(choice){
				homePage();
				}
			}
        
    }
    
    public static void searchCustomer(){
		clearConsole();
System.out.println("		   _____                     _        _____          _");                            
System.out.println("  / ____|                   | |      / ____|        | |");                           
System.out.println(" | (___   ___  __ _ _ __ ___| |__   | |    _   _ ___| |_ ___  _ __ ___   ___ _ __"); 
System.out.println("  \\___ \\ / _ \\/ _` | '__/ __| '_ \\  | |   | | | / __| __/ _ \\| '_ ` _ \\ / _ \\ '__|");
System.out.println("  ____) |  __/ (_| | | | (__| | | | | |___| |_| \\__ \\ || (_) | | | | | |  __/ |");   
System.out.println(" |_____/ \\___|\\__,_|_|  \\___|_| |_|  \\_____\\__,_|___/\\__\\___/|_| |_| |_|\\___|_|"); 

System.out.println();  
System.out.println();  
   
    
    
    String phoneNumber = validatePhoneNumber();
    
 
    int[] data = new int[6]; 
    
    boolean orderFound = false; 
    

    for (int j = 0; j < customers.length; j++) {
        if (phoneNumber.equals(customers[j])) {
            orderFound = true;  
            
         
            int index = -1;
            switch(tsizes[j].toLowerCase()){
                case "xs":
                    index = 0;
                    break;
                case "s":
                    index = 1;
                    break;
                case "m":
                    index = 2;
                    break;
                case "l":
                    index = 3;
                    break;
                case "xl":
                    index = 4;
                    break;
                case "xxl":
                    index = 5;
                    break;
            }
            
           
            if (index != -1) {
                data[index] += qty[j];
            }
        }
    }
    
    if (!orderFound) {
        System.out.println("No orders found for this customer.");
        return;
    }
    

    int xsAmount = 600 * data[0];
    int sAmount = 800 * data[1];
    int mAmount = 900 * data[2];
    int lAmount = 1000 * data[3];
    int xlAmount = 1100 * data[4];
    int xxlAmount = 1200 * data[5];
    
    int totalAmount = xsAmount+sAmount+mAmount+lAmount+xlAmount+xxlAmount;
    

    System.out.println("+--------------+------+------------------------+");
    System.out.println("|    Size      | Qty  |         Amount         |");
    System.out.println("+--------------+------+------------------------+");
    System.out.printf("|     XS       |  %d   |  %d           |\n", data[0], xsAmount);
    System.out.printf("|     S        |  %d   |  %d           |\n", data[1], sAmount);
    System.out.printf("|     M        |  %d   |  %d           |\n", data[2], mAmount);
    System.out.printf("|     L        |  %d   |  %d           |\n", data[3], lAmount);
    System.out.printf("|     XL       |  %d   |  %d           |\n", data[4], xlAmount);
    System.out.printf("|     XXL      |  %d   |  %d           |\n", data[5], xxlAmount);
    System.out.println("+--------------+------+------------------------+");
    System.out.println("+   Total Amount                      "+totalAmount+"|");
    System.out.println("+--------------+------+------------------------+");
    
     boolean choice = yesNoChoice("Do you want to go to the main menu? (y/n)");
        if (choice) {
            homePage();
        }
    } 
       



	public static String searchOrder() {
		clearConsole();
		System.out.println("      _____                     _        ____          _");           
		System.out.println("  / ____|                   | |      / __ \\        | |");          
		System.out.println(" | (___   ___  __ _ _ __ ___| |__   | |  | |_ __ __| | ___ _ __"); 
		System.out.println("  \\___ \\ / _ \\/ _` | '__/ __| '_ \\  | |  | | '__/ _` |/ _ \\ '__|");
		System.out.println("  ____) |  __/ (_| | | | (__| | | | | |__| | | | (_| |  __/ |");   
		System.out.println(" |_____/ \\___|\\__,_|_|  \\___|_| |_|  \\____/|_|  \\__,_|\\___|_|");
		System.out.println();
		System.out.println();

    System.out.print("Enter order ID : ");
    String enteredOrderId = input.next();
    System.out.println();
    System.out.println();
    
    boolean orderFound = false;
    for (int i = 0; i < orders.length; i++) {
        if (enteredOrderId.toUpperCase().equals(createOrderString(orders[i]))) {
            System.out.println("Phone number  :   " + customers[i]);
            System.out.println("Quantity  :     " + qty[i]);
            System.out.println("Amount  :      " +calculateAmount(tsizes[i], qty[i]));
          
            orderFound = true;
            break; 
           
        }
       
       
        
    }
     
    if (!orderFound) {
        System.out.println("Order ID not found.");
       
    }
        boolean choice = yesNoChoice("Do you want to go to the main menu? (y/n)");
        if (choice) {
            homePage();
        }
   return enteredOrderId;
   
   
}

    

	public static int searchOrderById(String enteredOrderId){
		    for (int i = 0; i < orders.length; i++) {
        if (enteredOrderId.equals(createOrderString(orders[i]))) {
            return i; 
        }
    }
    return -1; 
	}
	
	public static void deleteOrder() {
    System.out.println("          		 		  _____       _      _          ____  _____     _");           
    System.out.println("          		  |  __ \\     | |    | |        / __ \\|  __ \\   | |");           
    System.out.println("          		  | |  | | ___| | ___| |_ ___  | |  | | |__) |__| | ___ _ __");  
    System.out.println("          		  | |  | |/ _ \\ |/ _ \\ __/ _ \\ | |  | |  _  // _` |/ _ \\ '__|");
    System.out.println("          		  | |__| |  __/ |  __/ ||  __/ | |__| | | \\ \\ (_| |  __/ |");   
    System.out.println("          		  |_____/ \\___|_|\\___|\\__\\___|  \\____/|_|  \\_\\__,_|\\___|_|");   

    System.out.print("Enter order ID : ");
    String enteredOrderId = input.next();


    int index = searchOrderById(enteredOrderId.toUpperCase());
    if (index == -1) {
        System.out.println("Order not found.");
        return;
    }

  
    System.out.println("Order Details:");
    System.out.println("Phone number  : " + customers[index]);
    System.out.println("T-Shirt Size  : " + tsizes[index]);
    System.out.println("Quantity      : " + qty[index]);
    System.out.println("Amount        : " + calculateAmount(tsizes[index], qty[index]));

   
    boolean choice = yesNoChoice("Do you want to delete this order? (y/n)");

    if (choice) {
        removeOrder(index);
        System.out.println("Order deleted successfully.");
        
        choice = yesNoChoice("Do you want to go to the main menu? (y/n)");
        if (choice) {
            homePage();
        }
    } 
       
    
}

        

		
	public static void removeOrder(int index) {
    int[] tempOrderArray = new int[orders.length - 1];
    String[] tempCustomersArray = new String[customers.length - 1];
    String[] tempTsizesArray = new String[tsizes.length - 1];
    int[] tempQtyArray = new int[qty.length - 1];

    for (int i = 0, j = 0; i < orders.length; i++) {
        if (i == index) continue; 
        tempOrderArray[j] = orders[i];
        tempCustomersArray[j] = customers[i];
        tempTsizesArray[j] = tsizes[i];
        tempQtyArray[j] = qty[i];
        j++;
    }
    


    orders = tempOrderArray;
    customers = tempCustomersArray;
    tsizes = tempTsizesArray;
    qty = tempQtyArray;
}

    public static void viewReports(){
		clearConsole();
				String str = "\r\n" +
   "    _____           " +
   "            _       " +
   "\r\n" +
   "   |  __ \\         " +
   "            | |     " +
   " \r\n" +
   "   | |__) |___ _ __ " +
   "  ___  _ __| |_ ___ " +
   "\r\n" +
   "   |  _  // _ \\ \'_" +
   " \\ / _ \\| \'__| __" +
   "/ __|\r\n" +
   "   | | \\ \\  __/ |_" +
   ") | (_) | |  | |_\\_" +
   "_ \\\r\n" +
   "   |_|  \\_\\___| ._" +
   "_/ \\___/|_|   \\__|" +
   "___/\r\n" +
   "              | |   " +
   "                    " +
   "\r\n" +
   "              |_|   " +
   "                    " +
   "\r\n";
   
		System.out.println(str);
		System.out.println();
		System.out.println();
		System.out.printf("%40s","[1] Customer Reports\n");
		System.out.println();
		System.out.printf("%36s","[2] Item Reports\n");
		System.out.println();
		System.out.printf("%37s","[3] Order Reports\n");
		
		System.out.println();
		System.out.println();
		System.out.print("Input Option :");
		
		int decision = input.nextInt();
		
		switch(decision){
			case 1:
		clearConsole();
			   String str1 = "\r\n" +
   "     _____          " +
   "_                   " +
   "           _____    " +
   "                   _" +
   "       \r\n" +
   "    / ____|        |" +
   " |                  " +
   "          |  __ \\  " +
   "                   |" +
   " |      \r\n" +
   "   | |    _   _ ___|" +
   " |_ ___  _ __ ___   " +
   "___ _ __  | |__) |__" +
   "_ _ __   ___  _ __| " +
   "|_ ___ \r\n" +
   "   | |   | | | / __|" +
   " __/ _ \\| \'_ ` _ " +
   "\\ / _ \\ \'__| |  _" +
   "  // _ \\ \'_ \\ / _" +
   " \\| \'__| __/ __|\r" +
   "\n" +
   "   | |___| |_| \\__ " +
   "\\ || (_) | | | | | " +
   "|  __/ |    | | \\ " +
   "\\  __/ |_) | (_) | " +
   "|  | |_\\__ \\\r\n" +
   "    \\_____\\__,_|__" +
   "_/\\__\\___/|_| |_| " +
   "|_|\\___|_|    |_|  " +
   "\\_\\___| .__/ \\___" +
   "/|_|   \\__|___/\r\n" +
   "                    " +
   "                    " +
   "                    " +
   " | |                " +
   "       \r\n" +
   "                    " +
   "                    " +
   "                    " +
   " |_|                " +
   "       \r\n";

	   System.out.println(str1);
	   System.out.println("--------------------------------------------------------------------------------\n\n");	 
		System.out.println();
		System.out.println();
		System.out.printf("%40s","[1] Best In Customers\n");
		System.out.println();
		System.out.printf("%37s","[2] View Customers\n");
		System.out.println();
		System.out.printf("%42s","[3] All Customer Report\n");
		
		System.out.println();
		System.out.println();
		System.out.print("Input Option :");
		
		int choice = input.nextInt();
		
		switch(choice){
			case 1:
				String[][] sortedData=getBestCustomerData();
				sort(sortedData,2);
				printSortedData(sortedData);
			break;
			case 2:
				viewCustomerData();
			break;
			case 3:
				viewCustomerDataBySize();
			break;
			}
		break;
		  case 2:
			clearConsole();
			String str2 = "\r\n" +
   "    _____ _         " +
   "          _____     " +
   "                  _ " +
   "  \r\n" +
   "   |_   _| |        " +
   "         |  __ \\   " +
   "                  | " +
   "|  \r\n" +
   "     | | | |_ ___ _ " +
   "__ ___   | |__) |___" +
   " _ __   ___  _ __| |" +
   "_ \r\n" +
   "     | | | __/ _ \\ " +
   "\'_ ` _ \\  |  _  //" +
   " _ \\ \'_ \\ / _ \\|" +
   " \'__| __|\r\n" +
   "    _| |_| ||  __/ |" +
   " | | | | | | \\ \\  " +
   "__/ |_) | (_) | |  |" +
   " |_ \r\n" +
   "   |_____|\\__\\___|" +
   "_| |_| |_| |_|  \\_" +
   "\\___| .__/ \\___/|_" +
   "|   \\__|\r\n" +
   "                    " +
   "                    " +
   "| |                 " +
   "  \r\n" +
   "                    " +
   "                    " +
   "|_|                 " +
   "  \r\n\r";
		   System.out.println(str2);
	   System.out.println("  --------------------------------------------------------------------------------\n\n");
		System.out.println();
		System.out.println();
		System.out.printf("%67s","[1] Best Selling Categories Sorted by QTY\n");
		System.out.println();
		System.out.printf("%70s","[2] Best Selling Categories Sorted by Amount\n");
	

		
		System.out.println();
		System.out.println();
		System.out.print("Input Option :");
		
		int choice1 = input.nextInt();
		
		switch(choice1){
			case 1:
				sortItemsByQty();
			break;
			
			case 2:
				sortItemsByAmount();
			break;
			}
			break;
			case 3:
		clearConsole();
			String str3 = "\r\n" +
   "     ____          _" +
   "             _____  " +
   "                    " +
   " _       \r\n" +
   "    / __ \\        |" +
   " |           |  __ " +
   "\\                  " +
   "   | |      \r\n" +
   "   | |  | |_ __ __| " +
   "| ___ _ __  | |__) |" +
   "___ _ __   ___  _ __" +
   "| |_ ___ \r\n" +
   "   | |  | | \'__/ _`" +
   " |/ _ \\ \'__| |  _ " +
   " // _ \\ \'_ \\ / _ " +
   "\\| \'__| __/ __|\r" +
   "\n" +
   "   | |__| | | | (_| " +
   "|  __/ |    | | \\ " +
   "\\  __/ |_) | (_) | " +
   "|  | |_\\__ \\\r\n" +
   "    \\____/|_|  \\__" +
   ",_|\\___|_|    |_|  " +
   "\\_\\___| .__/ \\___" +
   "/|_|   \\__|___/\r\n" +
   "                    " +
   "                    " +
   "   | |              " +
   "         \r\n" +
   "                    " +
   "                    " +
   "   |_|              " +
   "         \r\n\r\n";
   
   System.out.println(str3);
	   System.out.println("--------------------------------------------------------------------------------\n\n");	
		System.out.println();
		System.out.printf("%67s","[1] All Orders\n");
		System.out.println();
		System.out.printf("%70s","[2] Orders by Amount\n");
	

		
		System.out.println();
		System.out.println();
		System.out.print("Input Option :");
		
		int choice2 = input.nextInt();
		
		switch(choice2){
			case 1:
				allOrdersByOrderId();
			break;
            case 2:
                OrdersByAmount();
            break;
			}
			break;
			}
		}

public static String[][] getBestCustomerData() {
    String[] temp_customer = new String[0];
    String[][] data = new String[1][3]; // Initial header row

    data[0] = new String[] { "Customer ID", "All Qty", "Amount" };

    int index = 1;

    for (int i = 0; i < customers.length; i++) {
        if (!isExists(temp_customer, customers[i])) {
            temp_customer = extendArray(temp_customer, customers[i]);

            int[] quantity_data = getQuantityData(customers[i]);

            data = extendArray(data, 3);

            data[index][0] = customers[i];
            data[index][1] = String.format("%d", getSum(quantity_data));
            data[index][2] = String.format("%.2f", getTotalAmount(customers[i]));

            index++;
        }
    }

    return data;
}
	


	public static boolean isExists(String[] array, String value) {
    for (String element : array) {
        if (element.equals(value)) {
            return true;
        }
    }
    return false;
}

	public static String[] extendArray(String[] array, String value) {
    String[] newArray = new String[array.length + 1];
    for (int i = 0; i < array.length; i++) {
        newArray[i] = array[i];
    }
    newArray[array.length] = value;
    return newArray;
}
	public static String[][] extendArray(String[][] array, int columns) {
    String[][] newArray = new String[array.length + 1][columns];
    for (int i = 0; i < array.length; i++) {
        newArray[i] = array[i];
    }
    return newArray;
}

	public static int[] getQuantityData(String customer) {
    int[] quantities = new int[0];
    for (int i = 0; i < customers.length; i++) {
        if (customers[i].equals(customer)) {
            quantities = extendArray(quantities, qty[i]);
        }
    }
    return quantities;
}

	public static int[] extendArray(int[] array, int value) {
    int[] newArray = new int[array.length + 1];
    for (int i = 0; i < array.length; i++) {
        newArray[i] = array[i];
    }
    newArray[array.length] = value;
    return newArray;
}


	public static double getTotalAmount(String customer) {
    double total = 0;
    for (int i = 0; i < customers.length; i++) {
        if (customers[i].equals(customer)) {
            total += calculateAmount(tsizes[i], qty[i]);
        }
    }
    return total;
}


	public static int getSum(int[] array) {
    int sum = 0;
    for (int num : array) {
        sum += num;
    }
    return sum;
}

	public static void sort(String[][] data,int sort_index){
		for(int i=data.length-1;i>0;i--){
			for (int j = 1; j < i; j++){
				
				double amount_1 = Double.parseDouble(data[j][sort_index]);
				double amount_2 = Double.parseDouble(data[j+1][sort_index]);
				
				if (amount_1 < amount_2)
				{
					String[] temp = data[j];
					data[j] = data[j+1];
					data[j+1] = temp;
				}
				
			}
			
			
		}
		
}

	public static void printSortedData(String[][] data) {
		clearConsole();
				 String str = "\r\n" +
   "    ____            " +
   "_     _____         " +
   " _____          _   " +
   "                    " +
   "         \r\n" +
   "   |  _ \\          " +
   "| |   |_   _|       " +
   " / ____|        | | " +
   "                    " +
   "          \r\n" +
   "   | |_) | ___  ___|" +
   " |_    | |  _ __   |" +
   " |    _   _ ___| |_ " +
   "___  _ __ ___   ___ " +
   "_ __ ___ \r\n" +
   "   |  _ < / _ \\/ __" +
   "| __|   | | | \'_ \\" +
   "  | |   | | | / __| " +
   "__/ _ \\| \'_ ` _ \\" +
   " / _ \\ \'__/ __|\r" +
   "\n" +
   "   | |_) |  __/\\__ " +
   "\\ |_   _| |_| | | |" +
   " | |___| |_| \\__ \\" +
   " || (_) | | | | | | " +
   " __/ |  \\__ \\\r\n" +
   "   |____/ \\___||___" +
   "/\\__| |_____|_| |_|" +
   "  \\_____\\__,_|___/" +
   "\\__\\___/|_| |_| |_" +
   "|\\___|_|  |___/\r\n" +
   "                    " +
   "                    " +
   "                    " +
   "                    " +
   "         \r\n" +
   "                    " +
   "                    " +
   "                    " +
   "                    " +
   "         \r";
   
   System.out.println(str);
   System.out.println("   ---------------------------------------------------------------------------------------\n\n\n");
    System.out.printf("%-15s %-10s %-10s%n", "Customer ID", "All Qty", "Amount"); // Print header row

    System.out.println("------------------------------------------"); // Divider line

    for (int i = 1; i < data.length; i++) { // Start from 1 to skip the header
        System.out.printf("%-15s %-10s %-10s%n", data[i][0], data[i][1], data[i][2]);
    }
     System.out.print("To access the main menu, please enter 0 : ");
   int choice = input.nextInt();
    if (choice==0) {
		clearConsole();
        homePage();
    }else{
		System.out.println("Invalid input..Please enter again!");
		viewCustomerData();
		}
}

//-----------------------------------------------------------------------------------------------------
	public static void viewCustomerData() {
    clearConsole();
    		String str = "\r\n" +
   "   __      ___      " +
   "            _____   " +
   "       _            " +
   "                    " +
   "\r\n" +
   "   \\ \\    / (_)   " +
   "             / ____|" +
   "        | |         " +
   "                    " +
   "  \r\n" +
   "    \\ \\  / / _  __" +
   "___      __ | |    _" +
   "   _ ___| |_ ___  _ " +
   "__ ___   ___ _ __ __" +
   "_ \r\n" +
   "     \\ \\/ / | |/ _" +
   " \\ \\ /\\ / / | |  " +
   " | | | / __| __/ _ " +
   "\\| \'_ ` _ \\ / _ " +
   "\\ \'__/ __|\r\n" +
   "      \\  /  | |  __" +
   "/\\ V  V /  | |___| " +
   "|_| \\__ \\ || (_) |" +
   " | | | | |  __/ |  " +
   "\\__ \\\r\n" +
   "       \\/   |_|\\__" +
   "_| \\_/\\_/    \\___" +
   "__\\__,_|___/\\__\\_" +
   "__/|_| |_| |_|\\___|" +
   "_|  |___/\r\n" +
   "                    " +
   "                    " +
   "                    " +
   "                    " +
   "\r\n" +
   "                    " +
   "                    " +
   "                    " +
   "                    " +
   "\r\n";
   System.out.println(str);
	   System.out.println("------------------------------------------------------------------------------------------\n\n\n");
    System.out.println();
    System.out.println();
    System.out.printf("%-15s %-10s %-10s%n", "Customer ID", "All Qty", "Amount"); // Print header row
    System.out.println("------------------------------------------"); // Divider line

    String[] temp_customer = new String[0];

    for (int i = 0; i < customers.length; i++) {
        if (!isExists(temp_customer, customers[i])) {
            temp_customer = extendArray(temp_customer, customers[i]);

            int[] quantity_data = getQuantityData(customers[i]);
            double totalAmount = getTotalAmount(customers[i]);

            System.out.printf("%-15s %-10d %-10.2f%n", customers[i], getSum(quantity_data), totalAmount);
        }
    }

   System.out.println();
   System.out.print("To access the main menu, please enter 0 : ");
   int choice = input.nextInt();
    if (choice==0) {
		clearConsole();
        homePage();
    }else{
		System.out.println("Invalid input..Please enter again!");
		viewCustomerData();
		}
}


//--------------------------------------------------------------------------------------------

	public static void viewCustomerDataBySize() {
    clearConsole();
    	
	String str = "\r\n" +
   "            _ _    _" +
   "____          _     " +
   "                    " +
   "     _____          " +
   "             _      " +
   " \r\n" +
   "      /\\   | | |  /" +
   " ____|        | |   " +
   "                    " +
   "     |  __ \\       " +
   "              | |   " +
   "   \r\n" +
   "     /  \\  | | | | " +
   "|    _   _ ___| |_ _" +
   "__  _ __ ___   ___ _" +
   " __  | |__) |___ _ _" +
   "_   ___  _ __| |_ __" +
   "_ \r\n" +
   "    / /\\ \\ | | | |" +
   " |   | | | / __| __/" +
   " _ \\| \'_ ` _ \\ / " +
   "_ \\ \'__| |  _  // " +
   "_ \\ \'_ \\ / _ \\| " +
   "\'__| __/ __|\r\n" +
   "   / ____ \\| | | | " +
   "|___| |_| \\__ \\ ||" +
   " (_) | | | | | |  __" +
   "/ |    | | \\ \\  __" +
   "/ |_) | (_) | |  | |" +
   "_\\__ \\\r\n" +
   "  /_/    \\_\\_|_|  " +
   "\\_____\\__,_|___/\\" +
   "__\\___/|_| |_| |_|" +
   "\\___|_|    |_|  \\_" +
   "\\___| .__/ \\___/|_" +
   "|   \\__|___/\r\n" +
   "                    " +
   "                    " +
   "                    " +
   "               | |  " +
   "                    " +
   " \r\n" +
   "                    " +
   "                    " +
   "                    " +
   "               |_|  " +
   "                    " +
   " \r\n\r\n" +
   "                    " +
   "                    " +
   "                    " +
   "  \r";
	
	
	  System.out.println(str);
	   System.out.println("    ---------------------------------------------------------------------------\n\n\n");
	
  
    System.out.println();
    System.out.println();
    System.out.printf("%-15s %-10s %-10s %-10s %-10s %-10s %-10s %-10s%n", "Customer ID", "XS", "S", "M", "L", "XL", "XXL", "Total"); // Print header row
    System.out.println("---------------------------------------------------------------------------------------------------------"); // Divider line

    String[] temp_customer = new String[0];

    for (int i = 0; i < customers.length; i++) {
        if (!isExists(temp_customer, customers[i])) {
            temp_customer = extendArray(temp_customer, customers[i]);

            // Array to store quantities by size
            int[] sizeQty = new int[6]; // For sizes XS, S, M, L, XL, XXL

            // Iterate through orders to calculate quantities by size
            for (int j = 0; j < customers.length; j++) {
                if (customers[j].equals(customers[i])) {
                    int index = getSizeIndex(tsizes[j]);
                    if (index != -1) {
                        sizeQty[index] += qty[j];
                    }
                }
            }

            // Calculate total amount for this customer
            double totalAmount = 0;
            for (int k = 0; k < sizeQty.length; k++) {
                totalAmount += calculateAmount(getSizeString(k), sizeQty[k]);
            }

            // Print customer data
            System.out.printf("%-15s %-10d %-10d %-10d %-10d %-10d %-10d %-10.2f%n", 
                customers[i], 
                sizeQty[0], sizeQty[1], sizeQty[2], 
                sizeQty[3], sizeQty[4], sizeQty[5], 
                totalAmount);
        }
    }

    System.out.println();
   System.out.print("To access the main menu, please enter 0 : ");
   int choice = input.nextInt();
    if (choice==0) {
		clearConsole();
        homePage();
    }else{
		System.out.println("Invalid input..Please enter again!");
		viewCustomerDataBySize();
		}
}

	private static int getSizeIndex(String size) {
    switch (size.toLowerCase()) {
        case "xs":
            return 0;
        case "s":
            return 1;
        case "m":
            return 2;
        case "l":
            return 3;
        case "xl":
            return 4;
        case "xxl":
            return 5;
        default:
            return -1; // Invalid size
    }
}

private static String getSizeString(int index) {
    switch (index) {
        case 0:
            return "XS";
        case 1:
            return "S";
        case 2:
            return "M";
        case 3:
            return "L";
        case 4:
            return "XL";
        case 5:
            return "XXL";
        default:
            return ""; // Should not reach here
    }
}

	public static void sortItemsByQty() {
    // Array to store total quantities by size (XS, S, M, L, XL, XXL)
    int[] totalQtyBySize = new int[6];
    double[] totalAmountBySize = new double[6];

    // Iterate through each customer and accumulate quantities and amounts by size
    for (int i = 0; i < customers.length; i++) {
        int sizeIndex = getSizeIndex(tsizes[i]);
        if (sizeIndex != -1) {
            totalQtyBySize[sizeIndex] += qty[i]; // Accumulate quantity for this size
            totalAmountBySize[sizeIndex] += calculateAmount(tsizes[i], qty[i]); // Accumulate total amount for this size
        }
    }

    // Sort by quantity (descending order)
    for (int i = 0; i < totalQtyBySize.length - 1; i++) {
        for (int j = 0; j < totalQtyBySize.length - i - 1; j++) {
            if (totalQtyBySize[j] < totalQtyBySize[j + 1]) {
                // Swap quantities
                int tempQty = totalQtyBySize[j];
                totalQtyBySize[j] = totalQtyBySize[j + 1];
                totalQtyBySize[j + 1] = tempQty;

                // Swap amounts
                double tempAmount = totalAmountBySize[j];
                totalAmountBySize[j] = totalAmountBySize[j + 1];
                totalAmountBySize[j + 1] = tempAmount;
            }
        }
    }

    // Print table header
    clearConsole();
    String str = "\r\n" +
   "     _____          " +
   "  _           _   __" +
   "__           ____ __" +
   "_______     __ \r\n" +
   "    / ____|         " +
   " | |         | | |  " +
   "_ \\         / __ \\" +
   "__   __\\ \\   / / " +
   "\r\n" +
   "   | (___   ___  _ _" +
   "_| |_ ___  __| | | |" +
   "_) |_   _  | |  | | " +
   "| |   \\ \\_/ /  \r" +
   "\n" +
   "    \\___ \\ / _ \\|" +
   " \'__| __/ _ \\/ _` " +
   "| |  _ <| | | | | | " +
   " | | | |    \\   /  " +
   " \r\n" +
   "    ____) | (_) | | " +
   " | ||  __/ (_| | | |" +
   "_) | |_| | | |__| | " +
   "| |     | |    \r\n" +
   "   |_____/ \\___/|_|" +
   "   \\__\\___|\\__,_|" +
   " |____/ \\__, |  \\_" +
   "__\\_\\ |_|     |_| " +
   "   \r\n" +
   "                    " +
   "                    " +
   "     __/ |          " +
   "               \r\n" +
   "                    " +
   "                    " +
   "    |___/           " +
   "               \r\n" +
   "\r";
   
   		   System.out.println(str);
	   System.out.println("    --------------------------------------------------------------------------------\n\n");
    System.out.printf("%-10s %-10s %-10s%n", "Size", "Qty", "Total Amount");
    System.out.println("-----------------------------------------------------------------------------------------");

    // Display data for each size
    for (int i = 0; i < totalQtyBySize.length; i++) {
        if (totalQtyBySize[i] > 0) { // Only show sizes with quantities
            System.out.printf("%-10s %-10d %-10.2f%n", 
                getSizeString(i), // Size (XS, S, M, L, XL, XXL)
                totalQtyBySize[i], // Total quantity for this size
                totalAmountBySize[i] // Total amount for this size
            );
        }
    }
	 System.out.println();
   System.out.print("To access the main menu, please enter 0 : ");
   int choice = input.nextInt();
    if (choice==0) {
		clearConsole();
        homePage();
    }else{
		System.out.println("Invalid input..Please enter again!");
		sortItemsByQty();
		}
}

	
	
	public static void sortItemsByAmount() {
    // Array to store total quantities by size (XS, S, M, L, XL, XXL)
    int[] totalQtyBySize = new int[6];
    double[] totalAmountBySize = new double[6];

    // Iterate through each customer and accumulate quantities and amounts by size
    for (int i = 0; i < customers.length; i++) {
        int sizeIndex = getSizeIndex(tsizes[i]);
        if (sizeIndex != -1) {
            totalQtyBySize[sizeIndex] += qty[i]; // Accumulate quantity for this size
            totalAmountBySize[sizeIndex] += calculateAmount(tsizes[i], qty[i]); // Accumulate total amount for this size
        }
    }

    // Sort by total amount (descending order)
    for (int i = 0; i < totalAmountBySize.length - 1; i++) {
        for (int j = 0; j < totalAmountBySize.length - i - 1; j++) {
            if (totalAmountBySize[j] < totalAmountBySize[j + 1]) {
                // Swap amounts
                double tempAmount = totalAmountBySize[j];
                totalAmountBySize[j] = totalAmountBySize[j + 1];
                totalAmountBySize[j + 1] = tempAmount;

                // Swap quantities accordingly
                int tempQty = totalQtyBySize[j];
                totalQtyBySize[j] = totalQtyBySize[j + 1];
                totalQtyBySize[j + 1] = tempQty;
            }
        }
    }

    // Print table header
String str = "\r\n" +
   "     _____          " +
   "  _           _   __" +
   "__                  " +
   "                    " +
   "         _   \r\n" +
   "    / ____|         " +
   " | |         | | |  " +
   "_ \\            /\\ " +
   "                    " +
   "          | |  \r\n" +
   "   | (___   ___  _ _" +
   "_| |_ ___  __| | | |" +
   "_) |_   _     /  \\ " +
   "  _ __ ___   ___  _ " +
   "  _ _ __ | |_ \r\n" +
   "    \\___ \\ / _ \\|" +
   " \'__| __/ _ \\/ _` " +
   "| |  _ <| | | |   / " +
   "/\\ \\ | \'_ ` _ \\ " +
   "/ _ \\| | | | \'_ \\" +
   "| __|\r\n" +
   "    ____) | (_) | | " +
   " | ||  __/ (_| | | |" +
   "_) | |_| |  / ____ " +
   "\\| | | | | | (_) | " +
   "|_| | | | | |_ \r\n" +
   "   |_____/ \\___/|_|" +
   "   \\__\\___|\\__,_|" +
   " |____/ \\__, | /_/ " +
   "   \\_\\_| |_| |_|\\" +
   "___/ \\__,_|_| |_|\\" +
   "__|\r\n" +
   "                    " +
   "                    " +
   "     __/ |          " +
   "                    " +
   "             \r\n" +
   "                    " +
   "                    " +
   "    |___/           " +
   "                    " +
   "             \r";

    System.out.println(str);
    System.out.println("    --------------------------------------------------------------------------------\n\n");
    System.out.println();
    System.out.printf("%-10s %-10s %-10s%n", "Size", "Qty", "Total Amount");
    System.out.println("-----------------------------------------------------------------------------------------");

    // Display data for each size
    for (int i = 0; i < totalAmountBySize.length; i++) {
        if (totalQtyBySize[i] > 0) { // Only show sizes with quantities
            System.out.printf("%-10s %-10d %-10.2f%n", 
                getSizeString(i), // Size (XS, S, M, L, XL, XXL)
                totalQtyBySize[i], // Total quantity for this size
                totalAmountBySize[i] // Total amount for this size
            );
        }
    }
    System.out.println();
   System.out.print("To access the main menu, please enter 0 : ");
   int choice = input.nextInt();
    if (choice==0) {
		clearConsole();
        homePage();
    }else{
		System.out.println("Invalid input..Please enter again!");
		sortItemsByAmount();
		}
}

public static void allOrdersByOrderId() {
    // Create an array to store the order data, including formatted order ID, customer ID, size, quantity, and amount
    int numOrders = orders.length; // Assuming orderIds array holds the order IDs
    String[][] orderData = new String[numOrders][5]; // 5 columns: Order ID, Customer ID, Size, Qty, Amount

    // Populate the array with order data
    for (int i = 0; i < numOrders; i++) {
        orderData[i][0] = createOrderString(orders[i]); // Formatted Order ID
        orderData[i][1] = customers[i]; // Customer ID
        orderData[i][2] = tsizes[i]; // Size
        orderData[i][3] = String.valueOf(qty[i]); // Qty
        orderData[i][4] = String.format("%.2f", calculateAmount(tsizes[i], qty[i])); // Amount
    }

    // Sort the order data by Order ID in descending order using bubble sort
    for (int i = 0; i < numOrders - 1; i++) {
        for (int j = 0; j < numOrders - i - 1; j++) {
            if (Integer.parseInt(orderData[j][0].substring(4)) < Integer.parseInt(orderData[j + 1][0].substring(4))) {
                // Swap the rows if current order ID is smaller than the next one
                String[] temp = orderData[j];
                orderData[j] = orderData[j + 1];
                orderData[j + 1] = temp;
            }
        }
    }

    // Print table header
    clearConsole();
    String str = "\r\n" +
   "   __      ___      " +
   "            ____    " +
   "      _             " +
   "  \r\n" +
   "   \\ \\    / (_)   " +
   "             / __ \\" +
   "        | |         " +
   "     \r\n" +
   "    \\ \\  / / _  __" +
   "___      __ | |  | |" +
   "_ __ __| | ___ _ __ " +
   "___ \r\n" +
   "     \\ \\/ / | |/ _" +
   " \\ \\ /\\ / / | |  " +
   "| | \'__/ _` |/ _ \\" +
   " \'__/ __|\r\n" +
   "      \\  /  | |  __" +
   "/\\ V  V /  | |__| |" +
   " | | (_| |  __/ |  " +
   "\\__ \\\r\n" +
   "       \\/   |_|\\__" +
   "_| \\_/\\_/    \\___" +
   "_/|_|  \\__,_|\\___|" +
   "_|  |___/\r\n" +
   "                    " +
   "                    " +
   "                    " +
   "  \r\n" +
   "                    " +
   "                    " +
   "                    " +
   "  \r\n\r";
	
	  System.out.println(str);
	   System.out.println("    -----------------------------------------------------------------------------------\n\n");	
    System.out.printf("%-10s %-15s %-10s %-10s %-10s%n", "Order ID", "Customer ID", "Size", "Qty", "Amount");
    System.out.println("-----------------------------------------------------------------------------------------");

    // Display the sorted order data
    for (int i = 0; i < numOrders; i++) {
        System.out.printf("%-10s %-15s %-10s %-10s %-10s%n", 
            orderData[i][0], // Formatted Order ID
            orderData[i][1], // Customer ID
            orderData[i][2], // Size
            orderData[i][3], // Quantity
            orderData[i][4]  // Amount
        );
    }
    System.out.println();
    System.out.print("To access the main menu, please enter 0 : ");
    int choice = input.nextInt();
     if (choice==0) {
         clearConsole();
         homePage();
     }else{
         System.out.println("Invalid input..Please enter again!");
         sortItemsByAmount();
         }
}

public static void OrdersByAmount() {
    // Create an array to store the order data, including formatted order ID, customer ID, size, quantity, and amount
    int numOrders = orders.length; // Assuming orderIds array holds the order IDs
    String[][] orderData = new String[numOrders][5]; // 5 columns: Order ID, Customer ID, Size, Qty, Amount

    // Populate the array with order data
    for (int i = 0; i < numOrders; i++) {
        orderData[i][0] = createOrderString(orders[i]); // Formatted Order ID
        orderData[i][1] = customers[i]; // Customer ID
        orderData[i][2] = tsizes[i]; // Size
        orderData[i][3] = String.valueOf(qty[i]); // Qty
        orderData[i][4] = String.format("%.2f", calculateAmount(tsizes[i], qty[i])); // Amount
    }

    // Sort the order data by Amount in descending order using bubble sort
    for (int i = 0; i < numOrders - 1; i++) {
        for (int j = 0; j < numOrders - i - 1; j++) {
            if (Double.parseDouble(orderData[j][4]) < Double.parseDouble(orderData[j + 1][4])) {
                // Swap the rows if current amount is smaller than the next one
                String[] temp = orderData[j];
                orderData[j] = orderData[j + 1];
                orderData[j + 1] = temp;
            }
        }
    }

    // Print table header
    clearConsole();
    String str = "\r\n" +
   "     ____          _" +
   "                 ___" +
   "_                   " +
   "                    " +
   "        _   \r\n" +
   "    / __ \\        |" +
   " |               |  " +
   "_ \\            /\\ " +
   "                    " +
   "          | |  \r\n" +
   "   | |  | |_ __ __| " +
   "| ___ _ __ ___  | |_" +
   ") |_   _     /  \\  " +
   " _ __ ___   ___  _  " +
   " _ _ __ | |_ \r\n" +
   "   | |  | | \'__/ _`" +
   " |/ _ \\ \'__/ __| |" +
   "  _ <| | | |   / /\\" +
   " \\ | \'_ ` _ \\ / _" +
   " \\| | | | \'_ \\| _" +
   "_|\r\n" +
   "   | |__| | | | (_| " +
   "|  __/ |  \\__ \\ | " +
   "|_) | |_| |  / ____ " +
   "\\| | | | | | (_) | " +
   "|_| | | | | |_ \r\n" +
   "    \\____/|_|  \\__" +
   ",_|\\___|_|  |___/ |" +
   "____/ \\__, | /_/   " +
   " \\_\\_| |_| |_|\\__" +
   "_/ \\__,_|_| |_|\\__" +
   "|\r\n" +
   "                    " +
   "                    " +
   "    __/ |           " +
   "                    " +
   "            \r\n" +
   "                    " +
   "                    " +
   "   |___/            " +
   "                    " +
   "            \r\n\r\n";
	
	  System.out.println(str);
	   System.out.println("-------------------------------------------------------------------------------------------------------\n\n");
    System.out.printf("%-10s %-15s %-10s %-10s %-10s%n", "Order ID", "Customer ID", "Size", "Qty", "Amount");
    System.out.println("-----------------------------------------------------------------------------------------");

    // Display the sorted order data
    for (int i = 0; i < numOrders; i++) {
        System.out.printf("%-10s %-15s %-10s %-10s %-10s%n", 
            orderData[i][0], // Formatted Order ID
            orderData[i][1], // Customer ID
            orderData[i][2], // Size
            orderData[i][3], // Quantity
            orderData[i][4]  // Amount
        );
    }
    System.out.println();
    System.out.print("To access the main menu, please enter 0 : ");
    int choice = input.nextInt();
     if (choice==0) {
         clearConsole();
         homePage();
     }else{
         System.out.println("Invalid input..Please enter again!");
         sortItemsByAmount();
         }
}












		
	


    public static void homePage() {
		System.out.println("          		 /$$$$$$$$                 /$$       /$$                            /$$$$$$  /$$");                          
		System.out.println("          | $$_____/                | $$      |__/                           /$$__  $$| $$");                          
		System.out.println("          | $$    /$$$$$$   /$$$$$$$| $$$$$$$  /$$  /$$$$$$  /$$$$$$$       | $$  \\__/| $$$$$$$   /$$$$$$   /$$$$$$"); 
		System.out.println("          | $$$$$|____  $$ /$$_____/| $$__  $$| $$ /$$__  $$| $$__  $$      |  $$$$$$ | $$__  $$ /$$__  $$ /$$__  $$");
		System.out.println("          | $$__/ /$$$$$$$|  $$$$$$ | $$  \\ $$| $$| $$  \\ $$| $$  \\ $$       \\____  $$| $$  \\ $$| $$  \\ $$| $$  \\ $$");
		System.out.println("          | $$   /$$__  $$ \\____  $$| $$  | $$| $$| $$  | $$| $$  | $$       /$$  \\ $$| $$  | $$| $$  | $$| $$  | $$");
		System.out.println("          | $$  |  $$$$$$$ /$$$$$$$/| $$  | $$| $$|  $$$$$$/| $$  | $$      |  $$$$$$/| $$  | $$|  $$$$$$/| $$$$$$$/");
		System.out.println("          |__/   \\_______/|_______/ |__/  |__/|__/ \\______/ |__/  |__/       \\______/ |__/  |__/ \\______/ | $$____/"); 
		System.out.println("                                                                                                          | $$");      
		System.out.println("                                                                                                          | $$");      
		System.out.println("                                                                                                          |__/");
		System.out.println();
		System.out.println();
		System.out.println("____________________________________________________________________________________________________________________");
		System.out.println();
		System.out.println();
		System.out.printf("%s%60s","[1] Place Order","[2] Search Customer\n");
		System.out.printf("%s%56s","[3] Search Order","[4] View Reports\n");
		System.out.printf("%s%51s","[5] Set Order Status","[6] Delete Order\n");
		System.out.println();
		System.out.println();
		System.out.print("Input Option :");
		
		int decision = input.nextInt();
		
		switch(decision){
			case 1:
				placeOrder();
			break;
			
			case 2:
			    searchCustomer();
			break;
			
			case 3:
				searchOrder	();
			break;
			
			case 4:
			    viewReports();
			break;
			
			case 5:
			break;
			
			case 6:
				deleteOrder();
			break;
			}
  
    }

    public static void main(String args[]) {

        homePage();

        //System.out.println(Arrays.toString(orders));
        //System.out.println(Arrays.toString(customers));
        //System.out.println(Arrays.toString(tsizes));
        //System.out.println(Arrays.toString(qty));


    }

    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
                if (os.contains("Windows")) {
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                } else {
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                }
        } catch (final Exception e) {
                e.printStackTrace();
                // Handle any exceptions.
        }
    }
}
