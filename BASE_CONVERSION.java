package String;

import java.util.Scanner;

public class BASE_CONVERSION {
		public static String convertBase(String numAsString , int bl, int b2) {
			boolean isNegative = numAsString.startsWith("-");
			int numAsInt = 0;
			for (int i = (isNegative ? 1 : 0); i < numAsString.length(); ++i) {
			numAsInt *= bl ;
			numAsInt += Character.isDigit(numAsString.charAt(i))? numAsString .charAt(i) - '0': numAsString .charAt(i) - 'A'+ 10;
			}
			return (isNegative ?"-" : "")+ (numAsInt == 0 ? "0" : constructFromBase(numAsInt , b2));
			}
			private static String constructFromBase(int numAsInt, int base) {
			return numAsInt == 0? "": constructFromBase(numAsInt / base, base)+ (char)(numAsInt % base >= 10 ? 'A' + numAsInt % base - 10: '0'+ numAsInt % base);
			
	}
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the String : ");
			String s=sc.nextLine();
			System.out.println("Enter the base1 : ");
			int b1=sc.nextInt();
			System.out.println("Enter the base2 : ");
			int b2=sc.nextInt();
			System.out.println("After the base Conversion , The result is : ("+s+")"+b1+" ---> ("+convertBase(s,b1,b2)+")"+b2);
			sc.close();
		}

	
}
