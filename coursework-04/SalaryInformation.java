import java.util.*;
class SalaryInformation{
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		
		System.out.println("----------------------------------------------------------------------");
		System.out.println("|                    SALARY INFORMATION SYSTEM                       |");
		System.out.println("----------------------------------------------------------------------");
		System.out.println();
		
		System.out.println("      [1] Calculate Income Tax");
		System.out.println("      [2] Calculate Annual Bonus");
		System.out.println("      [3] Calculate Loan Amount");
		System.out.println();
		
		System.out.println("Enter an option to continue > ");
		int optionNo = input.nextInt();
		
		switch(optionNo){
			case 1:
			System.out.println("----------------------------------------------------------------------");
		System.out.println("|                    Calculate Income Tax                            |");
		System.out.println("----------------------------------------------------------------------");
		System.out.println();
		System.out.println();
		
		System.out.print("Input Employee name   - ");
		String empName1 = input.nextLine();
		input.nextLine();
		System.out.print("Input Employee salary - ");
		double salary1 = input.nextDouble();
		
		double tax;
		
		if(salary1<100000){
			tax = 0;
		}else if(salary1>=100000 && salary1<=141667){
			tax = (salary1-100000)*0.06;
		}else if(salary1>141667 && salary1<=183333){
			tax = (41667*0.06)+(salary1-141667)*0.12;
		}else if(salary1>183333 && salary1<=225000){
			tax = (41667*0.06)+(41667*0.12)+((salary1-183333)*0.18);
		}else if(salary1>225000 && salary1<=266667){
			tax = (41667*0.06)+(41667*0.12)+(41667*0.18)+((salary1-225000)*0.24);
		}else if(salary1>266667 && salary1<=308333){
			tax = (41667*0.06)+(41667*0.12)+(41667*0.18)+(41667*0.24)+((salary1-266667)*0.3);
		}else{
			tax = (41667*0.06)+(41667*0.12)+(41667*0.18)+(41667*0.24)+(41667*0.3)+((salary1-308333)*0.36);
		}
		System.out.println("Your income tax is : "+Math.round(tax));
			break;
			
			case 2:
		System.out.println("----------------------------------------------------------------------");
		System.out.println("|                    Calculate Annual Bonus                          |");
		System.out.println("----------------------------------------------------------------------");
		System.out.println();
		System.out.println();
		
		System.out.print("Input Employee name   - ");
		input.nextLine();
		String empName2 = input.nextLine();
		System.out.print("Input Employee salary - ");
		double salary2 = input.nextDouble();
		
		double bonus;
		
		if(salary2<100000){
			bonus = 5000;
		}else if(salary2<199999){
			bonus = salary2 * 0.1;
		}else if(salary2<299999){
			bonus = salary2 * 0.15;
		}else if(salary2<399999){
			bonus = salary2 * 0.2;
		}else{
			bonus = salary2 * 0.35;
		}
		System.out.print("Annual bonus  - "+bonus);
			break;
			
			case 3:
		System.out.println("----------------------------------------------------------------------");
		System.out.println("|                    Calculate Loan Amount                           |");
		System.out.println("----------------------------------------------------------------------");
		System.out.println();
		System.out.println();
		
		System.out.print("Input Employee name   - ");
		input.nextLine();
		String empName3 = input.nextLine();
		System.out.print("Input Employee salary - ");
		double salary3 = input.nextDouble();
		System.out.print("Enter number of years - ");
		int year = input.nextInt();
		
		if(year>5){
			System.out.println("The max number of year is 5!");
		}
		 else if(salary3<50000){
			System.out.println("You can't get a loan!");
		}else{
		
		double r = 0.15/12; // monthly interest
		double month = year * 12;
		double installment = salary3 * 0.6;
		double x = Math.pow(1+r,month);
		
		double loanAmount = (installment * (1-(1/x)))/r;
		
		System.out.println("You can get loan amount  -  " +Math.round(loanAmount));
	}
			break;
			default:
			System.out.print("Invalid Input");
	}
}
}

