import java.util.*;
class LoanCalculator{
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		
		System.out.println("----------------------------------------------------------------------");
		System.out.println("|                    Calculate Loan Amount                           |");
		System.out.println("----------------------------------------------------------------------");
		System.out.println();
		System.out.println();
		
		System.out.print("Input Employee name   - ");
		String empName = input.nextLine();
		System.out.print("Input Employee salary - ");
		double salary = input.nextDouble();
		System.out.print("Enter number of years - ");
		int year = input.nextInt();
		
		if(year>5){
			System.out.println("The max number of year is 5!");
		}
		 else if(salary<50000){
			System.out.println("You can't get a loan!");
		}else{
		
		double r = 0.15/12;
		double month = year * 12;
		double installment = salary * 0.6;
		double x = Math.pow(1+r,month);
		
		double loanAmount = (installment * (1-(1/x)))/r;
		
		System.out.println("You can get loan amount  -" +Math.round(loanAmount));
	}
		
		
		
		
		
		
	}
}
