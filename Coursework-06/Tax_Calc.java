import java.util.*;
class Tax_Calc{
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		
		System.out.println("                                        __   ______   ________  ________"); 
		System.out.println("                                       |  \\\\ /      \\ |        \\|        \\");
		System.out.println("                                       \\$$|  $$$$$$\\| $$$$$$$$ \\$$$$$$$$");
		System.out.println("                                       |  \\| $$   \\$$| $$__       | $$");   
		System.out.println("                                       | $$| $$      | $$  \\      | $$");   
		System.out.println("                                       | $$| $$   __ | $$$$$      | $$");   
		System.out.println("                                       | $$| $$__/  \\| $$_____    | $$");   
		System.out.println("                                       | $$ \\$$    $$| $$     \\   | $$");   
		System.out.println("                                        \\$$  \\$$$$$$  \\$$$$$$$$    \\$$");  
		System.out.println();
		System.out.println();

		System.out.println("            _______       __   __   _____          _      _____ _    _ _            _______ ____  _____");  
		System.out.println("           |__   __|/\\    \\ \\ / /  / ____|   /\\   | |    / ____| |  | | |        /\\|__   __/ __ \\|  __ \\"); 
		System.out.println("              | |  /  \\    \\ V /  | |       /  \\  | |   | |    | |  | | |       /  \\  | | | |  | | |__) |");
		System.out.println("              | | / /\\ \\    > <   | |      / /\\ \\ | |   | |    | |  | | |      / /\\ \\ | | | |  | |  _  /"); 
		System.out.println("              | |/ ____ \\  / . \\  | |____ / ____ \\| |___| |____| |__| | |____ / ____ \\| | | |__| | | \\ \\"); 
		System.out.println("              |_/_/    \\_\\/_/ \\_\\  \\_____/_/    \\_\\______\\_____|\\____/|______/_/    \\_\\_|  \\____/|_|  \\_\\"); 
           
		System.out.println();
		System.out.println();

		System.out.println("===================================================================================================================");
		System.out.println();
		System.out.println();       

		System.out.println("    [1] Withholding Tax\n");
		System.out.println("    [2] Payable Tax\n");
		System.out.println("    [3] Income Tax\n");
		System.out.println("    [4] Social Security Contribution Levy (SSCL) Tax\n");
		System.out.println("    [5] Leasing Payment\n");
		System.out.println("    [6] Exit");

		System.out.println();
		System.out.println();
            
