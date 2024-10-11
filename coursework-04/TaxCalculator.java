import java.util.*;
class TaxCalculator{
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		
		System.out.println("----------------------------------------------------------------------");
		System.out.println("|                    Calculate Income Tax                            |");
		System.out.println("----------------------------------------------------------------------");
		System.out.println();
		System.out.println();
		
		System.out.print("Input Employee name   - ");
		String empName = input.next();
		System.out.print("Input Employee salary - ");
		double salary = input.nextDouble();
		
		double tax;
		
		if(salary<100000){
			tax = 0;
		}else if(salary>=100000 && salary<=141667){
			tax = (salary-100000)*0.06;
		}else if(salary>141667 && salary<=183333){
			tax = (41667*0.06)+(salary-141667)*0.12;
		}else if(salary>183333 && salary<=225000){
			tax = (41667*0.06)+(41667*0.12)+((salary-183333)*0.18);
		}else if(salary>225000 && salary<=266667){
			tax = (41667*0.06)+(41667*0.12)+(41667*0.18)+((salary-225000)*0.24);
		}else if(salary>266667 && salary<=308333){
			tax = (41667*0.06)+(41667*0.12)+(41667*0.18)+(41667*0.24)+((salary-266667)*0.3);
		}else{
			tax = (41667*0.06)+(41667*0.12)+(41667*0.18)+(41667*0.24)+(41667*0.3)+((salary-308333)*0.36);
		}
		System.out.println("Your income tax is : "+Math.round(tax));
	}
} 
