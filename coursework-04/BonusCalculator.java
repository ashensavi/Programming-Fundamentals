import java.util.*;
class BonusCalculator{
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		
		System.out.println("----------------------------------------------------------------------");
		System.out.println("|                    Calculate Annual Bonus                          |");
		System.out.println("----------------------------------------------------------------------");
		System.out.println();
		System.out.println();
		
		System.out.print("Input Employee name   - ");
		String empName = input.nextLine();
		System.out.print("Input Employee salary - ");
		double salary = input.nextDouble();
		
		double bonus;
		
		if(salary<100000){
			bonus = 5000;
		}else if(salary<199999){
			bonus = salary * 0.1;
		}else if(salary<299999){
			bonus = salary * 0.15;
		}else if(salary<399999){
			bonus = salary * 0.2;
		}else{
			bonus = salary * 0.35;
		}
		System.out.print("Annual bonus  - "+bonus);
	}
}