		System.out.print("Enter an option to continue ->");
		int option = input.nextInt();
		
		
		switch(option){
			
			case 1:
			clearConsole();
			System.out.println("+--------------------------------------------+");
			System.out.println("|          WITHHOLDING TAX                   |");
			System.out.println("+--------------------------------------------+");
			System.out.println();
			System.out.println();
			
			System.out.println("    [1] Rent Tax\n");
			System.out.println("    [2] Bank Interest Tax\n");
			System.out.println("    [3] Dividend Tax\n");
			System.out.println("    [4] Exit");
			System.out.println();
			System.out.print("Enter an option to continue ->");
			int withholdOption = input.nextInt();
			
			switch(withholdOption){
				case 1:
				clearConsole();
			   getRentTax(input);
				break;
			case 2:
			clearConsole();
			   getBankInterest(input);
				break;
			case 3:
			clearConsole();
				getDividendTax(input);
				break;
			case 4:
			clearConsole();
				System.out.println("Do you want to go back to main menu (Y/N) :");
					
					char choice = input.next().charAt(0);
				if(choice=='Y'||choice=='y'){
					main(args);
					}
				clearConsole();
				System.exit(0);
				break;
			default:
			clearConsole();
				System.out.println("Wrong input!");
				System.out.println("Do you want to try again? (Y/N)");
		    break;
		    }
		    break;
			case 2:
			clearConsole();
				getPayableTax(input);
				break;
			case 3:
			clearConsole();
				getIncomeTax(input);
				break;
			case 4:
			clearConsole();
				getssclTax(input);
				break;
			case 5:
			clearConsole();
			System.out.println("+--------------------------------------------+");
			System.out.println("|          LEASING PAYMENT                   |");
			System.out.println("+--------------------------------------------+");
			System.out.println();
			System.out.println();
			
			System.out.println("    [1] Calculate Monthly Installment\n");
			System.out.println("    [2] Search Leasing Category\n");
			System.out.println("    [3] Find Leasing Amount\n");
			System.out.println("    [4] Exit");
			System.out.println();
			System.out.print("Enter an option to continue ->");
			int leasingOption = input.nextInt();
			
			switch(leasingOption){
				case 1:
				clearConsole();
					getMonthlyInstallment(input);
				break;
				
				case 2:
				clearConsole();
					searchLeasingCategory(input);
				break;
				
				case 3:
				clearConsole();
				    getLeasingAmount(input);
				case 4:
				clearConsole();
					System.exit(0);
				break;
			}
			case 6:
				System.exit(0);
				break;
			}
				
	}


	
	 public static void getRentTax(Scanner input){
		
		    System.out.println("+--------------------------------------------+");
			System.out.println("|                 RENT TAX                   |");
			System.out.println("+--------------------------------------------+");
			System.out.println();
			
			System.out.print("  Enter your rent                      : ");
			double rent = input.nextDouble();
			
			if(rent<100000 && rent>0){
				System.out.println("      You don't have to pay rent tax...");
				}else if(rent<0){
					System.out.println("              Invalid input...");
					}else{
					rent=(rent-100000)*0.1;
					System.out.print("  You have to pay Rent tax       : "+rent);
					}
					
					
					System.out.println();
					System.out.println();
					
					System.out.println("Do you want to calculate another rent tax (Y/N) :");
					
					char choice = input.next().charAt(0);
				if(choice=='Y'||choice=='y'){
					getRentTax(input);
					}
				System.out.println("Do you want to go back to main menu (Y/N) :");
					
					char choice1 = input.next().charAt(0);
				if(choice=='Y'||choice=='y'){
					}
				clearConsole();
				System.exit(0);
			}
			
			public static void getBankInterest(Scanner input){
				
				
				System.out.println("+--------------------------------------------+");
				System.out.println("|                 BANK INTEREST TAX          |");
				System.out.println("+--------------------------------------------+");
				System.out.println();
			
				System.out.print("  Enter your bank interest per year                     : ");
				double bankInterest = input.nextDouble();
				
				double bankInterestTax = bankInterest*0.05;
				
				System.out.println("You have to pay bank interest tax per year : "+bankInterestTax);
				
				System.out.println();
					System.out.println();
					
					System.out.println("Do you want to calculate another rent tax (Y/N) :");
				
				char choice = input.next().charAt(0);
				if(choice=='Y'||choice=='y'){
					getBankInterest(input);
					}
				clearConsole();
			}
			
			public static void getDividendTax(Scanner input){
		
		    System.out.println("+--------------------------------------------+");
			System.out.println("|                 DIVIDEND TAX                   |");
			System.out.println("+--------------------------------------------+");
			System.out.println();
			
			System.out.print("Enter your total dividend per year: ");
			double dividend = input.nextDouble();
			
			if(dividend<100000 && dividend>0){
				System.out.println("      You don’t have to pay Dividend Tax…");
				}else if(dividend<0){
					System.out.println("              Invalid input...");
					}else{
					dividend=(dividend-100000)*14/100;
					System.out.print("  You have to pay Rent tax       : "+dividend);
					}
					
					
					System.out.println();
					System.out.println();
					
					System.out.println("Do you want to calculate another dividend tax (Y/N) :");
				
				char choice = input.next().charAt(0);
				if(choice=='Y'||choice=='y'){
					getDividendTax(input);
					}
				clearConsole();
				
			}
				
			public static void getPayableTax(Scanner input){
		    
		    
		    System.out.println("+--------------------------------------------+");
			System.out.println("|                 PAYABLE TAX                   |");
			System.out.println("+--------------------------------------------+");
			System.out.println();
			
			System.out.print("Enter your employee payment per month: ");
			double empPayment = input.nextDouble();
			double Payabletax=0;
			
			if(empPayment<100000 && empPayment>0){
				System.out.println("You don't have to pay Payable tax...");
			}else if(empPayment<0){
				System.out.println("Invalid input...");
			}else if(empPayment>=100000 && empPayment<=141667){
			Payabletax = (empPayment-100000)*0.06;
			}else if(empPayment>141667 && empPayment<=183333){
			Payabletax = (41667*0.06)+(empPayment-141667)*0.12;
			}else if(empPayment>183333 && empPayment<=225000){
			Payabletax = (41667*0.06)+(41667*0.12)+((empPayment-183333)*0.18);
			}else if(empPayment>225000 && empPayment<=266667){
			Payabletax = (41667*0.06)+(41667*0.12)+(41667*0.18)+((empPayment-225000)*0.24);
			}else if(empPayment>266667 && empPayment<=308333){
			Payabletax = (41667*0.06)+(41667*0.12)+(41667*0.18)+(41667*0.24)+((empPayment-266667)*0.3);
			}else{
			Payabletax = (41667*0.06)+(41667*0.12)+(41667*0.18)+(41667*0.24)+(41667*0.3)+((empPayment-308333)*0.36);
			System.out.println("Your Payable Tax is : "+Math.round(Payabletax));
			}
			
			
					
					System.out.println();
					System.out.println();
					
					System.out.println("Do you want to calculate another Payable Tax (Y/N) :");
					
					
				char choice = input.next().charAt(0);
				if(choice=='Y'||choice=='y'){
					getPayableTax(input);
					}
				clearConsole();
				
			
		}
		
	    public static void getIncomeTax(Scanner input){
	
		    
		    System.out.println("+--------------------------------------------+");
			System.out.println("|                 INCOME TAX                    |");
			System.out.println("+--------------------------------------------+");
			System.out.println();
			
			System.out.print("Enter your total income per year   : ");
			double totalIncome = input.nextDouble();
			double incomeTax=0;
			if(totalIncome<1200000 && totalIncome>0){
				System.out.println("You don't have to pay Payable tax...");
			}else if(totalIncome<0){
				System.out.println("Invalid input...");
			}else if(totalIncome>=1200000 && totalIncome<=1700000){
			incomeTax = (totalIncome-1200000)*0.06;
			}else if(totalIncome>1700000 && totalIncome<=2200000){
			incomeTax = (500000*0.06)+(totalIncome-1700000)*0.12;
			}else if(totalIncome>2200000 && totalIncome<=2700000){
			incomeTax = (500000*0.06)+(500000*0.12)+((totalIncome-2200000)*0.18);
			}else if(totalIncome>2700000 && totalIncome<=3200000){
			incomeTax = (500000*0.06)+(500000*0.12)+(500000*0.18)+((totalIncome-2700000)*0.24);
			}else if(totalIncome>3200000 && totalIncome<=3700000){
			incomeTax = (500000*0.06)+(500000*0.12)+(500000*0.18)+(500000*0.24)+((totalIncome-3200000)*0.3);
			}else{
			incomeTax = (500000*0.06)+(500000*0.12)+(500000*0.18)+(500000*0.24)+(500000*0.30)+((totalIncome-3700000)*0.36);
			System.out.println("You have to pay income tax per year : "+Math.round(incomeTax));
			}
			
			
					
					System.out.println();
					System.out.println();
					
					System.out.println("Do you want to calculate another Income Tax (Y/N) :");
					char choice = input.next().charAt(0);
				if(choice=='Y'||choice=='y'){
					getIncomeTax(input);
					}
				clearConsole();
			
			}
			
			public static void getssclTax(Scanner input){
			
		    
		    System.out.println("+-----------------------------------------------------+");
			System.out.println("|   SOCIAL SECURITY CONTRIBUTION LEVY (SSCL) TAX      |");
			System.out.println("+-----------------------------------------------------+");
			System.out.println();
			
			System.out.print("Enter value of Good or Service  : ");
			double valueofGoods = input.nextDouble();
		    
		    double salesTax = valueofGoods*0.025;
		    double vat = (valueofGoods+salesTax)*0.15;
		    
		    
		    double totalSSCL = salesTax+vat;
		   
		    System.out.println();
			
			System.out.println("You have to pay SSCL Tax : "+Math.round(totalSSCL));
			
					
					System.out.println();
					System.out.println();
					
					System.out.println("Do you want to calculate another SSCL Tax (Y/N) :");
					
					
				char choice = input.next().charAt(0);
				if(choice=='Y'||choice=='y'){
					getssclTax(input);
					}
				clearConsole();
				
			}
		
			
			public static void getMonthlyInstallment(Scanner input){
		    
		    
		    System.out.println("+-----------------------------------------------------+");
			System.out.println("|                CALCULATE LEASING PAYMENT            |");
			System.out.println("+-----------------------------------------------------+");
			System.out.println();
			
			System.out.print("Enter lease amount  : ");
			double leaseAmount = input.nextDouble();
			
			System.out.print("Enter annual interest rate  : ");
			double annualInterestRate = input.nextDouble();
			
			System.out.print("Enter number of years  : ");
			int numofYears = input.nextInt();
		    
		  
		     //A  x  i  /  ( 1 – (1 / (1 + i )n ))|A - lease amount  n - number of month   i-annual intere rate/12
		    double i = (annualInterestRate/100)/12;
		    double n = numofYears*12;
		    double a = leaseAmount;
		    double monthlyInstallment= a * i / (1 - (1 / Math.pow(1 + i, n)));


		    
		    
		    System.out.println();
			
			System.out.printf("%s%.2f","your monthly installment : ",monthlyInstallment);
			
					
					System.out.println();	
					System.out.println();
					
					System.out.println("Do you want to calculate another monthly installment (Y/N) :");
					
					
				char choice = input.next().charAt(0);
				if(choice=='Y'||choice=='y'){
					getMonthlyInstallment(input);
					}
				clearConsole();
				
				}
				
			public static void searchLeasingCategory(Scanner input){
			System.out.println("+-----------------------------------------------------+");
			System.out.println("|                SEARCH LEASING CATEGORY              |");
			System.out.println("+-----------------------------------------------------+");
			System.out.println();
			
			System.out.print("Enter lease amount  : ");
			double leaseAmount = input.nextDouble();
			
			System.out.println();
			
			System.out.print("Enter annual interest rate  : ");
			double annualInterestRate = input.nextDouble();
		    
		  
		     //A  x  i  /  ( 1 – (1 / (1 + i )n ))|A - lease amount  n - number of month   i-annual intere rate/12
		    double i = (annualInterestRate/100)/12;
		    double for3Years = 3*12;
		    double for4Years = 4*12;
		    double for5Years = 5*12;
		    double a = leaseAmount;
		    double monthlyInstallment_01= a * i / (1 - (1 / Math.pow(1 + i, for3Years)));
		    double monthlyInstallment_02= a * i / (1 - (1 / Math.pow(1 + i, for4Years)));
		    double monthlyInstallment_03= a * i / (1 - (1 / Math.pow(1 + i, for5Years)));


		    
		    
		    System.out.println();
			
		
			System.out.printf("%s%.2f","your monthly installment for 3 year leasing plan : ",monthlyInstallment_01);
			System.out.println();
			System.out.printf("%s%.2f","your monthly installment for 4 year leasing plan : ",monthlyInstallment_02);
			System.out.println();
			System.out.printf("%s%.2f","your monthly installment for 5 year leasing plan : ",monthlyInstallment_03);
			
					
					System.out.println();	
					System.out.println();
					
					System.out.println("Do you want to search another leasing category (Y/N) :");
					
					
				char choice = input.next().charAt(0);
				if(choice=='Y'||choice=='y'){
					getMonthlyInstallment(input);
					}
				clearConsole();
				
				}
			
			public static void getLeasingAmount(Scanner input){
		    
		    
		    System.out.println("+-----------------------------------------------------+");
			System.out.println("|                FIND LEASING AMOUNT                  |");
			System.out.println("+-----------------------------------------------------+");
			System.out.println();
			
			System.out.print("Enter monthly lease payment you can afford  : ");
			double monthlyInstallment = input.nextDouble();
			
			System.out.print("Enter number of years  : ");
			int numofYears = input.nextInt();	
			
			System.out.print("Enter annual interest rate  : ");
			double annualInterestRate = input.nextDouble();
			

		    
		  
		    
		    double i = (annualInterestRate/100)/12;
		    double n = numofYears*12;
		    //double monthlyInstallment= a * i / (1 - (1 / Math.pow(1 + i, n)));
		    double leaseAmount=monthlyInstallment*(1-(1/Math.pow(1+i,n)))/i;


		    
		    
		    System.out.println();
			
			System.out.printf("%s%.2f","You can get lease amount : ",leaseAmount);
			
					
					System.out.println();	
					System.out.println();
					
					System.out.println("Do you want to calculate another Lease Amount (Y/N) :");
					
					
				char choice = input.next().charAt(0);
				if(choice=='Y'||choice=='y'){
					getMonthlyInstallment(input);
					}
				clearConsole();
				
				}
				
				
				
			
			
			
			
			
			
			
			
			
			//code to clear the console----------------------------------------------
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

	

			

