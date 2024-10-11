import java.util.*;
class decimalconverter{
	public static void main(String args[]){
		
		Scanner input = new Scanner(System.in);
	
		System.out.println("+------------------------------------------------------+");
		System.out.println("|                 Decimal Converter                    |");
		System.out.println("+------------------------------------------------------+");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		System.out.print("Enter a Decimal Number: ");
		int firstNum = input.nextInt();
		
		String binary = "";
	    
	    while(firstNum>0){
	    int remainder = firstNum%2;
	    binary = remainder+binary;
	    firstNum=firstNum/2;
	}
		System.out.println("Binary Number: " +binary);
		
		String octal = "";
		int num=firstNum;
		while(firstNum>0){
			int remainder = firstNum%8;
			octal = remainder + octal;
			firstNum=firstNum/8;
		}
		System.out.println("Octal Number: " +octal);
	}
}


