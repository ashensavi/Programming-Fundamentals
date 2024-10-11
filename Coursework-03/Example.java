/*import java.util.*;
class Example{
	public static void main(String args[]){
		Scanner input=new Scanner(System.in);
		System.out.print("Input salary: ");
		double salary=input.nextDouble();
		
		salary=salary>=50000 ? salary*0.75 : salary*0.85; //this can also write as salary*=salary>=50000 ? 0.75 : 0.85
		System.out.print("Net Salary "+salary);
		
	}
}

import java.util.*;
class Example{
	public static void main(String args[]){
		Scanner input=new Scanner(System.in);
		System.out.print("Input an integer : ");
		int num=input.nextInt();
		if(num==1){
			System.out.println("Number 1");
		}else if(num==2){
			System.out.println("Number 2");
		}else if(num==3){
			System.out.println("Number 3");
		}else if(num==4){
			System.out.println("Number 4");
		}else{
			System.out.println("Wrong Number");
		}
	}
}
*/
import java.util.*;
class Example{
	public static void main(String args[]){
		Scanner input=new Scanner(System.in);
		System.out.print("Input an integer : ");
		int month=input.nextInt();
		switch(month){
			case 1 :
			case 3 :
            case 5 :
		    case 7 :
		    case 8 :
			case 10 :
			case 12 :
				System.out.println("31 days");
				break;
			case 4 :
			case 6 :
			case 9 :
			case 11:
				System.out.println("30 days");
				break;
			case 2 :
				System.out.println("28 days");
				break;
			default:
				System.out.println("Wrong Number");
		}
	}
} 

