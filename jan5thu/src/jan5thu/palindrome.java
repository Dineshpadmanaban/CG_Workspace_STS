package jan5thu;

import java.util.Scanner;

public class palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		String str;
		Palindro obj = (s) ->{
			boolean a1 = false;
			int n = s.length()/2;
			int j = s.length()-1;
			for(int i=0;i<n;i++) {
				if(j!=0) {
					if(s.charAt(i) ==  s.charAt(j))
						a1 = true;
					else
						a1 = false;
					j--;
				}
			}
			System.out.println("The Given String Palindrome :" +a1);
		};
		System.out.println("Enter the String to Check whether Palindrome or Not : ");
		str = sc.next();
		obj.StringPalindrome(str);

	}

}
